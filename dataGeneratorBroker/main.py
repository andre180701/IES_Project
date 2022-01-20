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
        t = random.randint(0,3)
        time.sleep(t)
        message = generator.generatePassage()

if __name__ == "__main__":
    main()
