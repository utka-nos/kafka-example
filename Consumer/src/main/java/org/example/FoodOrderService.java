package org.example;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FoodOrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FoodOrderRepo foodOrderRepo;

    public void persistFoodOrder(FoodOrderDTO foodOrderDTO){

        FoodOrder fOrder = modelMapper.map(foodOrderDTO, FoodOrder.class);
        FoodOrder save = foodOrderRepo.save(fOrder);

        log.info("-------> food order persisted : {}", save);
    }
}
