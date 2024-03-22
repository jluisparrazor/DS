
public class main {
    public static void main(String args []) {
        //Creamos paginas
        ElementoWeb paginaPrincipal = new Pagina("Portada", 1);
        ElementoWeb subpagina1 = new Pagina("cuento", 2);
        
        
        //Creamos textos
        Contenido Texto1 = new Texto("Parrafo 1", 11);
        Contenido Texto2 = new Texto("Parrafo 2", 12);
        Contenido Texto3 = new Texto("Parrafo 3", 12);

        //Creamos imagenes
        Contenido Imagen1 = new Imagen("Imagen 1", 21);
        Contenido Imagen2 = new Imagen("Imagen 2", 24);
        Contenido Imagen3 = new Imagen("Imagen 3", 23);

        //Si se puede insertar
        paginaPrincipal.add(subpagina1);
        subpagina1.add(Texto1);
        subpagina1.add(Texto2);
        Texto1.add(Imagen1);
        Texto2.add(Imagen2);
        Texto2.add(Texto3);
        
        System.out.println("");

        //No se puede insertar
        Imagen2.add(Imagen3);
        Texto1.add(paginaPrincipal);
        Imagen2.add(paginaPrincipal);

        System.out.println("");
        
        //Mostramos por pantalla
        paginaPrincipal.nombrar();
        subpagina1.nombrar();
        Texto1.nombrar();
        Texto2.nombrar();
        


        

    }



}
