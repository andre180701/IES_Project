from DataGenerator import *
from Client import *
from Scut import *
import random
import time

def main():

    clients = [Client('AA-00-01', 1000), Client('BB-21-09', 1001), Client('EB-98-11', 1002)]
    scuts = [ Scut(29.8999, 87.9000, 1.23, 1.30, 2.00, 3.90, 2.99), Scut(39.6778, 10.8822, 1.27, 1.45, 2.08, 3.87, 3.02)]


    generator = DataGenerator(clients, scuts)

    while True:
        t = random.randint(0,3)
        time.sleep(t)
        generator.generatePassage()

if __name__ == "__main__":
    main()