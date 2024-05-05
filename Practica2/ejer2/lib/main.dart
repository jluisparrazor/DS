import 'package:flutter/material.dart';
import 'gestorDeTareas.dart';
import 'tarea.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Ejercicio2',
      theme: ThemeData(
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Tareas Ejercicio 2'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final gestorDeTareas gestor = gestorDeTareas();
  final TextEditingController descrip = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.green,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            Text(
              'Introduce la desccripción de la tarea: ',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
            TextField(
              controller: descrip,
              onChanged: (value) {
                setState(
                    () {}); // Actualizar el estado al escribir en el campo de texto
              },
              keyboardType: TextInputType.text,
              decoration: const InputDecoration(labelText: 'Descripción Tarea'),
            ),
            const SizedBox(height: 30),
            OutlinedButton(
              onPressed: descrip.text.isEmpty
                  ? null
                  : () {
                      setState(() {
                        gestor.agregarT(descrip.text);
                        descrip.clear();
                      });
                    },
              child: const Text(
                'Añadir Tarea',
                style: TextStyle(color: Colors.green),
              ),
            ),
            const SizedBox(height: 30),
            Expanded(
              child: ListView.builder(
                itemCount: gestor.tareas.length,
                itemBuilder: (context, index) {
                  final tarea = gestor.tareas[index];
                  return ListTile(
                    leading: Checkbox(
                      value: tarea.completada,
                      onChanged: (value) {
                        setState(() {
                          gestor.marcarCompletadas(index);
                        });
                      },
                    ),
                    title: Text(
                      tarea.descripcion,
                      style: () {
                        TextStyle textStyle = TextStyle();
                        if (tarea.completada) {
                          textStyle = TextStyle(
                            decoration: TextDecoration.lineThrough,
                          );
                        }
                        return textStyle;
                      }(),
                    ),
                    trailing: IconButton(
                      icon: const Icon(Icons.delete),
                      onPressed: () {
                        setState(() {
                          gestor.eliminarT(index);
                        });
                      },
                    ),
                  );
                },
              ),
            )
          ],
        ),
      ),
    );
  }
}
