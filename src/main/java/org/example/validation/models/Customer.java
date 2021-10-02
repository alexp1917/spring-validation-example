package org.example.validation.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;


@Data
public class Customer {

    @NotNull(message = "Customer.id must not be null")
    private UUID id;

    private int age;

    private String phone;

}
