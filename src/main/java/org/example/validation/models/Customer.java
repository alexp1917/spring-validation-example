package org.example.validation.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
public class Customer {

    @NotNull
    private UUID id;

    private int age;

    private String phone;

}
