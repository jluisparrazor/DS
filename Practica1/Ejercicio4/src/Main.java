public class Main {
    public static void main(String[] args){
        Objetivo salpicadero = new Objetivo();
        
        GestorFiltros gestorFiltros = new GestorFiltros(salpicadero);
        gestorFiltros.addFiltro(new CalcularVelocidad());
        gestorFiltros.addFiltro(new RepercutirRozamiento());

        Cliente cliente = new Cliente(gestorFiltros);

        Vista vista = new Vista(cliente, salpicadero);
        vista.setVisible(true);
    }
}
