package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IRocketPokemonFactoryTest {

    private IPokemonFactory rocketPokemonFactory;
    private Pokemon bulbizarre;

    @Before
    public void setUp() throws PokedexException {
        rocketPokemonFactory = new RocketPokemonFactory();
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon bulbizarreRocket = rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(bulbizarre.getIndex(), bulbizarreRocket.getIndex());
        assertEquals(bulbizarre.getCp(), bulbizarreRocket.getCp());
        assertEquals(bulbizarre.getHp(), bulbizarreRocket.getHp());
        assertEquals(bulbizarre.getDust(), bulbizarreRocket.getDust());
        assertEquals(bulbizarre.getCandy(), bulbizarreRocket.getCandy());
        // Verifier que les données sont différentes
        assertNotEquals(bulbizarre.getName(), bulbizarreRocket.getName());
        assertNotEquals(bulbizarre.getAttack(), bulbizarreRocket.getAttack());
        assertNotEquals(bulbizarre.getDefense(), bulbizarreRocket.getDefense());
        assertNotEquals(bulbizarre.getStamina(), bulbizarreRocket.getStamina());
        // Verifier que les IV est égale à 0 ou 1
        assertTrue(bulbizarreRocket.getIv() == 0 || bulbizarreRocket.getIv() == 1);
    }
}
