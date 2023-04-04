package fr.univavignon.pokedex.api;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metaData;
    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() throws PokedexException {
        pokedexFactory = mock(IPokedexFactory.class);
        pokemonFactory = mock(IPokemonFactory.class);
        metaData = mock(IPokemonMetadataProvider.class);
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testCreatePokedex() throws PokedexException {
        when(pokedexFactory.createPokedex(metaData, pokemonFactory)).thenReturn(pokedex);
        assertEquals(pokedex, pokedexFactory.createPokedex(metaData, pokemonFactory));
    }
}
