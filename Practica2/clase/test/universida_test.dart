import 'package:flutter_test/flutter_test.dart';

import 'package:clase/main.dart';
import 'package:clase/model.dart';

void main() {
  test('Incrementa lista de alumnos', () {
    Universidad universidad = Universidad('UGR');
    Alumno alumno = Alumno('Juan', 20, 'Ingeniería', 8.5);
    universidad.agregarAlumno(alumno);
    expect(universidad.alumnos.length, 1);
  });

  test('Comprobar edad promedio', () {
    Universidad universidad = Universidad('UGR');
    Alumno alumno = Alumno('Juan', 20, 'Ingeniería', 8.5);
    Alumno alumno1 = Alumno('Pedro', 22, 'Ingeniería', 7.5);
    universidad.agregarAlumno(alumno);
    universidad.agregarAlumno(alumno1);
    expect(universidad.edadPromedio(), 21);
  });

  test('Comprobar ordenaAlumnos', () {
    Universidad universidad = Universidad('UGR');
    Alumno alumno = Alumno('Juan', 20, 'Ingeniería', 8.5);
    Alumno alumno1 = Alumno('Pedro', 22, 'Ingeniería', 7.5);
    universidad.agregarAlumno(alumno1);
    universidad.agregarAlumno(alumno);
    universidad.ordenarAlumnosPorNotaMedia();
    expect(universidad.alumnos, [alumno, alumno1]);
  });


}
