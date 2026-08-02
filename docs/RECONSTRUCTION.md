# Reconstrucao Da Engine

## Fonte Recuperada

- Sete executaveis originais protegidos por hash, de 2016 a 22/23.
- Atlas estrutural com classes, campos, metodos, recursos e transicoes anuais.
- Mapeamento Tiny v2 reversivel com zero identificadores ilegais e zero
  colisoes de caminhos.
- Decompilacao nomeada com 1.038 arquivos Java e nenhum marcador de erro do
  Vineflower.
- Reparos de descompilacao versionados e reproduziveis, com validacao exata do
  numero de ocorrencias alteradas.
- As 1.032 classes do Brasfoot foram promovidas, compiladas em conjunto para
  Java 8 e sobrepostas no build hibrido.
- As seis classes do carregador Eclipse Jar-in-Jar foram identificadas como
  dependencia externa e permanecem com os binarios originais.
- 1.107 membros sinteticos originais sao restaurados do bytecode durante a
  montagem para preservar os contratos binarios.
- As outras 1.161 entradas permanecem byte a byte identicas.
- O save completo de referencia, os 88 contratos serializaveis e os 703 times
  passaram os testes automatizados.
- O teste do save tambem valida o comportamento estrutural do calendario real:
  ordem das datas, limites do indice atual, temporada, ano inicial e contagem
  de partidas permanecem identicos apos a regravacao.
- Os 3.116 eventos de partida do save sao validados por tipo, vinculos,
  minuto, periodo e lado do time antes e depois da regravacao. Um segundo
  cenario executa diretamente todos os acessores essenciais de `MatchEvent`.
- As 2.312 partidas persistidas validam clubes, competicao, fase, estadio,
  indice do calendario, escalacoes, placar, eventos e arrays de estatisticas.
  Um cenario isolado recalcula um placar de 2x1 a partir dos eventos e confirma
  que `MatchEngine` continua transitorio.
- O fluxo basico de `MatchEngine` possui cenario isolado para alternancia do
  time ativo, selecao dentro dos limites, registro de gol e contadores de
  chutes, avancos e desarmes por setor. O mesmo cenario valida as formulas de
  forca por setor, contagem de defensores, posse total de 100% e selecao de
  assistente.
- A expansao de estadio possui cenario funcional isolado que confirma aumento
  de capacidade, consumo dos lugares pendentes e idempotencia.
- 82 classes ja possuem nomes semanticos. O nucleo legivel cobre
  `CareerState`, `GamePersistence`, `Competition`, `LeagueStage`,
  `KnockoutStage`, `TransferNegotiation`, `Match`, `MatchEvent` e
  `MatchEngine`, alem das competicoes concretas nacionais e internacionais.
  `ScheduleDay`, `StadiumExpansionProject` e os acessos centrais de temporada,
  data e agenda tambem estao nomeados.
- `applySemanticSourceMappings` migra referencias e imports de forma
  deterministica antes de atualizar o mapeamento Tiny.
- `applySemanticMemberMappings` migra membros estaticos, membros privados e
  metodos de instancia globalmente unicos de forma transacional. Os lotes ja
  cobrem a persistencia central, o estado essencial de `Match` e 290 membros
  recuperados no total.
- O mapa dos principais pontos de entrada esta em `docs/SEMANTIC_CORE.md`.

## Proximas Fases

1. Nomeacao semantica das regras de simulacao e estatisticas de partidas.
2. Testes funcionais dirigidos por cenarios para cada modulo identificado.
3. Pontos de extensao estaveis para novas regras sem quebrar saves existentes.
4. Atualizacao de dados 2026.
5. Novas mecanicas e modernizacao gradual da interface.

Classes serializaveis continuam protegidas pelo atlas de contratos e pelo save
de referencia. Nenhuma alteracao nesses modelos pode entrar sem ambos os testes.
