import 'tarea.dart';

class gestorDeTareas {
  late List<Tarea> tareas;

  gestorDeTareas() {
    tareas = [];
  }

  void agregarT(String descripcion) {
    Tarea t = Tarea(descripcion);
    tareas.add(t);
  }

  void eliminarT(int i) {
    tareas.removeAt(i);
  }

  void marcarCompletadas(int i) {
    tareas[i].completada = true;
  }
}
