package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Implementation of the IPokedex interface.
 */
public class Pokedex implements IPokedex {

    /*
     * List of pokemons.
     */
    private final List<Pokemon> pokemons;
    /*
     * Factory used to create pokemons.
     */
    private final IPokemonFactory pokemonFactory;
    /*
     * Provider used to get pokemon metadata.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    /*
     * Constructor.
     */
    public Pokedex(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory factory) {
        pokemons = new ArrayList<>();
        pokemonFactory = factory;
        pokemonMetadataProvider = metadataProvider;
    }

    /*
     * Returns the number of pokemons in the pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /*
     * Adds a pokemon to the pokedex.
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size();
    }

    /*
     * Returns the pokemon at the given index.
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Le Pokémon n'est pas enregistré dans le pokédex");
        }
        return pokemons.get(id);
    }

    /*
     * Returns the list of pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /*
     * Returns the list of pokemons sorted by the given comparator.
     */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> pokemonList = pokemons;
        pokemonList.sort(order);
        return Collections.unmodifiableList(pokemonList);
    }

    /*
     * Creates a pokemon.
     * @throws PokedexException if the given index is invalid.
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /*
     * Returns the pokemon metadata for the given index.
     * @throws PokedexException if the given index is invalid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }

}