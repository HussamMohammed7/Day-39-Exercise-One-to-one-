package com.example.exercisejparelationi.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Teacher ID cannot be null")
    private Integer teacher_id;

    @NotEmpty(message = "Area cannot be empty")
    private String area;

    @NotEmpty(message = "Street cannot be empty")
    private String street;

    @NotNull(message = "Building number cannot be null")
    private Integer buildingNumber;
}
