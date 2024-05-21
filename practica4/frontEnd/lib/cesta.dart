import 'package:ejercicio3/gestorFiltros.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/filtroStruct.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

class Cesta {
  late GestorFiltros gestor;
  late List<Producto> productos;
  late List<Producto> productosOriginales;
  late String usuario;
  final String apiUrl = "http://localhost:3000/productos";

  Cesta(GestorFiltros gestorFiltro, String user) {
    gestor = gestorFiltro;
    productos = [];
    productosOriginales = [];
    usuario = user;
  }

  List<Producto> filtrar(FiltroStruct filtros) {
    return gestor.filtrar(filtros);
  }

  Future<void> cargarProductos() async {
    final response = await http.get(Uri.parse('$apiUrl?usuario=$usuario'));
    if (response.statusCode == 200) {
      List<dynamic> productosJson = json.decode(response.body);

      productos.clear();
      productos.addAll(
          productosJson.map((json) => Producto.fromJson(json)).toList());
      productosOriginales.clear();
      productosOriginales.addAll(
          productosJson.map((json) => Producto.fromJson(json)).toList());
    } else {
      throw Exception('Failed to load productos');
    }
  }

  void adquirirProducto(Producto producto) {
    producto.setUsuario(usuario);
    productos.add(producto);
  }

  void eliminarProducto(Producto producto) {
    productos.remove(producto);
  }

  Future<void> eliminar(Producto producto) async {
    final response = await http.delete(
      Uri.parse('$apiUrl/${producto.id}'),
    );
    if (response.statusCode != 200) {
      throw Exception('Failed to delete product');
    }
  }

  void eliminarOcurrencias(Producto producto) {
    for (int i = 0; i < productos.length; i++) {
      if (producto.getNombre() == productos[i].getNombre()) {
        productos.removeAt(i);
        i--;
      }
    }
  }

  void vaciarCesta() {
    productos.clear();
  }

  double precioTotal() {
    double precio = 0;
    for (int i = 0; i < productos.length; i++) {
      precio += productos[i].getPrecio();
    }
    return precio;
  }

  Future<void> agregar(Producto producto) async {
    final response = await http.post(
      Uri.parse(apiUrl),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(producto.toJson()),
    );
    if (response.statusCode != 201) {
      throw Exception('Failed to add product: ${response.body}');
    } else
      productosOriginales.add(Producto.fromJson(json.decode(response.body)));
  }

  Future<void> subirCesta() async {
    for (int i = 0; i < productosOriginales.length; i++) {
      await eliminar(productosOriginales[i]);
    }
    productosOriginales.clear();
    for (int i = 0; i < productos.length; i++) {
      await agregar(productos[i]);
    }
  }

  Future<void> aplicarPromocion(Producto producto) async {
    final response = await http.put(
      Uri.parse('$apiUrl/${producto.id}'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode({
          'producto': {
          'precio': producto.getPrecio() / 2,
          'promo_aplicada': true,
        },
      }),
    );
    if (response.statusCode != 200) {
      throw Exception('Failed to update product: ${response.body}');
    } else {
      producto.setPrecio(producto.getPrecio() / 2);
      producto.setPromoAplicada(true);
      if (!productos.contains(producto)){
        productos.add(Producto.fromJson(json.decode(response.body)));
      }
    }
    
  }

  int cantidadProducto(Producto producto) {
    int numOcurrencias = 0;
    for (int i = 0; i < productos.length; i++) {
      if (productos[i].getNombre() == producto.getNombre()) {
        numOcurrencias++;
      }
    }
    return numOcurrencias;
  }
}
