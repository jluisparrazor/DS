import 'package:ejercicio3/filtro.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtroStruct.dart';
import 'package:ejercicio3/categoria.dart';

class PorCategoria implements Filtro {
  @override
  List<Producto> filtrar(List<Producto> productos, FiltroStruct filtros) {
    if (filtros.categoria != Categoria.ninguna) {
      List<Producto> productosFiltrados = [];

      for (int i = 0; i < productos.length; i++) {
        if (productos[i].getCategoria() == filtros.categoria) {
          productosFiltrados.add(productos[i]);
        }
      }

      return productosFiltrados;
    } else {
      return productos;
    }
  }
}
