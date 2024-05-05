import 'operacion.dart';

class Multiplicacion extends Operacion {
  @override
  double calcular(double num1, double num2) {
    return num1 * num2;
  }
}