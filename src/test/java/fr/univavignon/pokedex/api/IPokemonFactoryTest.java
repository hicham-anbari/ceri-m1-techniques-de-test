package fr.univavignon.pokedex.api;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    // TP6 : private IPokemonFactory rocketPokemonFactory;

    @Before
    public void setUp() throws PokedexException {
        pokemonFactory = new PokemonFactory();
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        // TP6 : rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(-1, 613, 64, 4000, 4));

        assertEquals(0, bulbizarre.getIndex());
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(126, bulbizarre.getAttack());
        assertEquals(126, bulbizarre.getDefense());
        assertEquals(90, bulbizarre.getStamina());
        assertEquals(64, bulbizarre.getHp());
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
        assertEquals(202, aquali.getHp());
        assertEquals(5000, aquali.getDust());
        assertEquals(4, aquali.getCandy());
        assertEquals(100, aquali.getIv(), 0);

        assertEquals((100 + 0) / 2.0, bulbizarre.getIv(), (100 - 0) / 2.0);
        assertEquals((100 + 0) / 2.0, aquali.getIv(), (100 - 0) / 2.0);

        /* TP6
        Remarque : Les tests suivants ne fonctionnent pas car la classe rocketPokemonFactory n'utilise pas la classe PokemonMetadataProvider
        pour créer des pokémons. Elle utilise une autre source de données fixé en dur dans la classe.
        Il est donc impossible de créer un pokemon avec les mêmes caractéristiques que ceux créés par la classe PokemonFactory.

        Pokemon bulbizarreRocket = rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(bulbizarre.getIndex(), bulbizarreRocket.getIndex());
        assertEquals(bulbizarre.getName(), bulbizarreRocket.getName());
        assertEquals(bulbizarre.getAttack(), bulbizarreRocket.getAttack());
        assertEquals(bulbizarre.getDefense(), bulbizarreRocket.getDefense());
        assertEquals(bulbizarre.getStamina(), bulbizarreRocket.getStamina());
        assertEquals(bulbizarre.getCp(), bulbizarreRocket.getCp());
        assertEquals(bulbizarre.getHp(), bulbizarreRocket.getHp());
        assertEquals(bulbizarre.getDust(), bulbizarreRocket.getDust());
        assertEquals(bulbizarre.getCandy(), bulbizarreRocket.getCandy());
        assertEquals(bulbizarre.getIv(), bulbizarreRocket.getIv(), 0);
         */
    }
}
