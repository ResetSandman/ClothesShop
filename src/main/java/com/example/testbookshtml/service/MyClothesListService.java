package com.example.testbookshtml.service;

import com.example.testbookshtml.model.MyClothesList;
import com.example.testbookshtml.repository.MyClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MyClothesListService {

    private final MyClothesRepository clothesRepository;

    public MyClothesListService(MyClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    public void saveMyClothes(MyClothesList clothes){
        clothesRepository.save(clothes);
    }

    public List<MyClothesList> getAllMyClothes(){
        return clothesRepository.findAll();
    }


}
