from Carrera import Carrera

class CarreraMontana(Carrera):
    def __init__(self, nombre, bicicletas):
        super().__init__(nombre, bicicletas)

    def tipo(self):
        return "Carrera de montana"