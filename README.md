# Brasfoot 22/23 Modkit

Ferramentas para preservar a instalacao original e editar dados externos do
Brasfoot 22/23 com seguranca.

## Fluxo principal

1. Compile a ferramenta:

```powershell
.\tools\compile.ps1
```

2. Exporte os times:

```powershell
.\tools\brasfoot-data-tool.ps1 export-teams --game C:\Brasfoot22-23 --out .\exports\teams.json
```

3. Edite `exports\teams.json`.

4. Importe para uma pasta de build:

```powershell
.\tools\brasfoot-data-tool.ps1 import-teams --in .\exports\teams.json --out .\build\Brasfoot22-23_2026\teams
```

5. Valide:

```powershell
.\tools\brasfoot-data-tool.ps1 validate --game-or-build .\build\Brasfoot22-23_2026
```

O executavel original nao precisa ser alterado para a primeira fase.

## Reconstrucao Da Engine

O pipeline de recuperacao incremental fica em `reconstruction/`. Ele gera uma
copia hibrida jogavel sem modificar `C:\Brasfoot22-23` e mantem executaveis e
codigo bruto decompilado fora do Git. Consulte `reconstruction/README.md`.
