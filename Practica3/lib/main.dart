import 'package:flutter/material.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/categoria.dart';
import 'package:ejercicio3/filtroStruct.dart';
import 'package:ejercicio3/gestorFiltros.dart';
import 'package:ejercicio3/cesta.dart';
import 'package:flutter/services.dart';
import 'package:ejercicio3/utils.dart';

void main() {
  List<Producto> productos = crearProductos();

  for (int i = 0; i < productos.length; i++) {
    String descuento;
    if (productos[i].getDescuento() == true) {
      descuento = "Si";
    } else {
      descuento = "No";
    }
    print("Producto:" +
        productos[i].getNombre() +
        ". Precio: " +
        productos[i].getPrecio().toString() +
        ". Categoria: " +
        productos[i].categoria.toString() +
        ". Descuento: " +
        descuento);
  }

  GestorFiltros gestorFiltros = inicializarGestorFiltros(productos);
  Cesta cesta = Cesta(gestorFiltros);
  FiltroStruct filtros = FiltroStruct(50, -1, false, Categoria.ropa);

  List<Producto> productosFiltrados = cesta.filtrar(filtros);

  for (int i = 0; i < productosFiltrados.length; i++) {
    String descuento;
    if (productos[i].descuento == true) {
      descuento = "Si";
    } else {
      descuento = "No";
    }
    print("Producto:" +
        productosFiltrados[i].getNombre() +
        ". Precio: " +
        productosFiltrados[i].getPrecio().toString() +
        ". Categoria: " +
        productosFiltrados[i].categoria.toString() +
        ". Descuento: " +
        descuento);
  }

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Ejercicio 3',
      theme: ThemeData(
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Ejercicio 3'),
    );
  }
}

