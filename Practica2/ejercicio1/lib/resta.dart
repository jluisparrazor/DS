import 'operacion.dart';

class Resta extends Operacion {
  @override
  double calcular(double num1, double num2) {
    return num1 - num2;
  }
}