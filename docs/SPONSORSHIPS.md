# Contratos De Patrocinio

O modulo `sponsorships` substitui a receita anual fixa somente para clubes
controlados pelo usuario e somente quando a funcionalidade esta ativa. Clubes
da IA e carreiras com a funcionalidade desligada continuam usando exatamente
a regra original.

## Ofertas E Contratos

- Cada rodada apresenta tres propostas deterministicas para o clube.
- Os contratos duram 12, 18 ou 24 meses.
- Cada proposta combina luvas, parcela mensal, meta e bonus.
- As metas disponiveis sao percentual de vitorias, numero de vitorias na
  temporada ou conquista de titulo.
- Somente jogos e titulos posteriores a assinatura contam para a primeira
  meta; a linha de base e renovada no inicio de cada temporada.
- O bonus de meta pode ser pago uma vez por temporada enquanto o contrato
  estiver ativo.
- Contratos vencidos geram uma nova rodada de ofertas.
- O historico lateral preserva os 36 ultimos eventos por clube.

Os valores partem da tabela financeira original por divisao, com ajuste de
reputacao. O catalogo inicial usa nomes ficticios; marcas reais podem ser
adicionadas depois como dados, sem alterar a engine.

## Integracao Financeira

Luvas, parcelas e bonus entram em `Club.credit(..., 6)`. Por isso aparecem na
linha `Patrocinio/Socio torcedor` da tela financeira existente e afetam caixa,
receitas e resultado do periodo sem campos novos nas classes Kryo.

No dia 2 de cada mes, a parcela e processada antes da avaliacao da diretoria.
O mesmo periodo nunca e pago duas vezes. Ao ativar o modulo em uma carreira
que ja recebeu a verba anual antiga, essa verba e estornada uma unica vez por
clube e temporada. Renovacoes nao repetem o estorno.

## Interface

O menu `Opcoes` da tela principal ganhou o item `Recursos adicionais`. Nele e
possivel ligar ou desligar objetivos da diretoria e contratos de patrocinio.
Ao ativar patrocinadores, as propostas pendentes sao abertas imediatamente.
A escolha fica no sidecar no proximo save.

Contratos assinados e bonus cumpridos geram mensagens no inbox do tecnico. As
parcelas mensais permanecem visiveis na tela financeira para evitar excesso de
mensagens.

## Validacao

```powershell
.\gradlew.bat test modStateCompatibilityTest staticSmokeTest
```

Os testes cobrem ofertas, duracoes, luvas, parcelas, bonus, metas, expiracao,
renovacao, isolamento por clube, transicao da receita antiga, persistencia,
idempotencia e os hooks remapeados no JAR final.
