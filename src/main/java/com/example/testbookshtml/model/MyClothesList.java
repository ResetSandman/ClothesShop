package com.example.testbookshtml.model;

import com.example.testbookshtml.enums.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "myClothes")
public class MyClothesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String type;
    private String brand;
    @Enumerated(EnumType.STRING)
    private Size size;
    private double sellPrice;
    private double shopPrice;
}
