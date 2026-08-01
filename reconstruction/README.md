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
.\gradlew.bat compileRecovered
.\gradlew.bat assembleHybrid
.\gradlew.bat smokeTest
```

Depois de validar uma carreira pela interface, preserve-a como referencia:

```powershell
.\gradlew.bat captureReferenceSave
.\gradlew.bat verifyReferenceSave
.\gradlew.bat saveCompatibilityTest
```

O build jogavel fica em `C:\Brasfoot22-23_modkit\build\Brasfoot22-23_hybrid`.
Para abrir manualmente:

```powershell
.\gradlew.bat runHybrid
```

O teste automatizado confirma integridade, inicializacao no Java 8 e o
carregamento da classe recuperada. Antes de promover codigo de simulacao ou
persistencia, execute tambem uma carreira com dez partidas e valide salvar e
carregar pela interface.

`buildSerializationAtlas` gera o contrato de todas as classes serializaveis.
`saveCompatibilityTest` carrega os tipos recuperados no Java 8, executa
round-trip e desserializa o `reference.info` preservado.

## Espacos De Nomes

- `official`: nomes binarios originais exigidos pelo jogo.
- `intermediary`: identificadores legais, estaveis e sem colisoes no Windows.
- `named`: nomes semanticos usados pelo codigo recuperado.

Somente fontes revisadas entram em `src/recovered`. A decompilacao bruta e
regenerada em `build/generated/decompiled`.
