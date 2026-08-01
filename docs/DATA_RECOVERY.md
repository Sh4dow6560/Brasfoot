# Recuperacao Da Camada De Dados

## Concluido

- Save de referencia local protegido por SHA-256.
- Atlas de 88 classes que implementam serializacao diretamente.
- Contrato persistente de campos e `serialVersionUID` versionado.
- As 88 classes serializaveis diretas recuperadas em fonte e validadas no
  Java 8.
- Modelos centrais `Player`, `Club`, `Coach`, `ClubFinances` e `Stadium`
  recuperados com nomes semanticos.
- Carreira completa desserializada e serializada novamente com resultado byte
  a byte identico ao arquivo de referencia.
- Round-trip deterministico dos 703 arquivos de times aprovado.
- Preservacao automatica da pasta `sav` durante `assembleHybrid`.

## Modelos Identificados

| Classe oficial | Nome planejado | Papel | Campos persistentes |
|---|---|---|---:|
| `best/F` | `Player` | jogador | 55 |
| `best/ah` | `Club` | clube | 44 |
| `best/al` | `Coach` | tecnico | 23 |

## Proxima Fase

Nomear semanticamente os agregados de competicoes, calendario, simulacao e
transferencias. Cada alteracao nesses modulos deve continuar passando o teste
do save completo e o round-trip dos times.
