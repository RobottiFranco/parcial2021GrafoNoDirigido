
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TGrafoRedDatos extends TGrafoNoDirigido implements IGrafoRedDatos {

    public TGrafoRedDatos(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public LinkedList<TVertice> rutaMenosSaltos(Comparable origen, Comparable destino) {
        List<TVertice> menosSaltos = menosSaltos(origen, destino);
        return (LinkedList) menosSaltos;

    }

}