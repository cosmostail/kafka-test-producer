## list topic
```
docker exec -it broker kafka-topics --list --zookeeper zookeeper:2181
```

## create a topic
```
docker exec -it broker kafka-topics --create --topic scott-test --bootstrap-server localhost:9092
```

## read topic
``` 
docker exec -it broker kafka-console-consumer --topic scott-test --from-beginning --bootstrap-server localhost:9092
```

## Avro
``` 
java -jar ~/code/avro/avro-tools-1.10.1.jar compile schema app/src/main/resources/avro/KafkaTest/Person.avsc app/src/main/java/
```

## run
``` 
./gradlew run
```