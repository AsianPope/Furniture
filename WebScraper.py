import csv
import requests
from bs4 import BeautifulSoup
from urllib.request import urlopen
#from openpyxl import Image
import time

i = 0

time.sleep(5)

while True:
    i = i+1
    page_to_scrape = ("https://www.ikea.com/us/en/cat/sofas-sectionals-fu003/?itm_campaign=REVAMPHP&itm_element=5_MODULE&itm_content=POP_CAT1-SOFAS-SECT&page=" + str(i))
    page = requests.get(page_to_scrape)

    time.sleep(50)

    if page.status_code != 200:
        break
    request_page = urlopen(page_to_scrape)
    page_html = request_page.read()
    request_page.close()

    html_soup = BeautifulSoup(page_html, 'html.parser')

    furniture_item = html_soup.find_all('div', class_="pip-product-compact")

    file = open("scraped_furniture.csv", "w")
    writer = csv.writer(file)

    writer.writerow(["FURNITURE","TITLES", "DESCRIPTION", "PRICE", "lINK"])
    for furniture in furniture_item:
        title = furniture.find('span', class_="pip-header-section__title--small notranslate").text
        desc = furniture.find('span', class_="pip-header-section__description-text").text
        #rate = Image(furniture.find('span', class_="pip-ratings-bar"))
        price = furniture.find('span', class_="pip-price__integer").text
        link = furniture.find('a', 'herf', class_="pip-product-compact__wrapper-link")

        writer.writerow(["Sofa", title, desc, price, link])
file.close()