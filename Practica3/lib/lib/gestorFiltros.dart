import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtro.dart';
import 'package:ejercicio3/filtroStruct.dart';
import 'package:ejercicio3/cadenaFiltros.dart';

class GestorFiltros {
  late CadenaFiltros cadenaFiltros;

  GestorFiltros(List<Producto> productos) {
    cadenaFiltros = CadenaFiltros(productos);
  }

  void addFiltro(Filtro filtro) {
    cadenaFiltros.addFiltro(filtro);
  }

  List<Producto> filtrar(FiltroStruct filtrosAplicar) {
    return cadenaFiltros.filtrar(filtrosAplicar);
  }
}
