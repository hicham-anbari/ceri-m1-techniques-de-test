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
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        when(metaData.getPokemonMetadata(0)).thenReturn(bulbizarre);
        when(metaData.getPokemonMetadata(133)).thenReturn(aquali);

        assertEquals(bulbizarre, metaData.getPokemonMetadata(0));
        assertEquals(aquali, metaData.getPokemonMetadata(133));
    }
}
