import 'package:ejercicio3/filtro.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtroStruct.dart';

class PrecioMinimo implements Filtro {
  @override
  List<Producto> filtrar(List<Producto> productos, FiltroStruct filtros) {
    if (filtros.precioMin != -1) {
      List<Producto> productosFiltrados = [];

      for (int i = 0; i < productos.length; i++) {
        if (productos[i].precio >= filtros.precioMin) {
          productosFiltrados.add(productos[i]);
        }
      }

      return productosFiltrados;
    } else {
      return productos;
    }
  }
}
