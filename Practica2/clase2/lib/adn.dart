class ADN {
  String secuencia;

  ADN(this.secuencia) {
    if (!RegExp(r'^[ACGT]+$').hasMatch(secuencia)) {
      throw Exception('Secuencia de ADN inválida, sólo debe contener los caracteres A, C, G y T.');
    }
  }

  Map<String, int> contarBases() {
    Map<String, int> bases = {'A': 0, 'C': 0, 'G': 0, 'T': 0};
    for (var base in secuencia.split('')) {
      bases[base] = (bases[base] ?? 0) + 1;
    }
    return bases;
  }

  String complemento() {
    Map<String, String> complementos = {'A': 'T', 'T': 'A', 'C': 'G', 'G': 'C'};
    return secuencia.split('').map((base) => complementos[base]).join('');
  }

  String transcribirARN() {
    return secuencia.replaceAll('T', 'U');
  }

  double contenidoGC() {
    var countGC = secuencia.split('').where((c) => c == 'G' || c == 'C').length;
    return (countGC / secuencia.length) * 100;
  }

  static String subsecuenciaComunMasLarga(ADN adn1, ADN adn2) {
    String s1 = adn1.secuencia;
    String s2 = adn2.secuencia;
    List<List<int>> matriz = List.generate(s1.length + 1,
        (i) => List.filled(s2.length + 1, 0, growable: false),
        growable: false);
    int maxLength = 0;
    int endIndex = 0;
    for (int i = 1; i <= s1.length; i++) {
      for (int j = 1; j <= s2.length; j++) {
        if (s1[i - 1] == s2[j - 1]) {
          matriz[i][j] = matriz[i - 1][j - 1] + 1;
          if (matriz[i][j] > maxLength) {
            maxLength = matriz[i][j];
            endIndex = i;
          }
        }
      }
    }
    return s1.substring(endIndex - maxLength, endIndex);
  }
}

