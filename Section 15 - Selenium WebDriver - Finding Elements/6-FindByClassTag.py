import time

from selenium import webdriver
from selenium.webdriver.common.by import By

class FindByClassTag():

    def test(self):
        baseURL = "https://courses.letskodeit.com/practice"
        driver = webdriver.Chrome()
        driver.get(baseURL)
        driver.implicitly_wait(10)

        elementByClassName = driver.find_element(By.CLASS_NAME, "inputs")

        if elementByClassName is not None:
            print("Element Found -> By Class Name")
            elementByClassName.send_keys("Testing")

        elementByTagName = driver.find_element(By.TAG_NAME, "a")

        if elementByTagName is not None:
            print("Element Found -> By Tag Name: " + elementByTagName.text)

        time.sleep(5)


run_tests = FindByClassTag()
run_tests.test()