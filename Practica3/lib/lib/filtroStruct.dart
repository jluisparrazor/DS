import 'package:ejercicio3/categoria.dart';

class FiltroStruct {
  late bool descuento;
  late double precioMin, precioMax;
  late Categoria categoria;

  FiltroStruct(
      double precioMin, double precioMax, bool descuento, Categoria categoria) {
    this.precioMin = precioMin;
    this.precioMax = precioMax;
    this.descuento = descuento;
    this.categoria = categoria;
  }
}
