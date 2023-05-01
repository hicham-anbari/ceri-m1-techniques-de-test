package fr.univavignon.pokedex.api;

/*
 * Factory interface for class that aims to create Pokemon instance.
 */
public class PokemonFactory implements IPokemonFactory {

    /*
     * Creates a new pokemon instance using the given parameters.
     * @throws PokedexException if the given index is inferior to 0.
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy)
            throws PokedexException {

        if (index < 0) {
            throw new PokedexException("Index inférieur à 0");
        }

        PokemonMetadata pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
        int iv = (int) ((Math.random() * (100)) + 0);

        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(),
                pokemonMetadata.getDefense(), pokemonMetadata.getStamina(),
                cp, hp, dust, candy, iv);
    }

}
