from scrape_strategy import ScrapeStrategy
import json
from beautifulsoup import BeautifulSoupStrategy
from selenium_strategy import SeleniumStrategy
from context import Context


if __name__ == "__main__":
    url = 'https://finance.yahoo.com/quote/TSLA'

    estrategia = 0
    while (estrategia != 1 and estrategia != 2):
        print("1. BeautifulSoup")
        print("2. Selenium")
        estrategia = int(input("\nSeleccione una estrategia: "))

    if (estrategia == 1):
        context = Context(BeautifulSoupStrategy())
    else:
        context = Context(SeleniumStrategy())

    scrape = context.scrape(url)
    fich = "informacion.json"

    close_value = context._strategy.find('td', 'data-test', 'PREV_CLOSE-value')
    print('Close Value:', close_value)
    
    open_value = context._strategy.find('td', 'data-test', 'OPEN-value')
    print('Open Value:', open_value)

    volume_value = context._strategy.find('td', 'data-test', 'TD_VOLUME-value')
    print('Volume Value:', volume_value)
   
    market_cap_value = context._strategy.find('td', 'data-test', 'MARKET_CAP-value')
    print('Market Cap Value:', market_cap_value)
    
    data = {
        'Close Value': close_value,
        'Open Value': open_value,
        'Volume Value': volume_value,
        'Market Cap Value': market_cap_value
    }
    
    with open(fich, "w") as f:
        json.dump(data, f, indent=4)
   
    print("Informacion scrapeada de forma correcta y guardada en", fich)

