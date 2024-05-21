import 'package:ejercicio3/categoria.dart';

class Producto {
  int? id;
  String nombre;
  Categoria categoria;
  double precio;
  bool descuento;
  String? usuario;
  bool promo_aplicada;

  Producto(
      {required this.id,
      required this.nombre,
      required this.categoria,
      required this.precio,
      required this.descuento,
      required this.promo_aplicada,
      required this.usuario
});

  String getNombre() {
    return nombre;
  }

  void setNombre(String nombre) {
    this.nombre = nombre;
  }

  bool getPromoAplicada() {
    return promo_aplicada;
  }

  void setPromoAplicada(bool promo_aplicada) {
    this.promo_aplicada = promo_aplicada;
  }

  int? getId() {
    return id;
  }

  void setid(int id) {
    this.id = id;
  }

  double getPrecio() {
    return precio;
  }

  void setPrecio(double precio) {
    this.precio = precio;
  }

  bool getDescuento() {
    return descuento;
  }

  void setDescuento(bool descuento) {
    this.descuento = descuento;
  }

  Categoria getCategoria() {
    return categoria;
  }

  bool getpromoAplicada() {
    return promo_aplicada;
  }

  void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  String? getUsuario() {
    return usuario;
  }

  void setUsuario(String? usuario) {
    this.usuario = usuario;
  }

  factory Producto.fromJson(Map<String, dynamic> json) {
    return Producto(
        id: json['id'] as int,
        nombre: json['nombre'] as String,
        categoria: stringToCategoria(json['categoria']),
        precio: json['precio'] is String
            ? double.parse(json['precio'])
            : json['precio'] as double,
        descuento: json['descuento'] as bool,
        promo_aplicada: json['promo_aplicada'] as bool,
        usuario: json['usuario'] as String
      );
  }

  Map<String, dynamic> toJson() {
    return {
      'producto': {
        if (id != null) 'id': id,
        'nombre': nombre,
        'categoria': categoriaToString(categoria),
        'precio': precio,
        'descuento': descuento,
        'promo_aplicada': promo_aplicada,
        'usuario': usuario,
      }
    };
  }

  String categoriaToString(Categoria categoria) {
    return categoria.toString().split('.').last;
  }

  static Categoria stringToCategoria(String categoria) {
    return Categoria.values
        .firstWhere((e) => e.toString().split('.').last == categoria);
  }

  @override
  String toString() {
    return 'Producto{id: $id, nombre: $nombre, categoria: $categoria, precio: $precio, descuento: $descuento, promo_aplicada: $promo_aplicada, usuario: $usuario}';
  }
}
