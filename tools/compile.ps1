param(
  [string]$Game = "C:\Brasfoot22-23"
)

$ErrorActionPreference = "Stop"

$toolRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$src = Join-Path $toolRoot "src\BrasfootDataTool.java"
$bin = Join-Path $toolRoot "bin"
$gameExe = Join-Path $Game "bf22-23.exe"

if (-not (Test-Path -LiteralPath $gameExe)) {
  throw "Game executable not found: $gameExe"
}

New-Item -ItemType Directory -Path $bin -Force | Out-Null
javac --release 8 -Xlint:-options -encoding UTF-8 -classpath $gameExe -d $bin $src
