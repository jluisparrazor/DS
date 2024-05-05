import 'operacion.dart';

class Division extends Operacion {
  @override
  double calcular(double num1, double num2) {
    if (num2 != 0) {
      return num1 / num2;
    } else {
      return double.infinity;
    }
  }
}
