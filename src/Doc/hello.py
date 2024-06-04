import time
import random
import pyautogui

pyautogui.FAILSAFE = False

while 1:
    time.sleep(60)
    pyautogui.moveTo(x=1500, y=random.randint(100, 900))
    pyautogui.rightClick()
    pyautogui.rightClick()