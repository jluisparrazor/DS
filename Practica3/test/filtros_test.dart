import 'package:flutter_test/flutter_test.dart';
import 'package:ejercicio3/utils.dart';
import 'package:ejercicio3/gestorFiltros.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/cesta.dart';
import 'package:ejercicio3/categoria.dart';
import 'package:ejercicio3/filtroStruct.dart';
import 'package:ejercicio3/PrecioMaximo.dart';
import 'package:ejercicio3/PrecioMinimo.dart';
import 'package:ejercicio3/EnOferta.dart';
import 'package:ejercicio3/PorCategoria.dart';
import 'package:ejercicio3/filtro.dart';

void main() {
  group("Grupo para comprobar Productos: ", () {
    late List<Producto> productos;
    late GestorFiltros gestorFiltros;
    late Cesta cesta;

    setUp(() {
      productos = leerJson("test/test.json");
      gestorFiltros = inicializarGestorFiltros(productos);
      cesta = Cesta(gestorFiltros);
    });

    test("Prueba de leer Productos en Json", () {
      expect(productos, isNotNull);
      expect(productos.length, 3);

      Producto producto = productos[0];
      expect(producto.getNombre(), "Eyeliner");
      expect(producto.getCategoria(), Categoria.cosmeticos);
      expect(producto.getPrecio(), 10);
      expect(producto.getDescuento(), true);

      producto = productos[1];
      expect(producto.getNombre(), "Pantalones");
      expect(producto.getCategoria(), Categoria.ropa);
      expect(producto.getPrecio(), 15);
      expect(producto.getDescuento(), false);

      producto = productos[2];
      expect(producto.getNombre(), "Helado");
      expect(producto.getCategoria(), Categoria.alimentacion);
      expect(producto.getPrecio(), 4);
      expect(producto.getDescuento(), false);
    });

    test("Prueba de Adquirir Producto", () {
      cesta.adquirirProducto(productos[0]);
      expect(cesta.productosAdquiridos.containsKey(productos[0]), true);
    });

    test("Prueba de Eliminar Producto", () {
      expect(productos, isNotNull);
      expect(productos.length, 3);

      cesta.adquirirProducto(productos[0]);
      cesta.adquirirProducto(productos[1]);
      cesta.eliminarProducto(productos[0]);

      expect(cesta.productosAdquiridos.containsKey(productos[0]), false);
      expect(cesta.productosAdquiridos.containsKey(productos[1]), true);
    });

    test("Prueba de Precio Total", () {
      cesta.adquirirProducto(productos[0]);
      expect(cesta.precioTotal(), 10);
    });

    test("Prueba de Calcular Cantidad Producto", () {
      cesta.adquirirProducto(productos[0]);
      cesta.adquirirProducto(productos[0]);
      cesta.adquirirProducto(productos[0]);
      expect(cesta.cantidadProducto(productos[0]), 3);
    });

    test("Prueba de eliminar ocurrencias", () {
      cesta.adquirirProducto(productos[0]);
      cesta.adquirirProducto(productos[0]);
      cesta.adquirirProducto(productos[0]);
      cesta.eliminarOcurrencias(productos[0]);
      expect(cesta.productosAdquiridos, {});
    });
  });

  group("Grupo para comprobar Filtros: ", () {
    late List<Producto> productos;
    late FiltroStruct filtroStruct;
    late GestorFiltros gestorFiltros;
    List<Producto> actual;
    List<Producto> esperado;

    setUp(() {
      productos = leerJson("test/test.json");
      gestorFiltros = inicializarGestorFiltros(productos);
    });
    test("Prueba de inicialización de gestor filtros", () {
      expect(gestorFiltros.cadenaFiltros.productos, productos);

      List<Filtro> filtros = [
        EnOferta(),
        PrecioMinimo(),
        PrecioMaximo(),
        PorCategoria()
      ];

      List<String> nombreFiltros =
          filtros.map((filtro) => filtro.runtimeType.toString()).toList();
      List<String> nombreFiltrosGestor = gestorFiltros.cadenaFiltros.filtros
          .map((filtro) => filtro.runtimeType.toString())
          .toList();

      nombreFiltros.sort();
      nombreFiltrosGestor.sort();

      expect(nombreFiltrosGestor, nombreFiltros);
    });
    test("Prueba de Precio Máximo", () {
      Filtro maximo = PrecioMaximo();
      filtroStruct = FiltroStruct(0, 10, false, Categoria.ninguna);

      actual = maximo.filtrar(productos, filtroStruct);
      esperado = [productos[0], productos[2]];

      expect(actual, esperado);
    });
    test("Prueba de Precio Mínimo", () {
      Filtro minimo = PrecioMinimo();
      filtroStruct = FiltroStruct(5, -1, false, Categoria.ninguna);

      actual = minimo.filtrar(productos, filtroStruct);
      esperado = [productos[0], productos[1]];

      expect(actual, esperado);
    });
    test("Prueba de En Oferta", () {
      Filtro oferta = EnOferta();
      filtroStruct = FiltroStruct(-1, -1, true, Categoria.ninguna);

      actual = oferta.filtrar(productos, filtroStruct);
      esperado = [productos[0]];

      expect(actual, esperado);
    });
    test("Prueba de Por Categoria", () {
      Filtro categoria = PorCategoria();
      filtroStruct = FiltroStruct(-1, -1, false, Categoria.alimentacion);

      actual = categoria.filtrar(productos, filtroStruct);
      esperado = [productos[2]];

      expect(actual, esperado);
    });
    test("Prueba con varios filtros", () {
      productos = leerJson("lib/productos.json");
      gestorFiltros = inicializarGestorFiltros(productos);
      Filtro categoria = PorCategoria(),
          enOferta = EnOferta(),
          min = PrecioMinimo(),
          max = PrecioMaximo();

      gestorFiltros.addFiltro(enOferta);
      gestorFiltros.addFiltro(categoria);
      gestorFiltros.addFiltro(min);
      gestorFiltros.addFiltro(max);
      filtroStruct = FiltroStruct(10, 25, true, Categoria.alimentacion);

      actual = gestorFiltros.filtrar(filtroStruct);

      esperado = [productos[9], productos[10]];

      expect(actual, esperado);
    });
  });
}
