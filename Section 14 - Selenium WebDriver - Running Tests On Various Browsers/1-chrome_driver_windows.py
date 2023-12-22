from selenium import webdriver
from selenium.webdriver.chrome.service import Service as Service

class RunChromeTests():

    def test(self):
        chrome_service = Service(executable_path="Complete path to chromedriver.exe")
        # Instantiate Browser
        driver = webdriver.Chrome(service=chrome_service)
        # Open the provided URL
        driver.get("https://www.letskodeit.com")

runtests = RunChromeTests()
runtests.test()