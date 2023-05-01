package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider() {
        this.pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadataList.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        for (PokemonMetadata pokemonMetadata : pokemonMetadataList) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }
        throw new PokedexException("L'index du pokémon n'existe pas");
    }
}