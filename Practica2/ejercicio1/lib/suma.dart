import 'operacion.dart';

class Suma extends Operacion {
  @override
  double calcular(double num1, double num2) {
    return num1 + num2;
  }
}
