from selenium import webdriver
from selenium.webdriver.edge.service import Service as Service

class RunEdgeTests():

    def test(self):
        edgeservice = Service(executable_path="Complete path to msedgedriver.exe")
        # Instantiate Browser
        driver = webdriver.Edge(service=edgeservice)
        # Open the provided URL
        driver.get("https://www.letskodeit.com")

runtests = RunEdgeTests()
runtests.test()