package fr.univavignon.pokedex.api;

import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() throws PokedexException {
        pokedex = new PokedexFactory().createPokedex(new PokemonMetadataProvider(),new PokemonFactory());
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void testSize() {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        assertEquals(1, pokedex.addPokemon(bulbizarre));
        assertEquals(2, pokedex.addPokemon(aquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
        assertEquals(bulbizarre, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(1));

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-1);
        });
    }

    @Test
    public void testGetPokemons() throws PokedexException {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(bulbizarre));
        assertTrue(pokemons.contains(aquali));
    }

    @Test
    public void testGetPokemonsOrder() throws PokedexException {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals(bulbizarre, pokemons.get(0));
        assertEquals(aquali, pokemons.get(1));
        assertEquals(pokemons, pokedex.getPokemons(PokemonComparators.NAME));
    }

    @Test
    public void testCreatePokemon() throws PokedexException{
        Pokemon pokemon = pokedex.createPokemon(0,613,64,4000,4);
        assertEquals(pokemon.getIndex(),bulbizarre.getIndex());
        assertEquals(pokemon.getCp(),bulbizarre.getCp());
        assertEquals(pokemon.getHp(),bulbizarre.getHp());
        assertEquals(pokemon.getDust(),bulbizarre.getDust());
        assertEquals(pokemon.getCandy(),bulbizarre.getCandy());

        Pokemon pokemon2 = pokedex.createPokemon(133,2729,202,5000,4);
        assertEquals(pokemon2.getIndex(),aquali.getIndex());
        assertEquals(pokemon2.getCp(),aquali.getCp());
        assertEquals(pokemon2.getHp(),aquali.getHp());
        assertEquals(pokemon2.getDust(),aquali.getDust());
        assertEquals(pokemon2.getCandy(),aquali.getCandy());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException{
        pokedex.addPokemon(bulbizarre);
        PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(0);
        Assert.assertEquals(pokemonMetadata.getIndex(),bulbizarre.getIndex());
        Assert.assertEquals(pokemonMetadata.getName(),bulbizarre.getName());
        Assert.assertEquals(pokemonMetadata.getAttack(),bulbizarre.getAttack());
        Assert.assertEquals(pokemonMetadata.getDefense(),bulbizarre.getDefense());
        Assert.assertEquals(pokemonMetadata.getStamina(),bulbizarre.getStamina());
    }
}
