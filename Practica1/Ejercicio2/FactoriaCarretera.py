from FactoriaCarreraYBicicleta import FactoriaCarreraYBicicleta
from CarreraCarretera import CarreraCarretera
from BicicletaCarretera import BicicletaCarretera

class FactoriaCarretera(FactoriaCarreraYBicicleta):
    def crear_carrera(self, nombre, bicicletas):
        carrera_de_carretera = CarreraCarretera(nombre, bicicletas)
        return carrera_de_carretera
    
    def crear_bicicleta(self, id):
        bicicleta_de_carretera = BicicletaCarretera(id)
        return bicicleta_de_carretera