import 'package:ejercicio3/categoria.dart';

class Producto {
  late String nombre;
  late Categoria categoria;
  late double precio;
  late bool descuento;

  Producto(String nom, Categoria cat, double prec, bool desc) {
    nombre = nom;
    categoria = cat;
    precio = prec;
    descuento = desc;
  }

  String getNombre() {
    return nombre;
  }

  double getPrecio() {
    return precio;
  }

  bool getDescuento() {
    return descuento;
  }

  Categoria getCategoria() {
    return categoria;

  }
}
