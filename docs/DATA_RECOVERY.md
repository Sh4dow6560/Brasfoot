# Recuperacao Da Camada De Dados

## Concluido

- Save de referencia local protegido por SHA-256.
- Atlas de 88 classes que implementam serializacao diretamente.
- Contrato persistente de campos e `serialVersionUID` versionado.
- Sete tipos do pacote `est` recuperados e carregados no Java 8.
- `components/ag` recuperada como `LineupPreset` e validada no Java 8.
- Desserializacao de `est.InfoArquivoSalvoType` a partir do save existente.
- Preservacao automatica da pasta `sav` durante `assembleHybrid`.

## Modelos Identificados

| Classe oficial | Nome planejado | Papel | Campos persistentes |
|---|---|---|---:|
| `best/F` | `Player` | jogador | 55 |
| `best/ah` | `Club` | clube | 44 |
| `best/al` | `Coach` | tecnico | 23 |

## Proximo Lote

O proximo lote deve conter dependencias pequenas usadas por `Player` e `Club`,
priorizando classes identicas ao 2021. Os tres modelos principais somente serao
promovidos depois que suas dependencias diretas estiverem nomeadas e cobertas
por testes de serializacao.
