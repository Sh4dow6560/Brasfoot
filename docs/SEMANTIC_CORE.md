# Nucleo Semantico

As classes abaixo sao pontos de entrada legiveis para evoluir a engine. O nome
oficial continua sendo restaurado durante `assembleHybrid`, portanto saves e
chamadas binaras permanecem compativeis.

## Carreira E Persistencia

| Fonte | Classe oficial | Papel |
|---|---|---|
| `game/CareerState` | `best/f` | estado completo da carreira |
| `save/GamePersistence` | `c/a` | leitura de saves, backup e opcoes |
| `save/SavedGameInfo` | `est/InfoArquivoSalvoType` | metadados exibidos no carregamento |
| `manager/CoachJobMarket` | `best/ay` | propostas e mercado de tecnicos |

## Competicoes

| Fonte | Classe oficial | Papel |
|---|---|---|
| `competition/Competition` | `best/at` | contrato comum das competicoes |
| `competition/CompetitionStage` | `best/L` | base das fases jogaveis |
| `competition/CountryCompetitions` | `best/Z` | ligas e clubes de um pais |
| `competition/LeagueStage` | `f/s` | fase de liga e grupos |
| `competition/KnockoutStage` | `f/z` | fase eliminatoria |
| `competition/KnockoutRound` | `f/G` | confrontos de uma rodada eliminatoria |
| `competition/CompetitionSeasonResult` | `best/i` | campeao, vice e destaques da temporada |
| `competition/CompetitionPlayerStats` | `best/c` | estatisticas individuais na competicao |

## Partidas

| Fonte | Classe oficial | Papel |
|---|---|---|
| `match/Match` | `best/I` | estado, times, placar e estatisticas da partida |
| `match/MatchEngine` | `c/b` | probabilidades e processamento da simulacao |
| `core/GameConstants` | `best/aq` | codigos, tabelas e parametros globais |

## Transferencias

| Fonte | Classe oficial | Papel |
|---|---|---|
| `transfer/PlayerSearchCriteria` | `best/af` | filtros da busca de jogadores |
| `transfer/AiSquadManager` | `best/ag` | manutencao de elencos e compras da IA |
| `transfer/PlayerTransferRecord` | `best/ap` | registro persistente de transferencia |
| `transfer/TransferNegotiation` | `best/l` | selecao de destino e avaliacao de proposta |
| `manager/CoachChangeRecord` | `best/u` | historico de troca de tecnicos |

## Torneios Concretos

O pacote `competition` tambem contem nomes diretos para as competicoes
persistidas pela carreira: `WorldCup`, `CopaLibertadores`,
`UefaChampionsLeague`, `UefaEuropaLeague`, `UefaConferenceLeague`, os torneios
continentais de selecoes, as seis eliminatorias, ligas, copas nacionais,
estaduais, regionais e supercopas.

## Modelos E Interface

| Fonte | Classe oficial | Papel |
|---|---|---|
| `model/Player` | `best/F` | jogador |
| `model/Club` | `best/ah` | clube |
| `model/Coach` | `best/al` | tecnico |
| `model/Stadium` | `best/v` | estadio |
| `finance/ClubFinances` | `best/C` | financas do clube |
| `geo/CountryInfo` | `best/ad` | nome, bandeira e metadados de pais |
| `ui/MainWindow` | `best/S` | janela principal e navegacao |

Os demais nomes semanticos de configuracao, comparadores e utilitarios ficam
registrados em `reconstruction/config/semantic-names.json`.
