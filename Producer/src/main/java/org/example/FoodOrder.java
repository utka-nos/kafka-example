package org.example;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class FoodOrder {
    String item;
    Double amount;
}
