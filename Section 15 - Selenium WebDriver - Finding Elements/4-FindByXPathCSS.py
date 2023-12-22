from selenium import webdriver
from selenium.webdriver.common.by import By

class FindByXPathCSS():
    def test(self):
        baseURL = "https://courses.letskodeit.com/practice"
        driver = webdriver.Chrome()
        driver.get(baseURL)
        driver.implicitly_wait(10)

        elementByXPath = driver.find_element(By.XPATH, "//input[@id='displayed-text']")
        if elementByXPath is not None:
            print("Element Found -> By XPath")

        elementByCSS = driver.find_element(By.CSS_SELECTOR, "#displayed-text")
        if elementByCSS is not None:
            print("Element Found -> By CSS")

run_tests = FindByXPathCSS()
run_tests.test()