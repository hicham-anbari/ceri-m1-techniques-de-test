package fr.univavignon.pokedex.api;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() throws PokedexException {
        pokemonFactory = new PokemonFactory();
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        assertEquals(0, bulbizarre.getIndex());
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(126, bulbizarre.getDefense());
        assertEquals(90, bulbizarre.getStamina());
        assertEquals(613, bulbizarre.getCp());
        assertEquals(4000, bulbizarre.getDust());
        assertEquals(4, bulbizarre.getCandy());
        assertEquals(56, bulbizarre.getIv(), 0);


        assertEquals(133, aquali.getIndex());
        assertEquals("Aquali", aquali.getName());
        assertEquals(186, aquali.getAttack());
        assertEquals(168, aquali.getDefense());
        assertEquals(260, aquali.getStamina());
        assertEquals(2729, aquali.getCp());
        assertEquals(5000, aquali.getDust());
        assertEquals(4, aquali.getCandy());
        assertEquals(100, aquali.getIv(), 0);
    }
}
