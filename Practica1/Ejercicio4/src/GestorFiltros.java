public class GestorFiltros {
    private CadenaFiltros cadenaFiltros;

    public GestorFiltros(Objetivo objetivo){
        cadenaFiltros = new CadenaFiltros();
        cadenaFiltros.setObjetivo(objetivo);
    }

    public void addFiltro( Filtro filtro){
        cadenaFiltros.addFiltro(filtro);
    }
}
