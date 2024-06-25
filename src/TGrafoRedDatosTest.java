import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.jupiter.api.*;

public class TGrafoRedDatosTest {
    private TGrafoRedDatos grafo;

    @BeforeEach
    public void setUp() {
        grafo = (TGrafoRedDatos) UtilGrafos.cargarGrafo("src\\servidores.txt", "src\\enlaces.txt", false,
                TGrafoRedDatos.class);
    }

    @Test
    public void testRutaMenosSaltosOrigenDestinoIguales() {
        LinkedList<TVertice> ruta = grafo.rutaMenosSaltos("BUF", "BUF");
        assertNotNull(ruta);
        assertEquals(0, ruta.size());
    }

    @Test
    public void testRutaMenosSaltos() {
        LinkedList<TVertice> ruta = grafo.rutaMenosSaltos("BUF", "LAS");
        assertNotNull(ruta);
        assertEquals(2, ruta.size());
    }


    @Test
    public void testRutaMenosSaltosRutaValida() {
        LinkedList<TVertice> ruta = grafo.rutaMenosSaltos("BUF", "DFW");
        assertNotNull(ruta);
        assertTrue(ruta.size() > 1);
        assertEquals("BUF", ruta.getFirst().getEtiqueta());
        assertEquals("DFW", ruta.getLast().getEtiqueta());
    }

    @Test
    public void testRutaMenosSaltosRutaInvalida() {
        LinkedList<TVertice> ruta = grafo.rutaMenosSaltos("BUF", "XYZ");
        assertNull(ruta);
    }

    @Test
    public void testRutaMenosSaltosVerticeOrigenNoExiste() {
        LinkedList<TVertice> ruta = grafo.rutaMenosSaltos("XYZ", "BUF");
        assertNull(ruta);
    }

    @Test
    public void testRutaMenosSaltosNoConexion() {
        LinkedList<TVertice> ruta = grafo.rutaMenosSaltos("BUF", "NON");
        assertNull(ruta);
    }
}