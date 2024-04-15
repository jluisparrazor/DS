import 'package:ejercicio3/filtro.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtroStruct.dart';

class CadenaFiltros {
  late List<Filtro> filtros;
  late List<Producto> productos;

  CadenaFiltros(List<Producto> productos) {
    this.productos = productos;
    filtros = [];
  }

  List<Producto> filtrar(FiltroStruct filtrosStruct) {
    List<Producto> productosFiltrados = productos;

    for (int i = 0; i < filtros.length; i++) {
      productosFiltrados = filtros[i].filtrar(productosFiltrados, filtrosStruct);
    }

    return productosFiltrados;
  }

  void addFiltro(Filtro filtro) {
    filtros.add(filtro);
  }
}
