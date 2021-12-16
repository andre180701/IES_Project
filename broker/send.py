#!/usr/bin/env python
import pika


credentials =pika.PlainCredentials('user1','user1')
parameters = pika.ConnectionParameters(host= 'localhost', port = 5672, credentials= credentials)
connection = pika.BlockingConnection(parameters)
channel = connection.channel()


# to make sure the recipient queue exists. If we send a message to non-existing location
channel.queue_declare(queue='hello')

channel.basic_publish(exchange='', routing_key='hello', body='Hello World!')
print(" [x] Sent 'Hello World!'")
connection.close()