import 'package:ejercici1/division.dart';
import 'package:ejercici1/multiplicacion.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'resta.dart';
import 'suma.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Calculadora Ejercicio1',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Calculadora Ejercicio 1'),
    );
  }
}

const List<String> list = <String>['+', '-', '*', '/'];

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final TextEditingController _primerNum = TextEditingController();
  final TextEditingController _segundoNum = TextEditingController();
  late String operacion = '+';
  double _resultado = 0;

  void _calcular() {
    setState(() {
      //double.tryParse intenta convertir el texto a double, si la conversión
      // se hace bien se asignan a la variables o si no se asigna 0
      double num1 = double.tryParse(_primerNum.text) ?? 0;
      double num2 = double.tryParse(_segundoNum.text) ?? 0;

      switch (operacion) {
        case '+':
          _resultado = Suma().calcular(num1, num2);
          break;
        case '-':
          _resultado = Resta().calcular(num1, num2);
          break;
        case '*':
          _resultado = Multiplicacion().calcular(num1, num2);
          break;
        case '/':
          if (num2 != 0) {
            _resultado = Division().calcular(num1, num2);
          } else {
            _resultado = double.infinity;
          }
          break;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.green,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Container(
                  constraints: const BoxConstraints(maxWidth: 150),
                  child: TextField(
                    controller: _primerNum,
                    keyboardType: TextInputType.number,
                    decoration:
                        const InputDecoration(labelText: 'Primer número'),
                  ),
                ),
                DropdownMenu<String>(
                  initialSelection: list.first,
                  onSelected: (String? value) {
                    // This is called when the user selects an item.
                    setState(() {
                      operacion = value!;
                    });
                  },
                  dropdownMenuEntries:
                      list.map<DropdownMenuEntry<String>>((String value) {
                    return DropdownMenuEntry<String>(
                        value: value, label: value);
                  }).toList(),
                ),
                Container(
                  constraints:
                      const BoxConstraints(maxWidth: 150), // Ancho máximo
                  child: TextField(
                    controller: _segundoNum,
                    keyboardType: TextInputType.number,
                    decoration:
                        const InputDecoration(labelText: 'Segundo número'),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 50),
            const Text(
              'Resultado',
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
                color: Colors.green,
              ),
            ),
            Text(
              '$_resultado',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _calcular,
        tooltip: 'Realizar cuenta',
        backgroundColor: Colors.green,
        child: const Text('Calcular'),
      ),
    );
  }
}
