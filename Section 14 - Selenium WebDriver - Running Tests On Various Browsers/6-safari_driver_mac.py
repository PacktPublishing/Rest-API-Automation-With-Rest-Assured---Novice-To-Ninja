from selenium import webdriver

class SafariDriverMac():

    def test(self):
        # Instantiate Safari Browser Command
        driver = webdriver.Safari()
        # Open the provided URL
        driver.get("http://www.letskodeit.com")

sf = SafariDriverMac()
sf.test()