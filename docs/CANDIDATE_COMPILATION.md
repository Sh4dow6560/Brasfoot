# Compilacao Candidata

Analise isolada das fontes geradas pelo Vineflower. Cada arquivo usa o JAR nomeado apenas como dependencia binaria.

- Fontes analisadas: 1038
- Compilam sem alteracao: 1036
- Exigem correcao: 2
- Processos paralelos: 4

## Principais Bloqueios

| Diagnostico | Ocorrencias |
|---|---:|
|compiler.err.unreported.exception.need.to.catch.or.throw|2|
|compiler.err.prob.found.req|1|

## Primeiras Fontes Com Falha

| Fonte | Primeiro diagnostico | Linha |
|---|---|---:|
|bf22/intermediary/C1033.java|compiler.err.prob.found.req|95|
|bf22/intermediary/C1036.java|compiler.err.unreported.exception.need.to.catch.or.throw|23|
