from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FFService

class RunFFTests():

    def test(self):
        ff_service = FFService(executable_path="/Users/aniltomar/Documents/workspace_python/drivers/geckodriver")
        # Instantiate Browser
        driver = webdriver.Firefox(service=ff_service)
        # Open provided URL
        driver.get("https://www.letskodeit.com")


run_tests = RunFFTests()
run_tests.test()