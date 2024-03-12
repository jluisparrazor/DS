from abc import ABC, abstractmethod

class Carrera(ABC):
    def __init__(self, nombre, bicicletas):
        self.bicicletas = bicicletas
        self.nombre = nombre

    @abstractmethod
    def tipo(self):
        pass

    def get_bicicletas(self):
        return self.bicicletas
