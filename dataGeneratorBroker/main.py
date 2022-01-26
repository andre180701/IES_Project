import random
import pika
import json
import time
import mysql.connector
from datetime import datetime
import time


class DataGenerator:
    def __init__(self):
        self.credentials = pika.PlainCredentials('user1','user1')
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host= 'messageBroker', port = '5672', credentials= self.credentials))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='portinhas', durable=True)
        self.nextUpdatesIdentifiers = []
        self.nextUpdatesPassages = []
        self.identifiersAnalyzed = [] 
        self.passagesAnalyzed = [] 

    def generatePassage(self, cursor):

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
        
    def checkNextUpdatesIdentifiers(self, cursor):
        cursor.execute("select * from identifier;")
        for i in cursor.fetchall():
            if i[3] == 0 and i[0] not in self.identifiersAnalyzed:
                self.nextUpdatesIdentifiers.append((i[0], 1, time.time() + 45))
                self.nextUpdatesIdentifiers.append((i[0], 3, time.time() + 45 + 45))
                self.nextUpdatesIdentifiers.append((i[0], 4, time.time() + 45 + 45 + 45))
                self.nextUpdatesIdentifiers.append((i[0], 5, time.time() + 45 + 45 + 45 + 45))
                self.identifiersAnalyzed.append(i[0])

    def checkNextUpdatesPassages(self, cursor):
        cursor.execute("select * from passage;")
        for i in cursor.fetchall():
            if i[2] == 0 and i[0] not in self.passagesAnalyzed:
                self.nextUpdatesPassages.append((i[0], 1, time.time() + 45))
                self.passagesAnalyzed.append(i[0])

    def updatePassages(self):
        for newUpdate in self.nextUpdatesPassages:
            if time.time() >= newUpdate[2]:
                message = {'method': 'UPDATE_PASSAGE', 'id_passage': newUpdate[0], 'new_state': newUpdate[1]}
                self.send('portinhas', message)
                self.nextUpdatesPassages.remove(newUpdate)

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
        conn =  mysql.connector.connect(username="admin", password="admin",host='dataBase', db="fastTravelDB")
        cursor = conn.cursor()
        generator.updateIdentifiers()
        generator.updatePassages()
        generator.checkNextUpdatesIdentifiers(cursor)
        generator.checkNextUpdatesPassages(cursor)
        t = random.randint(0,3)
        time.sleep(t)
        message = generator.generatePassage(cursor)

if __name__ == "__main__":
    main()
