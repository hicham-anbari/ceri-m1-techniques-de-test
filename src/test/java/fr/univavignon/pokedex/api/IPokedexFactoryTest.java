package fr.univavignon.pokedex.api;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() throws PokedexException {
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() throws PokedexException {
        IPokedex pokedex = new Pokedex(pokemonMetadataProvider,pokemonFactory);
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).size(),pokedex.size());
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).getPokemons(),pokedex.getPokemons());
    }
}
