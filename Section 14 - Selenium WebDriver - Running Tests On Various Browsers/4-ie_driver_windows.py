from selenium import webdriver

class IEDriverWindows():

    def test(self):
        # Instantiate IE Browser Command
        driver = webdriver.Ie(executable_path="C:\\Users\\letsk\\workspace_python\\drivers\\IEDriverServer.exe")
        # Open the provided URL
        driver.get("http://www.letskodeit.com")

ieObject = IEDriverWindows()
ieObject.test()