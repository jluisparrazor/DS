from bs4 import BeautifulSoup
from scrape_strategy import ScrapeStrategy
import requests

class BeautifulSoupStrategy(ScrapeStrategy):
    def __init__(self):
        super().__init__()
        self.soup = None

    def scrape(self, url):
        response = requests.get(url)
        if response.status_code == 200:
            self.soup = BeautifulSoup(response.content, 'html.parser')
        else:
            return f'No se pudo recuperar la página web, status code: {response.status_code}'
    
    def find(self, elemento, atributo, valor):
        variable = self.soup.find(elemento, {atributo: valor})
        if variable:
            return variable.text.strip()
        else:
            return 'Valor no encontrado'