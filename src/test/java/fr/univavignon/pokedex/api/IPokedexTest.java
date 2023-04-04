package fr.univavignon.pokedex.api;

import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(pokedex.addPokemon(aquali)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemon(1)).thenReturn(aquali);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        when(pokedex.getPokemons()).thenReturn(pokemons);

        when(pokedex.getPokemons(any())).thenAnswer(invocation -> {
            Comparator<Pokemon> comparator = invocation.getArgument(0);
            pokemons.sort(comparator);
            return pokemons;
        });
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        assertEquals(0, pokedex.addPokemon(bulbizarre));
        assertEquals(1, pokedex.addPokemon(aquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemons() throws PokedexException {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(bulbizarre));
        assertTrue(pokemons.contains(aquali));
    }

    @Test
    public void testGetPokemonsOrder() throws PokedexException {
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);
        List<Pokemon> pokemons = pokedex.getPokemons(comparator);
        assertEquals(2, pokemons.size());
        assertEquals(bulbizarre, pokemons.get(0));
        assertEquals(aquali, pokemons.get(1));
    }
}
