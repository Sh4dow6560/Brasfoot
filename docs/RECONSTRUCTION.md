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
- As consultas ao enum de 224 paises usam o ID ordinal original, pois a
  recompilacao Java nao preserva os nomes internos `P0...P223` gravados pelo
  ofuscador. A mudanca nao adiciona membros nem altera o contrato binario.
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
- 83 classes ja possuem nomes semanticos. O nucleo legivel cobre
  `CareerState`, `GamePersistence`, `Competition`, `LeagueStage`,
  `KnockoutStage`, `TransferNegotiation`, `Match`, `MatchEvent` e
  `MatchEngine`, alem das competicoes concretas nacionais e internacionais.
  `ScheduleDay`, `StadiumExpansionProject` e os acessos centrais de temporada,
  data e agenda tambem estao nomeados.
- `Player` e `Club` agora identificam forca geral, posicao tatica, sete
  atributos individuais, elencos principal/base, titulares, banco, tecnico,
  financas, esquema, IDs, controle do usuario, vinculos e estadio. Esses
  contratos possuem cenario funcional no JAR final.
- O estado operacional de `Player` identifica energia, desgaste, recuperacao,
  forca efetiva, lesao e prazo contratual usando a data real da carreira.
- Setters semanticamente nomeados alteram forca geral, posicao tatica, os sete
  atributos e energia. Referencias ambiguas foram migradas de forma dirigida
  pelo tipo e recompiladas em conjunto.
- `Match` identifica o estado e o fluxo de substituicoes, incluindo limites,
  listas de jogadores utilizados, desgaste e decisoes automaticas por placar
  ou fadiga. Um cenario deterministico exercita a troca no JAR final.
- `Club` identifica configuracoes taticas, preparacao das escalacoes da IA,
  selecao de atletas por posicao, montagem de titulares e banco e calculo da
  forca resultante. Um cenario sintetico com 22 jogadores valida todo o fluxo.
- `Player` e `PlayerLoan` identificam renovacao contratual, movimentacao entre
  clubes, emprestimo, vencimento e retorno ao clube de origem. O cenario
  funcional limpa os registros sinteticos e preserva o save byte a byte.
- `TransferNegotiation` identifica estado, destino, valores, avaliacao de
  proposta, contraproposta, salario, emprestimo, venda listada e reposicao de
  elenco. O cenario funcional cobre os principais codigos de retorno e nao
  modifica os dados persistidos usados no round-trip.
- `Player` identifica estrela, destaque mundial, salario, valor de mercado,
  preco pedido e estados de venda e emprestimo. `AiSquadManager` identifica as
  fases sazonais de equilibrio, reposicao e movimentacao de atletas. O teste
  funcional executa todos os pontos de entrada com dados isolados e valida as
  protecoes contra movimentacoes indevidas.
- `applySemanticSourceMappings` migra referencias e imports de forma
  deterministica antes de atualizar o mapeamento Tiny.
- `applySemanticMemberMappings` migra membros estaticos, membros privados,
  metodos de instancia globalmente unicos e metodos sem argumentos sem
  colisao equivalente de forma transacional. Metodos repetidos sem argumentos
  podem ser unificados quando todo o grupo declara o mesmo nome. Os lotes ja
  cobrem a persistencia central, o estado essencial de `Match` e 490 membros
  recuperados no total.
- O mapa dos principais pontos de entrada esta em `docs/SEMANTIC_CORE.md`.

## Proximas Fases

1. Nomeacao semantica dos filtros, registros e historico de transferencias.
2. Testes funcionais dirigidos por cenarios para cada modulo identificado.
3. Pontos de extensao estaveis para novas regras sem quebrar saves existentes.
4. Atualizacao de dados 2026.
5. Novas mecanicas e modernizacao gradual da interface.

Classes serializaveis continuam protegidas pelo atlas de contratos e pelo save
de referencia. Nenhuma alteracao nesses modelos pode entrar sem ambos os testes.
