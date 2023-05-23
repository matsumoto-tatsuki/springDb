package com.example.lesson.form;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CodePointLength;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductForm {
    @NotBlank(message = "必須入力項目")
    @Length(min = 1, max = 50)
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d+")
    @Range(min=0)
    private String price;
}
