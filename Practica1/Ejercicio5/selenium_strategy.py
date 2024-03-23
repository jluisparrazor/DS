from selenium import webdriver
from selenium.webdriver.common.by import By
from scrape_strategy import ScrapeStrategy
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

class SeleniumStrategy(ScrapeStrategy):
    
    def __init__(self):
        super().__init__()
        self.selenium = None
        self.driver = None
    
    def scrape(self, url):
        self.driver = webdriver.Chrome()  
        self.driver.implicitly_wait(30)
        self.driver.get(url)
        pass

    def find(self, elemento, atributo, valor):
        WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located((By.XPATH, "//td[@data-test='PREV_CLOSE-value']"))
        )
        time.sleep(5)
        variable = self.driver.find_element_by_xpath("//" + elemento + "[@" + atributo + "='" + valor + "']")
        text = variable.text
        self.driver.quit()

        return text