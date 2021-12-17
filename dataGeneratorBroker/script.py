from dataGeneratorBroker.main import *
from Client import *
from Scut import *
import random
import time
import pika
import json

def __init__(self):
    self.credentials = pika.PlainCredentials('user1','user1')
    self.connection = pika.BlockingConnection(pika.ConnectionParameters(host= 'localhost', port = '5672', credentials= credentials))
    self.channel = self.connection.channel()
    self.channel.queue_declare(queue='portinhas')

def send(self, topic=None, message=None):
    try:
        message = json.dumps(message)
        self.channel.basic_publish(exchange='', routing_key='portinhas', body='Hello World!')
        #self.channel.basic_publish(exchange='', routing_key=topic, body=message)
        print(" [x] Sent 'MESSAGE!'")
    except:
        print("ERROR: Message to broker was not sent")

def main():


    clients = [Client('AA-00-01', 1000), Client('BB-21-09', 1001), Client('EB-98-11', 1002)]
    scuts = [ Scut(29.8999, 87.9000, 1.23, 1.30, 2.00, 3.90, 2.99), Scut(39.6778, 10.8822, 1.27, 1.45, 2.08, 3.87, 3.02)]


    generator = DataGenerator(clients, scuts)

    while True:
        t = random.randint(0,3)
        time.sleep(t)
        message = generator.generatePassage()
        self.send("portinhas", message)


if __name__ == "__main__":
    main()
