package com.lawal.ecommerce.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class kafkaOrderTopicConfig {

    @Bean
    public NewTopic orderTopic(){
        return TopicBuilder
                .name("order-topic")
                .build();
    }


}
