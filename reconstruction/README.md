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

Ao adicionar nomes de membros estaticos, membros privados, metodos de
instancia cujo nome seja unico em toda a engine ou metodos sem argumentos
unicos entre os demais metodos sem argumentos, execute
`applySemanticMemberMappings` antes de `generateMappings`. A tarefa atualiza
as referencias nas 1.032 fontes, valida a migracao e mantem uma copia de
seguranca transacional em `build/generated`. Membros de instancia ambiguos
continuam exigindo migracao dirigida pelo tipo. Um grupo repetido sem
argumentos pode ser migrado junto quando todos os membros do grupo estiverem
explicitamente configurados com o mesmo nome semantico.
