import 'package:ejercicio3/gestorFiltros.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtroStruct.dart';

class Cesta {
  late GestorFiltros gestor;
  late Map<Producto, int> productosAdquiridos;

  Cesta(GestorFiltros gestorFiltro) {
    gestor = gestorFiltro;
    productosAdquiridos = {};
  }

  List<Producto> filtrar(FiltroStruct filtros) {
    return gestor.filtrar(filtros);
  }

  void adquirirProducto(Producto producto) {
    if (productosAdquiridos.containsKey(producto)) {
      productosAdquiridos[producto] = productosAdquiridos[producto]! + 1;
    } else {
      productosAdquiridos[producto] = 1;
    }
  }

  bool eliminarProducto(Producto producto) {
    if (productosAdquiridos.containsKey(producto)) {
      if (productosAdquiridos[producto]! > 1) {
        productosAdquiridos[producto] = productosAdquiridos[producto]! - 1;
      } else {
        productosAdquiridos.remove(producto);
      }
      return true;
    }
    return false;
  }

  void eliminarOcurrencias(Producto producto) {
    productosAdquiridos.remove(producto);
  }

  void vaciarCesta() {
    productosAdquiridos.clear();
  }

  int cantidadProducto(Producto producto) {
    return productosAdquiridos[producto] ?? 0;
  }

  double precioTotal() {
    double precio = 0;
    productosAdquiridos.forEach((producto, cantidad) {
      precio += producto.precio * cantidad;
    });
    return precio;
  }


}

