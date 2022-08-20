package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Long> {
}
