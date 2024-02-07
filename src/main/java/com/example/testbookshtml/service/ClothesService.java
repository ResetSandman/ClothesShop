package com.example.testbookshtml.service;

import com.example.testbookshtml.model.Clothes;
import com.example.testbookshtml.repository.ClothesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {

    private final ClothesRepository clothesRepository;

    public ClothesService(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    public void save(Clothes c){
        clothesRepository.save(c);
    }

    public List<Clothes> getAllClothes(){
      return clothesRepository.findAll();
    }

}
