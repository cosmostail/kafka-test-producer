/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package KafkaTest;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class App {
    public String getGreeting() {
        return "Hello World 2!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", KafkaAvroSerializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        Producer<String, Person> producer = new KafkaProducer<String, Person>(props);
        Person kenny = new Person(12345, "Kenny", "Armstrong", "kenny@example.com");
        producer.send(new ProducerRecord<String, Person>("person-test", String.valueOf(kenny.getId()), kenny));

        producer.close();
    }
}
