package com.example.testbookshtml.service;

import com.example.testbookshtml.model.Clothes;
import com.example.testbookshtml.repository.ClothesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Clothes getClothesByID(@RequestBody Long id){
        return clothesRepository.findById(id).orElse(null);
    }


}
