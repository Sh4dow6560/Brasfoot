# Mapa De Campos

## Clube

- `file`: nome do arquivo `.ban`.
- `valid`: se o clube esta ativo para carregamento.
- `id`, `tid`, `sid`, `aid`, `vid`: identificadores internos preservados.
- `pais`, `estado`, `nivel`: codigos internos de localizacao/divisao.
- `fileRef`: referencia interna usada pelo jogo para assets.
- `nome`, `estadio`, `capacidade`, `tecnico`, `tecNac`: dados visiveis.
- `reputacao`, `corBase`, `cor1`, `cor2`: forca/cores do clube.
- `jogadores`: elenco principal.
- `juniores`: lista de juniores, quando existir.

## Jogador

- `nome`: nome exibido.
- `estrela`: marca de jogador estrela.
- `topMundial`: marca interna para destaque mundial.
- `pais`, `idade`, `posicao`, `status`, `cr1`, `cr2`, `lado`: codigos do jogo.
- `hash`, `tid`, `sid`, `aid`: identificadores internos preservados.

Nao mude codigos numericos em massa sem validar em jogo. Eles sao regras da
engine original.
