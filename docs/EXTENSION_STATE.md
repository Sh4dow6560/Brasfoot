# Estado Lateral Das Extensoes

As novas mecanicas usam classes Java 8 no pacote `mod.extension`. O build
permite classes novas somente sob esse prefixo e preserva os 88 contratos Kryo
do jogo sem campos adicionais.

## Arquivo Por Save

Para um save `carreira.s22`, o estado fica em
`carreira.s22.modstate.json`, no mesmo diretorio. O schema atual e `1`:

```json
{
  "features": {
    "boardObjectives": true,
    "sponsorships": true
  },
  "modules": {
    "boardObjectives": {
      "latestProfile": "7@101",
      "lastEvaluationPeriod": 202602,
      "profiles": {}
    }
  },
  "revision": 1,
  "schemaVersion": 1
}
```

`FeatureRegistry` mantem todas as funcionalidades desativadas quando nao ha
override, preservando o comportamento original. Os IDs reservados sao:

- `boardObjectives`
- `sponsorships`
- `supporterMembership`
- `staffAndTraining`
- `scoutingNetwork`
- `advancedNegotiations`
- `tacticalAnalytics`

## Protecoes

- A gravacao usa arquivo temporario, sincronizacao em disco e troca atomica no
  mesmo diretorio.
- O SHA-256 carregado e a revisao impedem sobrescritas concorrentes.
- Arquivos corrompidos ou com schema futuro nunca sao sobrescritos.
- Sidecars maiores que 16 MiB sao recusados sem carregamento.
- Schema `0` e migrado em memoria e so e atualizado mediante gravacao valida.
- JSON aceita objetos, listas, strings UTF-8, booleanos, numeros e `null`, com
  profundidade limitada.

Execute a validacao no runtime real com:

```powershell
.\gradlew.bat modStateCompatibilityTest
```

O probe cobre estado ausente, atual, corrompido, antigo e futuro no Java 8.
Tambem executa a avaliacao mensal da diretoria, confirma idempotencia e
restaura o modulo depois de fechar e anexar novamente o save.
O mesmo probe valida ofertas, contrato, duracao, luvas, parcela, bonus e a
transicao idempotente da receita legada de patrocinadores.
