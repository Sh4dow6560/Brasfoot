# Negociacoes Avancadas

O modulo `advancedNegotiations` amplia compras e emprestimos sem adicionar
campos aos 88 modelos Kryo do jogo. O recurso fica desligado por padrao e
grava contratos somente no sidecar associado ao save.

## Compras

Depois que clube e jogador aceitam o valor total, o usuario escolhe uma das
formas de pagamento:

- pagamento integral;
- 50% de entrada e tres parcelas;
- 40% de entrada e seis parcelas;
- 25% de entrada e doze parcelas.

O jogador se transfere imediatamente. A entrada usa o fluxo financeiro
original e o saldo devedor e cobrado no dia 2 dos meses seguintes. A cobranca
e idempotente e recupera parcelas de meses pulados sem duplica-las.

## Emprestimos

O contrato permite duracao de 6 ou 12 meses, taxa imediata, divisao do salario
em intervalos de 25% e opcao de compra. O clube de origem repassa mensalmente
sua parte do salario ao clube atual. No vencimento, o jogador retorna pelo
fluxo original; se o elenco de origem estiver cheio, o contrato permanece
ativo para nova tentativa.

Uma opcao de compra usa exclusivamente o preco registrado. Contratos sem essa
clausula nao caem na compra simplificada do jogo original.

## Integracao E Compatibilidade

O menu principal possui `Negociacoes avancadas`, que lista parcelas e
emprestimos ativos. A ativacao fica em `Recursos adicionais`.

Com o recurso desligado, ofertas, compras, emprestimos e saves seguem o
comportamento original. A inteligencia artificial continua usando o mercado
legado nesta primeira versao. Nenhum executavel da instalacao original e
alterado.
