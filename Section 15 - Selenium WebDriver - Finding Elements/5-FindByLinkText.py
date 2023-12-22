from selenium import webdriver
from selenium.webdriver.common.by import By

class FindByLinkText():

    def test(self):
        baseURL = "https://courses.letskodeit.com/practice"
        driver = webdriver.Chrome()
        driver.get(baseURL)
        driver.implicitly_wait(10)

        elementByLinkText = driver.find_element(By.LINK_TEXT, "HOME")

        if elementByLinkText is not None:
            print("Element Found -> By Link Text")

        elementByPartialLinkText = driver.find_element(By.PARTIAL_LINK_TEXT, "COURSES")

        if elementByPartialLinkText is not None:
            print("Element Found -> By Partial Link Text")


run_tests = FindByLinkText()
run_tests.test()
