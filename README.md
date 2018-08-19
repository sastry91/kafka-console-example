# kafka-console-example
Use below commands for starting kafka broker and  creating topics 

Zookeeper launch -- 
./bin/windows/zookeeper-server-start.bat ./config/zookeeper.properties

Kafka Broker launch  --
./bin/windows/kafka-server-start.bat ./config/server.properties

Create Topic test
Create a topic: ./bin/windows/kafka-topics.bat --
create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

Start a console consumer for that topic --
./bin/windows/kafka-console-consumer.bat --zookeeper localhost:2181 --topic test --from-beginning

Start a console producer for that topic --
./bin/windows/kafka-console-producer.bat --broker-list localhost:9092 --topic test
