import random
import pika
import json
import time
from datetime import datetime

class DataGenerator:
    def __init__(self):
        self.credentials = pika.PlainCredentials('user1','user1')
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host= 'localhost', port = '5672', credentials= self.credentials))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='portinhas', durable=True)

    def generatePassage(self):
        message = {'method': 'NEW_PASSAGE', 'identifier': random.randint(1, 2), 'scut': random.randint(1, 3), 'date': datetime.now().strftime("%Y-%m-%d"), 'time': datetime.now().strftime("%H:%M:%S")}
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
