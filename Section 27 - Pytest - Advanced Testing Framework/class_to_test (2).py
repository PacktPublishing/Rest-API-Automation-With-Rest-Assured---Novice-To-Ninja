"""
How to use test class to wrap methods under one class
Learn about autouse keywords in fixtures
Assert the result to create a real test scenario
"""

class SomeClassToTest():

    def __init__(self, value):
        self.value = value


    def sumNumbers(self, a, b):
        return a + b + self.value