# Brasfoot Reconstruction

Pipeline local para recuperar e recompilar o Brasfoot 22/23 sem modificar as
instalacoes originais.

## Requisitos

- JDK 25 para executar o Gradle e o ferramental.
- Java 8 para validar o jogo final.
- Instalacoes listadas em `local.properties.example`.

Copie o exemplo para `local.properties` e ajuste somente os caminhos locais.
Esse arquivo, executaveis, decompilacoes e builds nao entram no Git.

## Fluxo

```powershell
.\gradlew.bat verifyInputs
.\gradlew.bat buildVersionAtlas
.\gradlew.bat buildSerializationAtlas
.\gradlew.bat generateMappings
.\gradlew.bat decompileGame
.\gradlew.bat analyzeCandidateCompilation
.\gradlew.bat promoteCandidateBatch
.\gradlew.bat compileAllDecompiled
.\gradlew.bat compileRecovered
.\gradlew.bat assembleHybrid
.\gradlew.bat smokeTest
```

Depois de validar uma carreira pela interface, preserve-a como referencia:

```powershell
.\gradlew.bat captureReferenceSave
.\gradlew.bat verifyReferenceSave
.\gradlew.bat saveCompatibilityTest
.\gradlew.bat fullSaveCompatibilityTest
.\gradlew.bat differentialTest
.\gradlew.bat modStateCompatibilityTest
```

O build jogavel fica em `C:\Brasfoot22-23_modkit\build\Brasfoot22-23_hybrid`.
Para abrir manualmente:

```powershell
.\gradlew.bat runHybrid
```

O teste automatizado confirma integridade, inicializacao no Java 8 e o
carregamento das classes recuperadas. O build atual recompila as 1.032 classes
do Brasfoot; apenas as seis classes externas do carregador Eclipse permanecem
em binario. Antes de alterar simulacao ou persistencia, execute tambem uma
carreira com dez partidas e valide salvar e carregar pela interface.

`buildSerializationAtlas` gera o contrato de todas as classes serializaveis.
`saveCompatibilityTest` carrega os tipos recuperados no Java 8, executa
round-trip e desserializa o `reference.info` preservado.
`differentialTest` executa os mesmos cenarios deterministas no JAR original e
no hibrido. Os 88 modelos serializaveis e os fluxos de calendario, partida,
elenco, mercado, carreira do tecnico e financas precisam produzir marcadores
identicos; o relatorio fica em `build/reports/differential-test.json`.

As novas funcionalidades vivem em `src/extension/java/mod/extension` e sao
compiladas separadamente para Java 8. `ModStateStore` grava um JSON lateral por
save de forma atomica; `FeatureRegistry` deixa todas as novidades desligadas
por padrao. O contrato e os estados de erro estao em
`docs/EXTENSION_STATE.md`.

O primeiro modulo sobre essa base implementa objetivos mensais da diretoria,
seguranca no emprego, impacto na confianca e relatorio no inbox. As regras e
o fallback estao em `docs/BOARD_OBJECTIVES.md`.

O modulo de patrocinadores adiciona ofertas, contratos, luvas, parcelas,
metas, bonus e renovacoes. A integracao financeira e a transicao da receita
legada estao em `docs/SPONSORSHIPS.md`.

## Espacos De Nomes

- `official`: nomes binarios originais exigidos pelo jogo.
- `intermediary`: identificadores legais, estaveis e sem colisoes no Windows.
- `named`: nomes semanticos usados pelo codigo recuperado.

As fontes promovidas entram em `src/recovered`. A decompilacao bruta e
regenerada em `build/generated/decompiled`; os reparos deterministas ficam em
`config/decompiler-repairs.json`.

Ao adicionar nomes de classes em `config/semantic-names.json`, execute
`applySemanticSourceMappings` antes de qualquer tarefa que gere novamente os
mapeamentos. O pipeline bloqueia a ordem incorreta para proteger as fontes
revisadas.

Para localizar acessores inequivocos ligados a campos ja identificados:

```powershell
.\gradlew.bat buildSemanticCandidates semanticCoverage
```

`buildSemanticCandidates` grava a evidencia em
`build/reports/semantic-candidates.json`. `semanticCoverage` atualiza o
relatorio por modulo. Para aceitar e aplicar um lote de alta confianca:

```powershell
.\gradlew.bat compileRecovered
.\gradlew.bat acceptSemanticCandidates
.\gradlew.bat applySemanticMemberMappings
.\gradlew.bat generateMappings compileRecovered smokeTest check
```

Os nomes aceitos ficam separados em `config/semantic-auto-names.json`. O
migrador usa substituicao transacional nos casos simples e JavaParser Symbol
Solver quando nomes ofuscados colidem. Declaracoes e chamadas resolvidas devem
coincidir com o bytecode compilado antes de qualquer fonte ser substituida.
