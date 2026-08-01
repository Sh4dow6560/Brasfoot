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
- As outras 2.192 entradas do JAR permanecem byte a byte identicas.

## Proximos Lotes

1. Inicializacao, configuracao e logs.
2. Modelos serializaveis, clubes e jogadores.
3. Calendario e competicoes.
4. Simulacao de partidas e transferencias.
5. Interface e extensoes novas.

Classes serializaveis so podem ser promovidas depois de validar nome oficial,
campos e `serialVersionUID` contra saves e arquivos `.ban` existentes.
