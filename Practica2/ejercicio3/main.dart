import 'package:flutter/material.dart';
import 'package:ejercicio3/producto.dart';
import 'package:ejercicio3/categoria.dart';
import 'package:ejercicio3/filtroStruct.dart';
import 'package:ejercicio3/PorCategoria.dart';
import 'package:ejercicio3/PrecioMinimo.dart';
import 'package:ejercicio3/PrecioMaximo.dart';
import 'package:ejercicio3/EnOferta.dart';
import 'package:ejercicio3/filtro.dart';
import 'package:ejercicio3/gestorFiltros.dart';
import 'package:ejercicio3/cesta.dart';

void main() {
  Producto p1 = Producto("p1", Categoria.cosmeticos, 10, true);
  Producto p2 = Producto("p2", Categoria.cosmeticos, 50, false);
  Producto p3 = Producto("p3", Categoria.cosmeticos, 24, true);
  Producto p4 = Producto("p4", Categoria.ropa, 15.2, false);
  Producto p5 = Producto("p5", Categoria.ropa, 70, false);
  Producto p6 = Producto("p6", Categoria.ropa, 32, true);
  Producto p7 = Producto("p7", Categoria.alimentacion, 12, true);
  Producto p8 = Producto("p8", Categoria.alimentacion, 23, true);
  Producto p9 = Producto("p9", Categoria.alimentacion, 9, false);

  List<Producto> productos = [];
  productos.add(p1);
  productos.add(p2);
  productos.add(p3);
  productos.add(p4);
  productos.add(p5);
  productos.add(p6);
  productos.add(p7);
  productos.add(p8);
  productos.add(p9);

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

  GestorFiltros gestorFiltros = GestorFiltros(productos);

  Filtro oferta = EnOferta();
  Filtro precioMin = PrecioMinimo();
  Filtro precioMax = PrecioMaximo();
  Filtro categoria = PorCategoria();
  gestorFiltros.addFiltro(oferta);
  gestorFiltros.addFiltro(precioMin);
  gestorFiltros.addFiltro(precioMax);
  gestorFiltros.addFiltro(categoria);

  Cesta cesta = Cesta(gestorFiltros);
  FiltroStruct filtros = FiltroStruct(0, 50, true, Categoria.ropa);

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

  //runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // TRY THIS: Try running your application with "flutter run". You'll see
        // the application has a purple toolbar. Then, without quitting the app,
        // try changing the seedColor in the colorScheme below to Colors.green
        // and then invoke "hot reload" (save your changes or press the "hot
        // reload" button in a Flutter-supported IDE, or press "r" if you used
        // the command line to start the app).
        //
        // Notice that the counter didn't reset back to zero; the application
        // state is not lost during the reload. To reset the state, use hot
        // restart instead.
        //
        // This works for code too, not just values: Most code changes can be
        // tested with just a hot reload.
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // TRY THIS: Try changing the color here to a specific color (to
        // Colors.amber, perhaps?) and trigger a hot reload to see the AppBar
        // change color while the other colors stay the same.
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          // Column is also a layout widget. It takes a list of children and
          // arranges them vertically. By default, it sizes itself to fit its
          // children horizontally, and tries to be as tall as its parent.
          //
          // Column has various properties to control how it sizes itself and
          // how it positions its children. Here we use mainAxisAlignment to
          // center the children vertically; the main axis here is the vertical
          // axis because Columns are vertical (the cross axis would be
          // horizontal).
          //
          // TRY THIS: Invoke "debug painting" (choose the "Toggle Debug Paint"
          // action in the IDE, or press "p" in the console), to see the
          // wireframe for each widget.
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
