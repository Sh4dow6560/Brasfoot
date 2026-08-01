$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $PSScriptRoot
$modkitRoot = Split-Path -Parent $projectRoot
$toolRoot = Join-Path $modkitRoot "tools"
$workRoot = Join-Path $projectRoot "build\team-roundtrip"
$imported = Join-Path $workRoot "teams"
$roundTripJson = Join-Path $workRoot "teams-roundtrip.json"
$sourceJson = Join-Path $modkitRoot "exports\teams.json"

& (Join-Path $toolRoot "compile.ps1")

if (Test-Path -LiteralPath $workRoot) {
  $resolved = [System.IO.Path]::GetFullPath($workRoot)
  $expectedRoot = [System.IO.Path]::GetFullPath((Join-Path $projectRoot "build"))
  if (-not $resolved.StartsWith($expectedRoot, [System.StringComparison]::OrdinalIgnoreCase)) {
    throw "Refusing to remove path outside reconstruction build: $resolved"
  }
  Remove-Item -LiteralPath $workRoot -Recurse -Force
}

New-Item -ItemType Directory -Path $workRoot | Out-Null

& (Join-Path $toolRoot "brasfoot-data-tool.ps1") import-teams --in $sourceJson --out $imported
& (Join-Path $toolRoot "brasfoot-data-tool.ps1") validate --game-or-build $imported
& (Join-Path $toolRoot "brasfoot-data-tool.ps1") export-teams --game $imported --out $roundTripJson
& (Join-Path $toolRoot "brasfoot-data-tool.ps1") compare-teams --left $sourceJson --right $roundTripJson
