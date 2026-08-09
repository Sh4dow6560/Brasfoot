# Objetivos Da Diretoria

A primeira mecanica nova usa apenas o pacote `mod.extension` e o sidecar do
save. Nenhum campo foi adicionado aos 88 modelos Kryo originais.

## Ciclo Mensal

- A avaliacao roda uma vez no dia 2 de cada mes, depois dos eventos financeiros
  mensais do jogo.
- A primeira execucao da temporada cria a linha de base sem alterar a
  confianca do tecnico.
- As execucoes seguintes medem desempenho esportivo, resultado financeiro e
  confianca da torcida desde a ultima linha de base.
- Repetir o processamento do mesmo mes e idempotente: nao muda estado,
  confianca ou inbox.
- Os 24 relatorios mensais mais recentes ficam no modulo `boardObjectives` do
  arquivo `.modstate.json`.

## Regras

A meta esportiva varia de 32% a 62% de vitorias conforme divisao e reputacao.
A meta de torcida varia de 50% a 80%. O objetivo financeiro exige caixa nao
negativo e tolera uma perda mensal pequena, proporcional ao caixa do clube.

Cada mes resulta em `EXCEEDED`, `ON_TRACK`, `AT_RISK` ou `FAILED`. A variacao
de confianca da diretoria fica entre `-8` e `+4`. O indice de seguranca combina
75% da confianca da diretoria com 25% da torcida:

- `SECURE`: 75 a 100.
- `STABLE`: 50 a 74.
- `UNDER_PRESSURE`: 25 a 49.
- `CRITICAL`: 0 a 24.

A confianca atualizada continua alimentando a regra original de demissao do
jogo. Cada avaliacao valida tambem cria um relatorio na caixa de mensagens do
tecnico.

## Ativacao E Fallback

O ID da funcionalidade e `boardObjectives`. Ela permanece desligada por
padrao. `ModRuntime.setFeatureEnabled(Feature.BOARD_OBJECTIVES, true)` ativa a
funcao para a carreira atual; a escolha e gravada no sidecar no proximo save.
Com a funcao desligada, o hook retorna imediatamente e nao altera nenhum dado
do jogo original.

## Validacao

```powershell
.\gradlew.bat test modStateCompatibilityTest staticSmokeTest
```

Os testes cobrem inicializacao, meses bons e ruins, troca de temporada,
historico limitado, idempotencia, persistencia, Java 8, templates do inbox e
presenca dos hooks no JAR oficial remapeado.
