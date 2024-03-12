from abc import ABC, abstractmethod

class Bicicleta(ABC):
    def __init__(self, id):
        self.id = id

    @abstractmethod
    def tipo(self):
        pass
    
    def set_id(self, id):
        self.id = id

    def get_id(self):
        return self.id