class CustomInputFormatter extends TextInputFormatter {
  @override
  TextEditingValue formatEditUpdate(
      TextEditingValue oldValue, TextEditingValue newValue) {
    final hasOnlyOneDot = newValue.text.split('.').length - 1 <= 1;
    final hasValidCharacters =
        newValue.text.replaceAll(RegExp(r'[0-9.]'), '').isEmpty;

    if (hasOnlyOneDot && hasValidCharacters) {
      return newValue;
    } else {
      return oldValue;
    }
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  TextEditingController valMinController = TextEditingController();
  TextEditingController valMaxController = TextEditingController();
  String descuento = "Todos los productos", dropdownValue = "Ninguna";
  List<Producto> productos = crearProductos();
  late List<Producto> productosFiltrados = productos;
  late GestorFiltros gestorFiltros = inicializarGestorFiltros(productos);
  late Cesta cesta = Cesta(gestorFiltros);
  late FiltroStruct filtros = FiltroStruct(-1, -1, false, Categoria.ninguna);
  List<String> list = ["Alimentacion", "Cosmeticos", "Ropa", "Ninguna"];

  @override
  void initState() {
    super.initState();

    valMinController.addListener(() {
      setState(() {
        if (valMinController.text.isNotEmpty) {
          filtros.precioMin = double.parse(valMinController.text);
        } else {
          filtros.precioMin = -1;
        }
      });
    });

    valMaxController.addListener(() {
      setState(() {
        if (valMaxController.text.isNotEmpty) {
          filtros.precioMax = double.parse(valMaxController.text);
        } else {
          filtros.precioMax = -1;
        }
      });
    });
  }

  @override
  void dispose() {
    valMinController.dispose();
    valMaxController.dispose();
    super.dispose();
  }

  void dropdownButtonCallback(String? newValue) {
    setState(() {
      dropdownValue = newValue!;
      if (newValue == "Alimentacion") {
        filtros.categoria = Categoria.alimentacion;
      } else if (newValue == "Cosmeticos") {
        filtros.categoria = Categoria.cosmeticos;
      } else if (newValue == "Ropa") {
        filtros.categoria = Categoria.ropa;
      } else {
        filtros.categoria = Categoria.ninguna;
      }
    });
  }

  void valMinControllerCallback() {
    setState(() {
      if (valMinController.text.isNotEmpty) {
        filtros.precioMin = double.parse(valMinController.text);
      } else {
        filtros.precioMin = -1;
      }
    });
  }

  void valMaxControllerCallback() {
    setState(() {
      if (valMaxController.text.isNotEmpty) {
        filtros.precioMax = double.parse(valMaxController.text);
      } else {
        filtros.precioMax = -1;
      }
    });
  }

  void elevatedButtonDescuentoCallback() {
    setState(() {
      if (filtros.descuento == true) {
        filtros.descuento = false;
        descuento = "Todos los productos";
      } else {
        filtros.descuento = true;
        descuento = "Productos con descuento";
      }
    });
  }

  void elevatedButtonReiniciarCallback() {
    setState(() {
      productosFiltrados = productos;
      valMaxController.clear();
      valMinController.clear();
      descuento = "Todos los productos";
      dropdownValue = "Ninguna";
    });
  }

  void elevatedButtonAplicarCallback() {
    setState(() {
      productosFiltrados = cesta.filtrar(filtros);
    });
  }

  void eliminarProducto(Producto producto) {
    setState(() {
      cesta.eliminarProducto(producto);
    });
  }

  void adquirirProducto(Producto producto) {
    setState(() {
      cesta.adquirirProducto(producto);
    });
  }
  
  void eliminarOcurrencias(Producto producto) {
    setState(() {
      cesta.eliminarOcurrencias(producto);
    });
  }

  void vaciarCesta() {
    setState(() {
      cesta.vaciarCesta();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.amber,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            const SizedBox(height: 50),
            Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: <Widget>[
                  const Text(
                    "Filtros: ",
                    style: TextStyle(
                      fontSize: 24,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  DropdownButton<String>(
                    value: dropdownValue,
                    onChanged: (String? newValue) {
                      dropdownButtonCallback(newValue);
                    },
                    items: list.map<DropdownMenuItem<String>>((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                  ),
                  SizedBox(
                    width: 250,
                    child: TextField(
                      controller: valMinController,
                      decoration: const InputDecoration(
                          hintText: 'Ingrese el valor mínimo'),
                      keyboardType: TextInputType.number,
                      textAlign: TextAlign.center,
                      inputFormatters: <TextInputFormatter>[
                        CustomInputFormatter(), // Solo permite dígitos
                      ],
                      onTap: () {
                        valMinControllerCallback();
                      },
                    ),
                  ),
                  SizedBox(
                    width: 250,
                    child: TextField(
                      controller: valMaxController,
                      decoration: const InputDecoration(
                          hintText: 'Ingrese el valor máximo'),
                      keyboardType: TextInputType.number,
                      textAlign: TextAlign.center,
                      inputFormatters: <TextInputFormatter>[
                        CustomInputFormatter(),
                      ],
                      onTap: () {
                        valMaxControllerCallback();
                      },
                    ),
                  ),
                  ElevatedButton(
                    onPressed: () {
                      elevatedButtonDescuentoCallback();
                    },
                    child: Text(descuento),
                  )
                ]),
            const SizedBox(height: 50),
            Row(mainAxisAlignment: MainAxisAlignment.center, children: <Widget>[
              ElevatedButton(
                onPressed: () {
                  elevatedButtonAplicarCallback();
                },
                child: const Text("Aplicar filtros"),
              ),
              const SizedBox(width: 50),
              ElevatedButton(
                onPressed: () {
                  elevatedButtonReiniciarCallback();
                },
                child: const Text("Reiniciar filtros"),
              )
            ]),
            const SizedBox(height: 50),
            const Text("Productos: ",
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                )),
            Expanded(
              child: ListView.builder(
                itemCount: productosFiltrados.length,
                itemBuilder: (context, index) {
                  return ListTile(
                    title: Text(productosFiltrados[index].getNombre() +
                        "         Precio: " +
                        productosFiltrados[index].getPrecio().toString() +
                        "€"),
                    trailing: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: <Widget>[
                        Text(
                          "x " +
                              cesta
                                  .cantidadProducto(productosFiltrados[index])
                                  .toString(),
                          style: TextStyle(
                            fontSize: 16,
                          ),
                        ),
                        IconButton(
                          icon: const Icon(Icons.add_shopping_cart),
                          onPressed: () {
                            adquirirProducto(productosFiltrados[index]);
                          },
                        ),
                        IconButton(
                          icon: const Icon(Icons.remove_shopping_cart),
                          onPressed: () {
                            eliminarProducto(productosFiltrados[index]);
                          },
                        ),
                      ],
                    ),
                  );
                },
              ),
            ),
            const SizedBox(height: 5),
            const Divider(color: Color.fromARGB(255, 250, 193, 24)),
            const SizedBox(height: 5),
            const Text("Cesta: ",
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                )),
            Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: <Widget>[
                  Text("Precio total: " + cesta.precioTotal().toString() + "€",
                      style: TextStyle(
                        fontSize: 16,
                        fontWeight: FontWeight.bold,
                      )),
                  IconButton(
                    icon: const Icon(Icons.delete),
                    onPressed: () {
                      vaciarCesta();
                    },
                  ),
                ]),
            Expanded(
              child: ListView.builder(
                itemCount: cesta.productosAdquiridos.length,
                itemBuilder: (context, index) {
                  Producto producto =
                      cesta.productosAdquiridos.keys.toList()[index];
                  return ListTile(
                    title: Text(producto.nombre),
                    trailing: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: <Widget>[
                        Text(
                          "x " + cesta.cantidadProducto(producto).toString(),
                          style: TextStyle(
                            fontSize: 16,
                          ),
                        ),
                        IconButton(
                          icon: const Icon(Icons.add_shopping_cart),
                          onPressed: () {
                            adquirirProducto(producto);
                          },
                        ),
                        IconButton(
                          icon: const Icon(Icons.remove_shopping_cart),
                          onPressed: () {
                            eliminarProducto(producto);
                          },
                        ),
                        IconButton(
                          icon: const Icon(Icons.delete),
                          onPressed: () {
                            eliminarOcurrencias(producto);
                          },
                        ),
                      ],
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
