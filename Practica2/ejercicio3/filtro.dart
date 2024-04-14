import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtroStruct.dart';

abstract class Filtro {
  List<Producto> filtrar(List<Producto> productos, FiltroStruct filtros);
}
