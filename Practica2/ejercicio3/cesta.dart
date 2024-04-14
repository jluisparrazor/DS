import 'package:ejercicio3/gestorFiltros.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtroStruct.dart';

class Cesta {
  late GestorFiltros gestor;
  List<Producto> productosAdquiridos = [];

  Cesta(GestorFiltros gestorFiltro) {
    gestor = gestorFiltro;
  }

  List<Producto> filtrar(FiltroStruct filtros) {
    return gestor.filtrar(filtros);
  }
}
