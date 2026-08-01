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
- Dados: round-trip dos 703 times aprovado; existe um aviso preexistente de
  jogador duplicado em `vitoriaguimaraes_por.ban`.
- Interface: a copia hibrida abriu a janela principal do Brasfoot, e a carreira
  foi salva e carregada. Novas montagens agora preservam automaticamente a
  pasta `sav` da copia hibrida.
- Legibilidade: 38 classes possuem nomes semanticos; o nucleo inclui carreira,
  persistencia, paises, competicoes, fases, partidas e motor de simulacao.
- Proxima fase: ampliar nomes de membros e testes funcionais antes de implementar
  novas mecanicas.
