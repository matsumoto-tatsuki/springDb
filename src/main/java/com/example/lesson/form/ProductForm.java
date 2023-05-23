package com.example.lesson.form;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CodePointLength;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductForm {
    @NotBlank()
    @Length(min = 1, max = 50)
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d+")
    @Min(0)
    private String price;
}
