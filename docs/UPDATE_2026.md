# Atualizacao Brasil 2026

## Fonte Auditada

- Pacote: `BRASFOOT DE PC ATUALIZADO 2026 (NOVAS TRANSFERENCIAS)`.
- Inventario: 35.981 arquivos, 541.241.353 bytes e 8.616 times `.ban`.
- Times legiveis: 8.615; clubes brasileiros: 954.
- Bloqueados: `libertad_par.ban` (stream corrompido) e `yenisey_rus.ban`
  (jogador sem nome).
- Os dois executaveis externos foram apenas identificados por hash. Nenhum
  deles entra no repositorio ou na copia jogavel.

O inventario reproduzivel e gerado em
`build\reports\update-2026-source.json` por:

```powershell
.\tools\brasfoot-data-tool.ps1 audit-source `
  --game "C:\caminho\para\atualizacao-2026" `
  --out .\build\reports\update-2026-source.json
```

## Lote Versionado

`exports\teams-2026-brazil-ab.json` contem exatamente os 40 participantes das
Series A e B de 2026 selecionados em
`reconstruction\config\data-update-2026-brazil.json`.

- Hash canonico dos dados: `4f9c6f90aab2e3aaddf6c02ace59e22a61d7545e83767b4c1adf4e9bdb4f25fc`.
- Recursos selecionados: 198 arquivos, sem ausencias obrigatorias.
- Hash dos recursos: `33c95f3b79ef7003a9e4716481b8c138a93f0279de46ecdc56972c04bb2fdb10`.
- Validacao: zero erros, quatro nomes duplicados e um elenco com 36 atletas.

O teste deterministico roda junto de `smokeTest`:

```powershell
cd .\reconstruction
.\gradlew.bat dataUpdate2026RoundTrip
```

## Copia Jogavel

```powershell
cd .\reconstruction
.\gradlew.bat assembleHybrid
cd ..
.\tools\assemble-update-2026.ps1 `
  -SourceRoot "C:\caminho\para\atualizacao-2026"
```

A saida fica em `build\Brasfoot22-23_2026_preview`. O script exige o manifesto,
confere os hashes copiados, nao altera a instalacao original e nao importa os
executaveis externos.

O pacote fornece uma base ampla e util, mas nao prova que cada elenco reflete
as transferencias de agosto de 2026. Essa verificacao editorial continua sendo
necessaria antes de tratar o lote como lancamento final.
