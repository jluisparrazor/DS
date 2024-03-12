from abc import ABC, abstractmethod

class FactoriaCarreraYBicicleta(ABC):
    @abstractmethod
    def crear_carrera(self, nombre, bicicletas):
        pass

    @abstractmethod
    def crear_bicicleta(self, id):
        pass