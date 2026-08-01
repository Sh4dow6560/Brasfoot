param(
  [Parameter(ValueFromRemainingArguments = $true)]
  [string[]]$ToolArgs
)

$ErrorActionPreference = "Stop"

$toolRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$bin = Join-Path $toolRoot "bin"
$GameExe = if ($env:BRASFOOT_GAME_EXE) { $env:BRASFOOT_GAME_EXE } else { "C:\Brasfoot22-23\bf22-23.exe" }

if (-not (Test-Path -LiteralPath (Join-Path $bin "BrasfootDataTool.class"))) {
  throw "Tool is not compiled. Run .\tools\compile.ps1 first."
}

if (-not (Test-Path -LiteralPath $GameExe)) {
  throw "Game executable not found: $GameExe"
}

java -cp "$bin;$GameExe" BrasfootDataTool @ToolArgs
exit $LASTEXITCODE
