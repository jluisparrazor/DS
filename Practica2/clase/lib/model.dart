class Alumno {
  String nombre;
  int edad;
  String carrera;
  double notaMedia;

  Alumno(this.nombre, this.edad, this.carrera, this.notaMedia);

  @override
  String toString() {
    return 'Alumno: $nombre, Edad: $edad, Carrera: $carrera, Nota Media: $notaMedia';
  }
}



class Universidad {
  String nombre;
  List<Alumno> alumnos;

  Universidad(this.nombre, [List<Alumno>? alumnos])
      : alumnos = alumnos ?? [];

  void agregarAlumno(Alumno nuevoAlumno) {
    if (validarAlumno(nuevoAlumno)) {
      alumnos.add(nuevoAlumno);
    } else {
      throw Exception('Datos del alumno no válidos');
    }
  }

  bool validarAlumno(Alumno alumno) {
    return alumno.nombre.isNotEmpty && alumno.edad > 0 && alumno.carrera.isNotEmpty;
  }

  double edadPromedio() {
    if (alumnos.isEmpty) {
      return 0;
    }
    return alumnos.map((a) => a.edad).reduce((a, b) => a + b) / alumnos.length;
  }

  Alumno? buscarAlumno(String nombre) {
    try {
      return alumnos.firstWhere((alumno) => alumno.nombre == nombre);
    } catch (e) {
      return null;
    }
  }

  void ordenarAlumnosPorNotaMedia() {
    alumnos.sort((a, b) => b.notaMedia.compareTo(a.notaMedia));
  }


  @override
  String toString() {
    return 'Universidad: $nombre\nAlumnos: ${alumnos.map((a) => a.toString()).join('\n')}';
  }
}