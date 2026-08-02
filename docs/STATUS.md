# Status Da Reconstrucao

- Instalacao original: `C:\Brasfoot22-23`.
- Backup validado: `C:\Brasfoot22-23_BACKUP_20260703-173711`.
- ZIP de backup: `C:\Brasfoot22-23_BACKUP_20260703-173711\Brasfoot22-23_BACKUP_20260703-173711.zip`.
- Motivo do ZIP dentro da pasta: o Windows bloqueou a criacao de um arquivo
  `.zip` solto diretamente na raiz `C:\`.
- Escopo inicial: atualizacao 2026 por dados, sem alterar `bf22-23.exe`.
- Repositorio privado: `https://github.com/Sh4dow6560/Brasfoot`.
- Codigo-fonte: as 1.032 classes pertencentes ao jogo foram recuperadas,
  reparadas e compiladas em conjunto com alvo Java 8.
- Dependencias: as seis classes do carregador Eclipse Jar-in-Jar continuam como
  binarios externos; elas nao pertencem ao codigo do Brasfoot.
- Reconstrucao hibrida: 1.032 classes sobrepostas por fonte recuperada.
- Integridade: 1.161 recursos e entradas nao sobrepostas permanecem
  byte-identicos ao original.
- Serializacao: 88 contratos diretos preservam campos e `serialVersionUID`; o
  save completo foi lido e regravado byte a byte no Java 8.
- Save de referencia: tres arquivos preservados localmente por hash; o
  arquivo de carreira de 4.758.811 bytes passou round-trip identico.
- Cenario de calendario: a carreira real valida automaticamente 365 dias em
  ordem cronologica, indice atual 105, 44 dias com jogos e 2.312 partidas,
  antes e depois do round-trip.
- Dados: round-trip dos 703 times aprovado; existe um aviso preexistente de
  jogador duplicado em `vitoriaguimaraes_por.ban`.
- Interface: a copia hibrida abriu a janela principal do Brasfoot, e a carreira
  foi salva e carregada. Novas montagens agora preservam automaticamente a
  pasta `sav` da copia hibrida.
- Legibilidade: 83 classes e 490 membros mapeados possuem nomes validos ou
  semanticos. A API central de persistencia agora expoe nomes diretos para
  estado da carreira, opcoes, salvar, carregar, backups e sons.
- Calendario: `ScheduleDay` identifica cada data da temporada; `CareerState`
  expoe temporada, ano inicial, data atual, indice, partidas e dias agendados
  por nomes diretos.
- Partidas: `MatchEvent` expoe clube, jogadores, tipo, subtipo, minuto,
  periodo, lado e estados do evento. O save real valida 3.116 eventos dos oito
  tipos existentes, e a API passou um cenario funcional completo no Java 8.
- Estado de partida: `Match` agora identifica fase, competicao, indice do
  calendario, clubes, placar, estadio, seis listas de jogadores, eventos e
  sete grupos de estatisticas. O save valida 2.312 partidas, 652 gols e a
  ligacao exata com os 3.116 eventos. Os acessos e incrementos essenciais
  tambem sao executados diretamente no JAR final.
- Substituicoes: `Match` identifica trocas restantes, jogadores que entraram,
  troca efetiva, desgaste de energia e avaliacoes automaticas por placar e
  fadiga. Um cenario deterministico valida 5 para 4 trocas, evento tipo 6,
  listas, posicao herdada, estado do placar e energia no JAR final.
- Simulacao: `MatchEngine` agora identifica partida, clubes, time ativo,
  posses simuladas, vantagem de mando, atacante selecionado, gols, chutes,
  avancos e desarmes por setor. As formulas de forca do meio-campo, ataque,
  goleiro, atacante e defesa, a contagem de defensores, a posse e a selecao de
  assistente tambem possuem nomes semanticos e invariantes executados no JAR
  final.
- Jogadores e clubes: `Player` expoe forca geral, posicao tatica, jogador da
  base e os sete atributos individuais. `Club` expoe elenco principal/base,
  titulares, banco, tecnico, financas e esquema. Um cenario funcional valida
  esses contratos, a penalidade por atuar fora de posicao, IDs de clube,
  vinculos de jogador/tecnico, controle do usuario e estadios no JAR final.
- Escalacao e tatica: `Club` identifica as quatro configuracoes taticas,
  preparacao diaria da IA, selecao por posicao, montagem de titulares/banco e
  calculo da forca da equipe. Um cenario deterministico com 22 jogadores
  valida formacao 4, 11 titulares, 11 reservas e forca 1.820 no JAR final.
- Disponibilidade: energia, desgaste pos-partida, recuperacao diaria, forca
  ajustada por energia, fim da lesao, estado de lesao, fim do contrato e dias
  restantes possuem nomes diretos. O cenario usa a data real da carreira e
  preserva inclusive a aritmetica inteira observada no bytecode original.
- Contratos e emprestimos: `Player` identifica renovacao, movimentacao entre
  clubes, inicio e retorno de emprestimo. `PlayerLoan` identifica jogador,
  clube de origem, vencimento e notificacao de falha. Um cenario valida
  renovacao de 30+15 dias, emprestimo de 365 dias e retorno com 180 dias,
  removendo os registros sinteticos antes do round-trip do save.
- Mercado: `TransferNegotiation` identifica jogador, clubes de origem e
  destino, valores, modo, limite de elenco, salario pedido, contraproposta e
  conclusao. A API nomeada cobre busca de destino, emprestimo, venda listada,
  avaliacao de proposta, interesse do jogador e reposicao do elenco vendedor.
  Um cenario valida proposta aceita, contraproposta de 2.500, salario de 200 e
  os codigos deterministas de rejeicao sem alterar a carreira real.
- Dados de mercado: `Player` expoe estrela, destaque mundial, salario, valor
  de mercado, preco pedido, lista de transferencias e disponibilidade para
  emprestimo, incluindo getters, setters e restauracao do preco pelo valor.
- Mercado da IA: `AiSquadManager` identifica as cinco fases de manutencao da
  temporada, revisao de tecnicos, equilibrio de ligas e clubes avulsos,
  reposicao de carencias e movimentacao de destaques. Um cenario executa todos
  os pontos de entrada e confirma a protecao de elencos equilibrados,
  jogadores emprestados e clubes controlados pelo usuario.
- Paises: 48 consultas que dependiam dos nomes internos `P0...P223`, perdidos
  ao recompilar o enum, agora usam o mesmo indice numerico do bytecode. O fluxo
  de negociacao exercita essa correcao e o contrato binario permanece intacto.
- Mutacoes de jogador: os ajustes de forca geral, posicao tatica, sete
  atributos e energia possuem setters semanticos. A migracao foi dirigida pelo
  tipo para nao alterar metodos homonimos de outras classes, e todos os setters
  sao executados no JAR final.
- Estadios: `StadiumExpansionProject` e o processamento correspondente em
  `CareerState` estao nomeados. Um teste funcional confirma aplicacao unica de
  70 lugares, preservacao da data e round-trip Kryo.
- Migracao: membros estaticos, membros privados, metodos de instancia com nome
  globalmente unico e metodos sem argumentos sem colisao equivalente podem ser
  aplicados de forma transacional nas 1.032 fontes, com backup e verificacao
  de referencias. Metodos equivalentes repetidos tambem podem ser migrados
  juntos quando todos possuem explicitamente o mesmo nome semantico.
- Proxima fase: recuperar filtros de busca, registros e historico do mercado
  em `PlayerSearchCriteria` e `PlayerTransferRecord`.
