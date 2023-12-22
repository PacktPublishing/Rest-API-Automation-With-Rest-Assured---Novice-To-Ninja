from selenium import webdriver
from pages.home.login_page import LoginPage
import unittest
import pytest

class LoginTests(unittest.TestCase):

    def test_validLogin(self):
        baseURL = "https://letskodeit.teachable.com/"
        driver = webdriver.Firefox()
        driver.maximize_window()
        driver.implicitly_wait(3)
        driver.get(baseURL)

        lp = LoginPage(driver)
        lp.login("test@email.com", "abcabc")
        result = lp.verifyLoginSuccessful()
        assert result == True
        driver.quit()
