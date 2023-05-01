package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private final List<Pokemon> pokemons;
    private final IPokemonFactory pokemonFactory;
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    public Pokedex(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory factory) {
        pokemons = new ArrayList<>();
        pokemonFactory = factory;
        pokemonMetadataProvider = metadataProvider;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size();
    }

    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Le Pokémon n'est pas enregistré dans le pokédex");
        }
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> pokemonList = pokemons;
        pokemonList.sort(order);
        return Collections.unmodifiableList(pokemonList);
    }

    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }

}