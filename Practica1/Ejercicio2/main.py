import copy
from FactoriaMontana import FactoriaMontana
from FactoriaCarretera import FactoriaCarretera

if __name__ == "__main__":
    factoriaMontana = FactoriaMontana()
    bicicletasMontana = []
    factoriaCarretera = FactoriaCarretera()
    bicicletasCarretera = []

    # Creacion de la bicicleta de montana original
    bicicleta = factoriaMontana.crear_bicicleta(1)
    bicicletasMontana.append(bicicleta)

    # Inclusion del resto de bicicletas a partir de una copia de la original
    for i in range(9):
        bicicleta_aux = copy.deepcopy(bicicleta)
        bicicleta_aux.set_id(i + 2)
        bicicletasMontana.append(bicicleta_aux)
    carreraMontana = factoriaMontana.crear_carrera("Montana", bicicletasMontana)

    # Creacion de la bicicleta de carretera original
    bicicleta = factoriaCarretera.crear_bicicleta(1)
    bicicletasCarretera.append(bicicleta)

    # Inclusion del resto de bicicletas a partir de una copia de la original
    for i in range(9):
        bicicleta_aux = copy.deepcopy(bicicleta)
        bicicleta_aux.set_id(i + 2)
        bicicletasCarretera.append(bicicleta_aux)
    carreraCarretera = factoriaCarretera.crear_carrera("Carretera", bicicletasCarretera)

    # Mostrar las bicicletas y las carreras
    print(carreraMontana.tipo())
    bicicletasMontana = carreraMontana.get_bicicletas()
    for bicicleta in bicicletasMontana:
        print(str(bicicleta.get_id()) + " " + bicicleta.tipo())

    print("\n" + carreraCarretera.tipo())
    bicicletasCarretera = carreraCarretera.get_bicicletas()
    for bicicleta in bicicletasCarretera:
        print(str(bicicleta.get_id()) + " " + bicicleta.tipo())   