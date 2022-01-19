import random
import pika
import json
import time
import mysql.connector
from datetime import datetime

conn =  mysql.connector.connect(username="admin", password="admin",host='dataBase', db="fastTravelDB")
cursor = conn.cursor()


class DataGenerator:
    def __init__(self):
        self.credentials = pika.PlainCredentials('user1','user1')
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host= 'messageBroker', port = '5672', credentials= self.credentials))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='portinhas', durable=True)

    def generatePassage(self):

        identifier_ids = []
        scut_ids = []
        cursor.execute("select identifier_id from identifier;")
        for i in cursor.fetchall():
            identifier_ids.append(i)
        cursor.execute("select scut_id from scut;")
        for i in cursor.fetchall():
            scut_ids.append(i)
        if identifier_ids != [] and scut_ids != []:
            message = {'method': 'NEW_PASSAGE', 'identifier': random.choice(identifier_ids)[0], 'scut': random.choice(scut_ids)[0], 'date': datetime.now().strftime("%Y-%m-%d"), 'time': datetime.now().strftime("%H:%M:%S")}
            self.send('portinhas', message)
    
    def generteIdentifier(self):
        clients = []
        credit_cards = []
        identifiers_reg = []
        cursor.execute("select client_id from client;")
        for i in cursor.fetchall():
            clients.append(i)
        cursor.execute("select credit_card_id from credit_card;")
        for i in cursor.fetchall():
            credit_cards.append(i)
        cursor.execute("select registration from identifier;")
        for i in cursor.fetchall():
            for c in i:
                if c != "":
                    identifiers_reg.append(c)
        if clients != [] and credit_cards != []:
            message = {'method': 'NEW_IDENTIFIER', 'registration': "AA-BB-18", 'classe': random.randint(1, 5), 'client': random.choice(clients)[0], 'credit_card': random.choice(credit_cards)[0]}
            message2 = {'method': 'NEW_IDENTIFIER', 'registration': "CC-18-VV", 'classe': random.randint(1, 5), 'client': random.choice(clients)[0], 'credit_card': random.choice(credit_cards)[0]}
            if "AA-BB-18" not in identifiers_reg:
                self.send('portinhas', message)
            
            if "CC-18-VV" not in identifiers_reg:
                self.send('portinhas', message2)
        
        
    def send(self, topic=None, message=None):
        try:
            message = json.dumps(message)
            self.channel.basic_publish(exchange='', routing_key=topic, body=message)
            print(message)
            print(" [x] Sent 'MESSAGE!'")
        except:
            print("ERROR: Message to broker was not sent")  
                

def main():
    generator = DataGenerator()
    message = generator.generteIdentifier()
    while True:
        t = random.randint(0,3)
        time.sleep(t)
        message = generator.generatePassage()
        


if __name__ == "__main__":
    main()
