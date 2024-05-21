import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/categoria.dart';
import 'package:ejercicio3/PorCategoria.dart';
import 'package:ejercicio3/PrecioMinimo.dart';
import 'package:ejercicio3/PrecioMaximo.dart';
import 'package:ejercicio3/EnOferta.dart';
import 'package:ejercicio3/filtro.dart';
import 'package:ejercicio3/gestorFiltros.dart';
import 'dart:convert';
import 'dart:io';

List<Producto> crearProductos() {
  List<Producto> productos = leerJson("lib/productos.json");
  return productos;
}

GestorFiltros inicializarGestorFiltros(List<Producto> productos) {
  GestorFiltros gestorFiltros = GestorFiltros(productos);
  Filtro oferta = EnOferta();
  Filtro precioMin = PrecioMinimo();
  Filtro precioMax = PrecioMaximo();
  Filtro categoria = PorCategoria();

  gestorFiltros.addFiltro(oferta);
  gestorFiltros.addFiltro(precioMin);
  gestorFiltros.addFiltro(precioMax);
  gestorFiltros.addFiltro(categoria);

  return gestorFiltros;
}

List<Producto> leerJson(String nombreArchivo) {
  List<Producto> productos = [];
  String content = File(nombreArchivo).readAsStringSync();
  List<dynamic> data = json.decode(content);
  for (var item in data) {
    Categoria categoria = seleccionaCategoria(item['categoria']);
    Producto producto = Producto(
        id: item['id'],
        nombre: item['nombre'],
        categoria: categoria,
        precio: item['precio'].toDouble(),
        descuento: item['descuento'],
        promo_aplicada : item['promo_aplicada'],
        usuario: item['usuario']);

    productos.add(producto);
  }
  return productos;
}

Categoria seleccionaCategoria(String categoria) {
  switch (categoria) {
    case 'Categoria.cosmeticos':
      return Categoria.cosmeticos;
    case 'Categoria.ropa':
      return Categoria.ropa;
    case 'Categoria.alimentacion':
      return Categoria.alimentacion;
    default:
      throw Exception('Categoria no válida');
  }
}
