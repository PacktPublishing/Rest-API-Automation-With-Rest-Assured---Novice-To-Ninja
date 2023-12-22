import time

from selenium import webdriver
from selenium.webdriver.chrome.service import Service as Chrome_Service

class RunChromeTests():

    def test(self):
        chrome_service = Chrome_Service(executable_path="/Users/aniltomar/Documents/workspace_python/drivers/chromedriver")
        # Instantiate Browser
        driver = webdriver.Chrome(service=chrome_service)
        # Open provided URL
        driver.get("https://www.letskodeit.com")
        time.sleep(5)


run_tests = RunChromeTests()
run_tests.test()