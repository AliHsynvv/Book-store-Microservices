package com.bookstore.inventoryservice;

import com.bookstore.inventoryservice.model.Inventory;
import com.bookstore.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("book");
            inventory.setQuantity(11);

            Inventory inventory2 = new Inventory();
            inventory.setSkuCode("book2");
            inventory.setQuantity(12);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory2);
        };
    }
}
