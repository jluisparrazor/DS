from Bicicleta import Bicicleta

class BicicletaCarretera(Bicicleta):
    def __init__(self, id):
        super().__init__(id)

    def tipo(self):
        return "Bicicleta de carretera"