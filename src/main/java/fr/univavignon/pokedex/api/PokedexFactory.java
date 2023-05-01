package fr.univavignon.pokedex.api;

/*
 * Factory interface for class that aims to create Pokedex instance.
 */
public class PokedexFactory implements IPokedexFactory {
    /*
     * Creates a new pokedex instance using the given
     */
    @Override
    public IPokedex createPokedex(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}