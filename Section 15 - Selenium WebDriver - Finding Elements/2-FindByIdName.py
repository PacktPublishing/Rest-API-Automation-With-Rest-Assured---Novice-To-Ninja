from selenium import webdriver
from selenium.webdriver.common.by import By

class FindByIdName():
    def test(self):
        baseURL = "https://courses.letskodeit.com/practice"
        driver = webdriver.Chrome()
        driver.get(baseURL)
        driver.implicitly_wait(10)

        elementById = driver.find_element(By.ID, "displayed-text")
        if elementById is not None:
            print("Element Found -> By Id")

        elementByName = driver.find_element(By.NAME, "show-hide")
        if elementByName is not None:
            print("Element Found -> By Name")

run_tests = FindByIdName()
run_tests.test()