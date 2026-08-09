$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $PSScriptRoot
$modkitRoot = Split-Path -Parent $projectRoot
$toolRoot = Join-Path $modkitRoot "tools"
$sourceJson = Join-Path $modkitRoot "exports\teams-2026-brazil-ab.json"
$selectionPath = Join-Path $projectRoot "config\data-update-2026-brazil.json"
$outputRoot = Join-Path $projectRoot "build\data-update-2026-roundtrip"
$imported = Join-Path $outputRoot "teams"
$roundTripJson = Join-Path $outputRoot "teams-roundtrip.json"

& (Join-Path $toolRoot "compile.ps1")

$selection = Get-Content -LiteralPath $selectionPath -Raw -Encoding UTF8 | ConvertFrom-Json
$source = Get-Content -LiteralPath $sourceJson -Raw -Encoding UTF8 | ConvertFrom-Json
$expected = @($selection.groups | ForEach-Object { $_.files }) | ForEach-Object { $_.ToLowerInvariant() } | Sort-Object
$actual = @($source.teams | ForEach-Object { $_.file.ToLowerInvariant() }) | Sort-Object
$difference = Compare-Object -ReferenceObject $expected -DifferenceObject $actual
if ($difference) {
  throw "Versioned 2026 JSON does not match the official A/B selection: $($difference | Out-String)"
}
if ($actual.Count -ne 40 -or @($source.teams | Where-Object { $_.pais -ne 29 }).Count -ne 0) {
  throw "Versioned 2026 JSON must contain exactly 40 Brazilian teams"
}

& (Join-Path $toolRoot "brasfoot-data-tool.ps1") import-teams --in $sourceJson --out $imported
& (Join-Path $toolRoot "brasfoot-data-tool.ps1") validate --game-or-build $imported --summary-only true
& (Join-Path $toolRoot "brasfoot-data-tool.ps1") export-teams --game $imported --out $roundTripJson
& (Join-Path $toolRoot "brasfoot-data-tool.ps1") compare-teams --left $sourceJson --right $roundTripJson
