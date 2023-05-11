package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata bulbizarre;
    private PokemonMetadata aquali;

    @Before
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        bulbizarre = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        aquali = new PokemonMetadata(133,"Aquali",186,168,260);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        assertEquals(bulbizarre.getIndex(), pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
        assertEquals(bulbizarre.getName(), pokemonMetadataProvider.getPokemonMetadata(0).getName());
        assertEquals(bulbizarre.getAttack(), pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
        assertEquals(bulbizarre.getDefense(), pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
        assertEquals(bulbizarre.getStamina(), pokemonMetadataProvider.getPokemonMetadata(0).getStamina());


        assertEquals(aquali.getIndex(), pokemonMetadataProvider.getPokemonMetadata(133).getIndex());
        assertEquals(aquali.getName(), pokemonMetadataProvider.getPokemonMetadata(133).getName());
        assertEquals(aquali.getAttack(), pokemonMetadataProvider.getPokemonMetadata(133).getAttack());
        assertEquals(aquali.getDefense(), pokemonMetadataProvider.getPokemonMetadata(133).getDefense());
        assertEquals(aquali.getStamina(), pokemonMetadataProvider.getPokemonMetadata(133).getStamina());
    }

    // Test de la méthode getPokemonMetadata avec un index invalide (inférieur à 0) qui doit lever une exception
    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("L'index est invalide"));
        pokemonMetadataProvider.getPokemonMetadata(-1);
    }
}
