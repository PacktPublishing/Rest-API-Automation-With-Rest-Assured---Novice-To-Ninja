from selenium import webdriver
from selenium.webdriver.common.by import By
from pynput.keyboard import Key, Controller
import time

driver = webdriver.Firefox()
driver.implicitly_wait(10)
driver.get("https://www.plupload.com/examples/")
driver.find_element(By.ID, "uploader_browse").click()
time.sleep(3)

keyboard = Controller()

keyboard.type("C:\\Users\\aniltomar\\PycharmProjects\\SeleniumWDTutorial\\files\\example_file.png")
keyboard.press(Key.enter)
keyboard.release(Key.enter)