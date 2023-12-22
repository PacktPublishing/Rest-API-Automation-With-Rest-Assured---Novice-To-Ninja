import time

from selenium import webdriver
from selenium.webdriver.edge.service import Service as Edge_Service

class RunEdgeTests():

    def test(self):
        edge_service = Edge_Service(executable_path="/Users/aniltomar/Documents/workspace_python/drivers/msedgedriver")
        # Instantiate Browser
        driver = webdriver.Edge(service=edge_service)
        # Open provided URL
        driver.get("https://www.letskodeit.com")
        time.sleep(5)


run_tests = RunEdgeTests()
run_tests.test()