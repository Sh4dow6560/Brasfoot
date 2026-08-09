# Estadio E Infraestrutura

O modulo `stadiumInfrastructure` adiciona gestao de infraestrutura aos clubes
controlados pelo usuario sem incluir campos nos 88 modelos Kryo. O recurso fica
desligado por padrao e grava seus perfis somente no sidecar do save.

## Estruturas

- gramado;
- centro de treinamento;
- departamento medico;
- categorias de base;
- estrutura comercial.

Cada estrutura possui nivel de 1 a 5. Os niveis iniciais derivam da reputacao,
divisao e capacidade do estadio. Uma obra eleva um nivel, tem preco e prazo
deterministicos, permite somente um projeto ativo por clube e debita a categoria
financeira original de despesas de estadio.

## Manutencao E Gramado

No dia 2 de cada mes, o modulo cobra manutencao uma unica vez. O valor considera
capacidade e niveis das cinco estruturas. Sem caixa suficiente, nenhuma divida
e criada, a falha fica registrada e a qualidade do gramado cai.

A qualidade do gramado varia de 0 a 100 conforme nivel, partidas estimadas em
casa, manutencao e conclusao de obras. O resultado e convertido para os quatro
estados usados pela engine original. O estadio e as partidas futuras ja
agendadas recebem o novo valor; jogos neutros e estadios alternativos nao sao
alterados.

## Integracao

O menu principal possui `Estadio e infraestrutura`, com painel, caixa,
manutencao, obra ativa e fluxo para iniciar melhorias. A ativacao fica em
`Recursos adicionais`.

Com o recurso desligado, nao ha cobranca, sincronizacao de partidas ou escrita
do modulo no sidecar. Expansoes de arquibancadas continuam usando o sistema
original e permanecem independentes.
