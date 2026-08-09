# Torcida E Alcance Mundial

O modulo `clubReach` acompanha a dimensao da marca de cada clube controlado
pelo usuario sem adicionar campos aos modelos Kryo do jogo. O recurso fica
desligado por padrao e persiste somente no sidecar do save.

## Indicadores

- torcida local e internacional;
- seguidores nas redes sociais;
- socios-torcedores;
- engajamento e sentimento da torcida, de 0 a 100;
- reputacao mundial, de 0 a 1.000, nos niveis local, regional, nacional,
  continental e mundial.

O perfil inicial usa reputacao do clube, divisao, capacidade do estadio e
confianca da torcida. A atualizacao mensal considera aproveitamento, derrotas,
titulos e confianca atual. Os calculos sao deterministicos, limitados contra
overflow e executados no maximo uma vez por mes.

Trocas de temporada ou contadores reiniciados criam uma nova linha de base. Um
perfil de modulo invalido e reconstruido sem afetar os demais dados do sidecar.
Cada clube possui perfil independente e historico dos ultimos 36 periodos.

## Integracao

O processamento ocorre no dia 2 de cada mes, junto com diretoria e
patrocinadores. O menu principal possui `Torcida e alcance mundial`, que mostra
os indicadores atuais e a ultima variacao mensal. A ativacao fica em
`Recursos adicionais`.

Com o recurso desligado, o calendario nao grava estado, o painel nao calcula
indicadores e o comportamento original permanece como fallback.
