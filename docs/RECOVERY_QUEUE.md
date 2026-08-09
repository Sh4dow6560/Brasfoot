# Fila De Recuperacao

Fila deterministica orientada por dependencias, estabilidade entre versoes, sinais textuais, variantes de referencia e risco de save.

- Classes sem nome: 951.
- Classes semanticas: 87.

## Lotes Recomendados

### variant-integration

Name classes that integrate externally observed features.

Nenhuma classe pendente.

### semantic-frontier

Expand the named dependency frontier with the highest impact.

`best/w`, `a/eg`, `h/a`, `best/ac`, `best/M`, `components/y`, `best/G`, `components/as`, `a/dV`, `a/ay`, `f/b`, `a/hk`

### member-frontier

Recover members in already named core classes.

`best/aq`, `best/f`, `best/F`, `best/ah`, `f/s`, `est/Options`, `best/I`, `a/al`

### runtime-frontier

Promote central compile-clean classes to runtime verification.

`c/a`, `best/at`, `best/L`, `best/w`, `best/aq`, `h/a`, `components/y`, `a/eg`, `f/q`, `f/x`, `best/M`, `f/v`

## Fronteira Semantica

| Classe | Modulo | Score | Valor/esforco | Entrada | Saida | Evidencia |
|---|---|---:|---:|---:|---:|---|
|`best/w`|competition|535|1304.9|43|17||
|`a/eg`|competition|476|195.9|86|129||
|`h/a`|competition|409|601.5|49|41||
|`best/ac`|competition|381|154.9|40|2||
|`best/M`|competition|373|2072.2|20|5||
|`components/y`|competition|343|3430.0|30|1||
|`best/G`|competition|330|3300.0|18|1||
|`components/as`|model|328|820.0|14|5||
|`a/dV`|competition|315|315.0|18|41||
|`a/ay`|competition|310|191.4|11|50||
|`f/b`|competition|308|3080.0|9|8||
|`a/hk`|model|308|258.8|15|42||
|`a/cR`|competition|291|661.4|6|23||
|`a/iA`|unclassified|285|309.8|16|42||
|`a/cD`|model|285|222.7|15|37||
|`a/aa`|competition|279|336.1|11|37||
|`a/bz`|model|279|242.6|25|37||
|`best/aj`|competition|275|585.1|2|12||
|`a/gO`|unclassified|267|606.8|7|23|behavior-changed:super-club-world-cup-2026|
|`a/dg`|competition|266|521.6|2|24||
|`a/hF`|unclassified|265|414.1|15|26||
|`best/s`|competition|262|671.8|3|18||
|`a/hU`|ui|260|388.1|18|32|behavior-changed:super-club-world-cup-2026|
|`a/h`|competition|259|809.4|4|15||
|`a/fB`|unclassified|256|269.5|25|36|behavior-changed:super-club-world-cup-2026|
|`a/bV`|competition|255|447.4|9|23||
|`a/aP`|model|253|408.1|9|25||
|`components/al`|competition|250|675.7|13|0||
|`components/am`|competition|234|2340.0|10|0||
|`a/gx`|model|233|613.2|9|23||
|`a/gE`|unclassified|229|477.1|9|24||
|`a/aL`|game|225|478.7|4|20||
|`a/dz`|model|224|386.2|9|18||
|`a/jH`|competition|223|405.5|12|21||
|`a/gb`|match|220|846.2|6|15|behavior-changed:super-club-world-cup-2026|
|`a/d`|unclassified|220|666.7|4|15||
|`d/n`|unclassified|217|164.4|46|52||
|`a/gX`|model|216|526.8|7|20||
|`best/K`|model|210|2100.0|6|12||
|`a/iu`|competition|207|627.3|6|17||

## Fronteira De Membros

| Classe | Nome | Modulo | Pendentes | Centralidade |
|---|---|---|---:|---:|
|`best/aq`|`mod/recovered/core/GameConstants`|core|501|257|
|`best/f`|`mod/recovered/game/CareerState`|game|405|670|
|`best/F`|`mod/recovered/model/Player`|model|201|306|
|`best/ah`|`mod/recovered/model/Club`|model|168|599|
|`f/s`|`mod/recovered/competition/LeagueStage`|competition|116|444|
|`est/Options`|`mod/recovered/config/GameOptions`|config|110|110|
|`best/I`|`mod/recovered/match/Match`|match|105|197|
|`a/al`|`bf22/intermediary/CompetitionResultsPanel`|named-other|97|208|
|`best/Z`|`mod/recovered/competition/CountryCompetitions`|competition|81|443|
|`f/B`|`mod/recovered/competition/NationalLeague`|competition|81|164|
|`best/a`|`mod/recovered/game/ScheduleDay`|game|77|155|
|`est/ConfigLigaType`|`mod/recovered/config/NationalLeagueConfig`|config|70|14|
|`best/at`|`mod/recovered/competition/Competition`|competition|66|471|
|`c/b`|`mod/recovered/match/MatchEngine`|match|57|48|
|`f/r`|`mod/recovered/competition/CopaLibertadores`|competition|49|124|
|`f/z`|`mod/recovered/competition/KnockoutStage`|competition|48|280|
|`f/G`|`mod/recovered/competition/KnockoutRound`|competition|44|257|
|`f/v`|`mod/recovered/competition/UefaChampionsLeague`|competition|43|127|
|`best/S`|`mod/recovered/ui/MainWindow`|ui|42|118|
|`f/x`|`mod/recovered/competition/UefaEuropaLeague`|competition|39|133|
|`f/M`|`mod/recovered/competition/UefaNationsLeague`|competition|35|83|
|`f/J`|`mod/recovered/competition/UefaConferenceLeague`|competition|34|107|
|`f/f`|`mod/recovered/competition/NationalCup`|competition|29|100|
|`f/N`|`mod/recovered/competition/ConcacafNationsLeague`|competition|29|71|
|`f/H`|`mod/recovered/competition/CopaSudamericana`|competition|28|118|
|`est/ConfigEstadualType`|`mod/recovered/config/StateLeagueConfig`|config|27|7|
|`f/q`|`mod/recovered/competition/WorldCup`|competition|25|133|
|`best/v`|`mod/recovered/model/Stadium`|model|25|91|
|`best/ad`|`mod/recovered/geo/CountryInfo`|geo|25|30|
|`f/t`|`mod/recovered/competition/CafChampionsLeague`|competition|23|77|
