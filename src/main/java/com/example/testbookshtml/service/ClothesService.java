package com.example.testbookshtml.service;

import com.example.testbookshtml.model.Clothes;
import com.example.testbookshtml.repository.ClothesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class ClothesService {

    private  ClothesRepository clothesRepository;

    public ClothesService(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    public void save(Clothes c){
        clothesRepository.save(c);
    }

}
