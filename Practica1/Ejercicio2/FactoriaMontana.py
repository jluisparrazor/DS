from FactoriaCarreraYBicicleta import FactoriaCarreraYBicicleta
from CarreraMontana import CarreraMontana
from BicicletaMontana import BicicletaMontana

class FactoriaMontana(FactoriaCarreraYBicicleta):
    def crear_carrera(self, nombre, bicicletas):
        carrera_de_montana = CarreraMontana(nombre, bicicletas)
        return carrera_de_montana
    
    def crear_bicicleta(self, id):
        bicicleta_de_montana = BicicletaMontana(id)
        return bicicleta_de_montana