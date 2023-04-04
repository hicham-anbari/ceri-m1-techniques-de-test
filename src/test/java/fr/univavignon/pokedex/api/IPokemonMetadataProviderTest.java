package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metaData;
    private PokemonMetadata bulbizarre;
    private PokemonMetadata aquali;

    @Before
    public void setUp() throws PokedexException {
        metaData = mock(IPokemonMetadataProvider.class);
        bulbizarre = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        aquali = new PokemonMetadata(133,"Aquali",186,168,260);

        when(metaData.getPokemonMetadata(0)).thenReturn(bulbizarre);
        when(metaData.getPokemonMetadata(133)).thenReturn(aquali);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        assertEquals(bulbizarre, metaData.getPokemonMetadata(0));
        assertEquals(bulbizarre.getIndex(), metaData.getPokemonMetadata(0).getIndex());
        assertEquals(bulbizarre.getName(), metaData.getPokemonMetadata(0).getName());
        assertEquals(bulbizarre.getAttack(), metaData.getPokemonMetadata(0).getAttack());
        assertEquals(bulbizarre.getDefense(), metaData.getPokemonMetadata(0).getDefense());
        assertEquals(bulbizarre.getStamina(), metaData.getPokemonMetadata(0).getStamina());


        assertEquals(aquali, metaData.getPokemonMetadata(133));
        assertEquals(aquali.getIndex(), metaData.getPokemonMetadata(133).getIndex());
        assertEquals(aquali.getName(), metaData.getPokemonMetadata(133).getName());
        assertEquals(aquali.getAttack(), metaData.getPokemonMetadata(133).getAttack());
        assertEquals(aquali.getDefense(), metaData.getPokemonMetadata(133).getDefense());
        assertEquals(aquali.getStamina(), metaData.getPokemonMetadata(133).getStamina());
    }

    // Test de la méthode getPokemonMetadata avec un index invalide (inférieur à 0) qui doit lever une exception
    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        when(metaData.getPokemonMetadata(-1)).thenThrow(new PokedexException("L'index est invalide"));
        metaData.getPokemonMetadata(-1);
    }
}
