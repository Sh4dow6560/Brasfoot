param(
  [Parameter(Mandatory = $true)]
  [string]$SourceRoot,

  [string]$Output,

  [switch]$Force
)

$ErrorActionPreference = "Stop"

$toolRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$modkitRoot = Split-Path -Parent $toolRoot
$buildRoot = [IO.Path]::GetFullPath((Join-Path $modkitRoot "build"))
$hybridRoot = [IO.Path]::GetFullPath((Join-Path $buildRoot "Brasfoot22-23_hybrid"))
$selection = Join-Path $modkitRoot "reconstruction\config\data-update-2026-brazil.json"
$teamsJson = Join-Path $modkitRoot "exports\teams-2026-brazil-ab.json"
$dataTool = Join-Path $toolRoot "brasfoot-data-tool.ps1"

if ([string]::IsNullOrWhiteSpace($Output)) {
  $Output = Join-Path $buildRoot "Brasfoot22-23_2026_preview"
}
$outputRoot = [IO.Path]::GetFullPath($Output)
$buildPrefix = $buildRoot.TrimEnd([IO.Path]::DirectorySeparatorChar) + [IO.Path]::DirectorySeparatorChar
if (-not $outputRoot.StartsWith($buildPrefix, [StringComparison]::OrdinalIgnoreCase)) {
  throw "Output must stay inside the modkit build directory: $buildRoot"
}
if ($outputRoot.Equals($hybridRoot, [StringComparison]::OrdinalIgnoreCase)) {
  throw "Output cannot replace the base hybrid build"
}
if (-not (Test-Path -LiteralPath (Join-Path $hybridRoot "brasfoot-hybrid.jar"))) {
  throw "Hybrid build not found. Run reconstruction\gradlew.bat assembleHybrid first."
}
if (-not (Test-Path -LiteralPath $SourceRoot -PathType Container)) {
  throw "Update source not found: $SourceRoot"
}
if (Test-Path -LiteralPath $outputRoot) {
  if (-not $Force) {
    throw "Output already exists: $outputRoot. Pass -Force to rebuild it."
  }
  Remove-Item -LiteralPath $outputRoot -Recurse -Force
}

Copy-Item -LiteralPath $hybridRoot -Destination $outputRoot -Recurse
$outputTeams = Join-Path $outputRoot "teams"
& $dataTool import-teams --in $teamsJson --out $outputTeams
& $dataTool stage-resources --game $SourceRoot --selection $selection --out $outputTeams
& $dataTool validate --game-or-build $outputRoot --summary-only true

$roundTrip = Join-Path $outputRoot "teams-2026-selected.json"
& $dataTool export-teams --game $outputRoot --out $roundTrip --country 29 --selection $selection
& $dataTool compare-teams --left $teamsJson --right $roundTrip

$selectionData = Get-Content -LiteralPath $selection -Raw -Encoding UTF8 | ConvertFrom-Json
$resourceData = Get-Content -LiteralPath (Join-Path $outputTeams "update-resource-manifest.json") -Raw -Encoding UTF8 | ConvertFrom-Json
$manifest = [ordered]@{
  schemaVersion = 1
  builtAt = [DateTime]::UtcNow.ToString("yyyy-MM-dd'T'HH:mm:ss'Z'")
  sourceSnapshot = $selectionData.snapshot.id
  selectedTeams = 40
  selectedCanonicalTeamsSha256 = $selectionData.snapshot.selectedCanonicalTeamsSha256
  selectedResources = $resourceData.copiedFiles
  selectedResourceSetSha256 = $resourceData.resourceSetSha256
  hybridJarSha256 = (Get-FileHash -LiteralPath (Join-Path $outputRoot "brasfoot-hybrid.jar") -Algorithm SHA256).Hash.ToLowerInvariant()
  sourceExecutablesCopied = $false
}
$manifest | ConvertTo-Json -Depth 5 | Set-Content -LiteralPath (Join-Path $outputRoot "data-update-manifest.json") -Encoding UTF8

Write-Host "Playable 2026 preview assembled at $outputRoot"
