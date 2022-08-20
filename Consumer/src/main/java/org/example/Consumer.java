package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FoodOrderService foodOrderService;

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("-------> message consumed: {}", message);

        FoodOrderDTO foodOrderDTO = objectMapper.readValue(message, FoodOrderDTO.class);
        foodOrderService.persistFoodOrder(foodOrderDTO);
    }

}
