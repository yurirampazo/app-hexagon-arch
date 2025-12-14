package com.test.hexagonal.config;

import com.test.hexagonal.adapters.in.consumer.message.CustomerMessage;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;

import static org.apache.kafka.clients.CommonClientConfigs.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConsumerConfig {

  @Bean
  public ConsumerFactory<String, CustomerMessage> consumerFactory() {
    var configProps = new HashMap<String, Object>();
    configProps.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProps.put(GROUP_ID_CONFIG, "testing");
    configProps.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(AUTO_OFFSET_RESET_CONFIG, "earliest");
    return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> kafkaListenerContainerFactory(){
    var factory = new ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }
}
