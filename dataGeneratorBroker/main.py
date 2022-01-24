import random
import pika
import json
import time
import mysql.connector
from datetime import datetime
import time

conn =  mysql.connector.connect(username="admin", password="admin",host='dataBase', db="fastTravelDB")
cursor = conn.cursor()


class DataGenerator:
    def __init__(self):
        self.credentials = pika.PlainCredentials('user1','user1')
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host= 'messageBroker', port = '5672', credentials= self.credentials))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='portinhas', durable=True)
        self.nextUpdatesIdentifiers = []

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
    
    def updateIdentifiers(self):
        for newUpdate in self.nextUpdatesIdentifiers:
            if time.time() >= newUpdate[2]:
                message = {'method': 'UPDATE_IDENTIFIER', 'id_identifier': newUpdate[0], 'new_state': newUpdate[1]}
                self.send('portinhas', message)
                self.nextUpdatesIdentifiers.remove(newUpdate)
        
    def checkNextUpdatesIdentifiers(self):
        print("AnTES DO SELECT IDENTIFIERCLEAR")
        cursor.execute("select * from identifier;")
        for i in cursor.fetchall():
            print(i)
            if i[3] == 0:
                self.nextUpdatesIdentifiers.append((i[0], 1, time.time() + 180))
        
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
    while True:
        generator.updateIdentifiers()
        generator.checkNextUpdatesIdentifiers()
        t = random.randint(0,3)
        time.sleep(t)
        message = generator.generatePassage()

if __name__ == "__main__":
    main()
