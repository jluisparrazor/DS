import json
import requests
from abc import ABC, abstractmethod
from bs4 import BeautifulSoup
from selenium_strategy import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time


class ScraperStrategy(ABC):
    @abstractmethod
    def scrape(self, stock_symbol):
        pass


class SeleniumScraper(ScraperStrategy):
    def scrape(self, stock_symbol):
        url = f"https://finance.yahoo.com/quote/{stock_symbol}"
        driver = webdriver.Chrome()  # Or use any other webdriver
        driver.get(url)
        WebDriverWait(driver, 10).until(
            EC.visibility_of_element_located((By.XPATH, "//td[@data-test='PREV_CLOSE-value']"))
        )
        time.sleep(5)  # Allow time for dynamic content to load
        data = {
            "previous_close": driver.find_element_by_xpath("//td[@data-test='PREV_CLOSE-value']").text,
            "open": driver.find_element_by_xpath("//td[@data-test='OPEN-value']").text,
            "volume": driver.find_element_by_xpath("//td[@data-test='TD_VOLUME-value']").text,
            "market_cap": driver.find_element_by_xpath("//td[@data-test='MARKET_CAP-value']").text
        }
        driver.quit()
        return data


class YahooFinanceScraper:
    def __init__(self, scraper_strategy):
        self.scraper_strategy = scraper_strategy

    def scrape_stock_info(self, stock_symbol):
        data = self.scraper_strategy.scrape(stock_symbol)
        return data

if __name__ == "__main__":
    stock_symbol = "TSLA"  # Example stock symbol (Tesla)
    output_file = "stock_info.json"

    # Strategy selection (You can change the strategy here)
    strategy = SeleniumScraper()

    scraper = YahooFinanceScraper(strategy)
    stock_info = scraper.scrape_stock_info(stock_symbol)

    # Write data to JSON file
    with open(output_file, "w") as f:
        json.dump(stock_info, f, indent=4)

    print("Data scraped successfully and saved to", output_file)

    # Print the scraped data
    print("\nScraped Stock Information:")
    for key, value in stock_info.items():
        print(f"{key}: {value}")
