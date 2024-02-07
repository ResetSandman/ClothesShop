package com.example.testbookshtml.controller;

import com.example.testbookshtml.model.Clothes;
import com.example.testbookshtml.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/clothes_register")
    public String bookRegister(){
        return "clothesRegister";
    }
    @GetMapping("/available_clothes")
    public String getAllClothes(){
        return "availableClothes";
    }

    @GetMapping("/my_clothes")
    public String myClothes(){
        return "myClothes";
    }


    @PostMapping("/save")
    public String addClothes(@ModelAttribute Clothes c){
        clothesService.save(c);
        return "redirect:/available_clothes";
    }


}
