from Client import *
from Scut import *
import random

class DataGenerator:
    def __init__(self, clients, scuts):
        self.clients = clients              # list of clients
        self.scuts = scuts                  # list of scuts

    def generatePassage(self):
        client = random.choices(self.clients)[0]
        scut = random.choices(self.scuts)[0]
        print("NEW PASSAGE: matricula: ", client.get_registration(), "; scut: ", scut.get_id())