
import java.util.LinkedList;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // LEER CUIDADOSAMENTE LA CONSIGNA DE ESTE TRABAJO, PUBLICADA EN LA TAREA
        // PARCIAL2_PARTE3
        // LOS COMENTARIOS DEL PRESENTE ARCHIVO NO SUSTITUYEN LO INDICADO EN LA LETRA DE
        // LA TAREA

        TGrafoRedDatos redDatos;

        // cargar grafo con SERVIDORES y ENLACES

        redDatos = (TGrafoRedDatos) UtilGrafos.cargarGrafo("src\\servidores.txt", "src\\enlaces.txt", false,
                TGrafoRedDatos.class);

        // redDatos = (TGrafoRedDatos)UtilGrafos.cargarGrafo...

        // EJECUTAR PARA servidor1 = BUF y servidor2 = DFW
        String servidor1 = "BUF";
        String servidor2 = "DFW"; // BUF BWI PIT DFW
        LinkedList<TVertice> ruta = redDatos.rutaMenosSaltos(servidor1, servidor2);
        // ESCRIBIR RUTA EN rutas.txt SEGUIDO DE 2 LINEAS EN BLANCO
        Programa imprimirRuta = new Programa();
        imprimirRuta.imprimirRuta(ruta);

        // EJECUTAR PARA servidor1 = BUF y servidor2 = LAS
        servidor2 = "LAS";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2);
        // ESCRIBIR RUTA EN rutas.txt SEGUIDO DE 2 LINEAS EN BLANCO
        imprimirRuta.imprimirRuta(ruta);

        // EJECUTAR PARA servidor1 = BUF y servidor2 = MIA
        servidor2 = "MIA";
        ruta = redDatos.rutaMenosSaltos(servidor1, servidor2);
        // ESCRIBIR RUTA EN rutas.txt SEGUIDO DE 2 LINEAS EN BLANCO
        imprimirRuta.imprimirRuta(ruta);

    }

    public void imprimirRuta(LinkedList<TVertice> ruta) {
        try {
            int i = 0;
            String[] rutasImprimir = new String[ruta.size() + 2];
            for (TVertice tVertice : ruta) {
                rutasImprimir[i] = tVertice.getEtiqueta().toString();
                i++;
            }
            rutasImprimir[i] = "";
            rutasImprimir[i + 1] = "";

            ManejadorArchivosGenerico.escribirArchivo("rutas.txt", rutasImprimir);
        } catch (Exception e) {
            System.out.println("ruta: null");
        }
    }
}
