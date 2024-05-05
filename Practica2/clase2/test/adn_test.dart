import 'package:flutter_test/flutter_test.dart';

import 'package:clase2/main.dart';
import 'package:clase2/adn.dart';

void main() {
  test('Comprobar si admite secuencias invalidas ', () {
    //expect(davadn, throwsException);
    expect(() => ADN('ACTDAVIDLACHUPAG'), throwsException);
  });

  test('Comprobar complemento ', () {
    ADN adn1 = ADN("ACTG");
    expect(adn1.complemento(), 'TGAC');
  });

  test('Comprobar SECUENCIA ', () {
    ADN adn1 = ADN("ACTGACTG");
    ADN adn2 = ADN("ACTGAAAAACCCTTTTCCGG");

    expect(ADN.subsecuenciaComunMasLarga(adn1, adn2), 'ACTGA');
    expect(ADN.subsecuenciaComunMasLarga(ADN('ACTTTTTT'), adn1), 'ACT');
    expect(ADN.subsecuenciaComunMasLarga(ADN('AGGC'), ADN('GCGAAA')), 'GC');
  });
}
