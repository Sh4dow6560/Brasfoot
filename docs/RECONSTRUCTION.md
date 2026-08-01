# Reconstrucao Da Engine

## Primeiro Marco

- Sete executaveis originais protegidos por hash, de 2016 a 22/23.
- Atlas estrutural com classes, campos, metodos, recursos e transicoes anuais.
- Mapeamento Tiny v2 reversivel com zero identificadores ilegais e zero
  colisoes de caminhos.
- Decompilacao nomeada com 1.038 arquivos Java e nenhum marcador de erro do
  Vineflower.
- `components/ar` recuperada como `CrashLogHandler`, compilada em Java 8 e
  carregada no jogo pelo nome oficial.
- Os sete tipos `est` de configuracao e metadados foram recuperados e testados
  no Java 8; `est.InfoArquivoSalvoType` leu o save de referencia existente.
- `components/ag` foi recuperada como `LineupPreset`, primeira dependencia
  direta do modelo de clube.
- As outras 2.184 entradas do JAR permanecem byte a byte identicas.

## Proximos Lotes

1. Modelos serializaveis auxiliares de clubes e jogadores.
2. Modelos principais `best/F` (jogador), `best/ah` (clube) e `best/al` (tecnico).
3. Calendario e competicoes.
4. Simulacao de partidas e transferencias.
5. Interface e extensoes novas.

Classes serializaveis so podem ser promovidas depois de validar nome oficial,
campos e `serialVersionUID` contra saves e arquivos `.ban` existentes.
