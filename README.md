# UCE Génie Logiciel Avancé : Techniques de tests

## HICHAM ANBARI ASLAIMI - M1 ILSEN ALT GRP 2

### Les badges (TP4)
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/hicham-anbari/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/hicham-anbari/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/hicham-anbari/ceri-m1-techniques-de-test/branch/master/graph/badge.svg)](https://codecov.io/gh/hicham-anbari/ceri-m1-techniques-de-test)
[![Checkstyle](target/site/badges/checkstyle-result.svg)](https://htmlpreview.github.io/?https://github.com/hicham-anbari/ceri-m1-techniques-de-test/blob/master/docs/checkstyle/checkstyle.html)
[![Javadoc](https://img.shields.io/badge/javadoc-3.5.0-brightgreen.svg)](https://hicham-anbari.github.io/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html)

### Documentation du projet (TP5)
[Github pages](https://hicham-anbari.github.io/ceri-m1-techniques-de-test/docs/fr/univavignon/pokedex/api/package-summary.html)

### Rapport du projet (TP6)
Une fois la classe RocketPockemonFactory est ajoutée, et que nous avions remplacé dans IPokemonFactoryTest 
notre pokemonFactory par un rocketPokemonFactory, nous pouvons remarqués que les tests ne passent plus à cause de :
- La méthode testCreatePokemon() ne passe plus car il attend un Bulbizarre mais reçois un MISSINGNO
- Cette même méthode ne lance plus d'exception car l'index -1 est associé à Ash's pikachu

Mais c'est normal car quand on regarde RocketPockemonFactory on voit que : 
- Le nom des pokemons sont créés en dur dans le code pour (-1, 0, 1)
- Les capacités des pokemons sont créés aléatoirement 
- IV ne peut être que 0 ou 1

#### Conclusion
Nous pouvons donc conclure que les tests ne sont pas assez robustes pour tester la classe RocketPockemonFactory
Néanmoins, j'ai créer une classe IRocketPockemonFactoryTest pour faire en sorte que les tests passent.