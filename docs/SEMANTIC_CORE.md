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
| `game/ScheduleDay` | `best/a` | data, partidas, fases e eventos agendados |
| `stadium/StadiumExpansionProject` | `best/B` | obra, data de conclusao e novos lugares |

`GamePersistence` ja possui API fonte legivel: `careerState`,
`coachJobMarket`, `getOptions`, `saveCareer`, `loadCareer`,
`loadCareerInfo`, `saveOptions`, `preloadSoundFiles` e `getSoundFile`. Esses
nomes voltam aos identificadores oficiais somente na montagem final.

`CareerState` tambem expoe `getSeasonNumber`, `advanceSeason`,
`getScheduleDays`, `getCurrentScheduleIndex`, `getCurrentMatches`,
`getCurrentDate`, `getCurrentTimeMillis`, `getFirstSeasonYear` e os respectivos
ajustes essenciais. As obras de estadio podem ser consultadas, substituidas e
processadas por nomes diretos.

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
| `match/MatchEvent` | `best/A` | gols, cartoes, substituicoes e demais eventos |
| `match/MatchEngine` | `c/b` | probabilidades e processamento da simulacao |
| `core/GameConstants` | `best/aq` | codigos, tabelas e parametros globais |

`MatchEvent` expoe diretamente clube, tipo, subtipo, minuto, periodo,
jogadores principal e secundario, lado do time, confirmacao, texto e icone.
Esses acessos sao exercitados no JAR final e preservados pelo round-trip do
save de referencia.

`Match` identifica diretamente fase, competicao, indice do calendario, clubes
da casa e visitante, placar, estadio, titulares, reservas, jogadores em campo,
eventos, posse, finalizacoes, chutes no gol, chutes para fora, desarmes, passes
errados e faltas. A API funcional inclui os respectivos acessos, incrementos
de placar, `getEvents`, `getScheduleIndex`, `getMatchEngine` e
`recalculateScoreFromEvents`. O fluxo nomeado de substituicoes cobre limite,
jogadores utilizados, troca efetiva, desgaste e decisoes automaticas por
placar ou fadiga.

`MatchEngine` identifica a partida processada, os dois clubes, o time ativo,
o atacante selecionado, posses, gols, chutes, avancos e desarmes por setor. A
API nomeada cobre selecao inicial, alternancia de posse, disputa, avanco,
finalizacao, escolha de atacante/defensor, registro do evento de gol e as
formulas de forca de meio-campo, ataque, goleiro, atacante e defesa.

## Transferencias

| Fonte | Classe oficial | Papel |
|---|---|---|
| `transfer/PlayerSearchCriteria` | `best/af` | filtros da busca de jogadores |
| `transfer/AiSquadManager` | `best/ag` | manutencao de elencos e compras da IA |
| `transfer/PlayerTransferRecord` | `best/ap` | registro persistente de transferencia |
| `transfer/TransferNegotiation` | `best/l` | selecao de destino e avaliacao de proposta |
| `transfer/PlayerLoan` | `components/t` | prazo e retorno de jogador emprestado |
| `manager/CoachChangeRecord` | `best/u` | historico de troca de tecnicos |

`TransferNegotiation` expoe jogador, origem, destino, valor solicitado, valor
acordado, modo da transferencia, limite do elenco comprador, salario pedido,
contraproposta e estado de conclusao. Os fluxos nomeados cobrem busca de
destino, emprestimo, venda listada, avaliacao de oferta, interesse do jogador,
compatibilidade entre clube e atleta e reposicao do elenco vendedor. Um teste
executado no JAR final valida os estados de aceite, recusa, contraproposta e
pedido salarial sem efetivar uma transferencia na carreira de referencia.

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

`Player` identifica diretamente forca geral, posicao tatica, atleta da base,
velocidade, habilidade de goleiro, tecnica, passe, desarme, armacao,
finalizacao, atuacao fora de posicao, energia, forca efetiva, lesao e prazo
contratual. Forca, posicao, atributos e energia tambem possuem setters
diretos. `Club` identifica elenco principal e
da base, titulares, banco, tecnico, financas, esquema, ID, controle do usuario,
estado da escalacao e configuracoes taticas. A API nomeada tambem prepara as
escalacoes da IA, seleciona jogadores por posicao, monta titulares e reservas e
calcula a forca da equipe. Jogador, tecnico e componentes auxiliares usam
`getClub`; clube, partida e obra usam `getStadium`. Um cenario executado no
JAR final valida esses acessos e suas identidades.

`Player` tambem expoe renovacao contratual, estado de emprestimo, movimentacao
entre clubes, inicio e retorno de emprestimo. `PlayerLoan` expoe jogador, clube
de origem, prazo, vencimento, retorno e controle da notificacao de falha.

Os demais nomes semanticos de configuracao, comparadores e utilitarios ficam
registrados em `reconstruction/config/semantic-names.json`.
