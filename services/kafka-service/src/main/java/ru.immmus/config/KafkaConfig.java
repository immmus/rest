package ru.immmus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.immmus.profiles.NotEmbeddedKafka;

@Configuration
@NotEmbeddedKafka
@PropertySource("classpath:kafka.properties")
public class KafkaConfig implements KafkaConfiguration {

    @Value("${kafka.topic}")
    private String topic;

    @Value("${kafka.address}")
    private String brokerAddress;

    @Value("${zookeeper.address}")
    private String zookeeperAddress;

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String getBrokerAddress() {
        return brokerAddress;
    }

    @Override
    public String getZookeeperAddress() {
        return zookeeperAddress;
    }
}
