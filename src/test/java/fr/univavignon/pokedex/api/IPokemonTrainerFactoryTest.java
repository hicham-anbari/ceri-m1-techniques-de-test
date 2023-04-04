package fr.univavignon.pokedex.api;

import org.junit.*;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    private PokemonTrainer pokemonTrainer;

    @Before
    public void setUp() throws PokedexException {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer("Hicham", Team.MYSTIC, pokedex);

        when(pokemonTrainerFactory.createTrainer("Hicham", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() throws PokedexException {
        assertEquals(pokemonTrainer, pokemonTrainerFactory.createTrainer("Hicham", Team.MYSTIC, pokedexFactory));
        assertEquals("Hicham", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(pokedex, pokemonTrainer.getPokedex());
    }
}
