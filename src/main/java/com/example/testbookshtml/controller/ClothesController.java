package com.example.testbookshtml.controller;

import com.example.testbookshtml.model.Clothes;
import com.example.testbookshtml.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClothesController {

    private final ClothesService clothesService;

    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/clothes_register")
    public String bookRegister(){
        return "clothesRegister";
    }
    @GetMapping("/available_clothes")
    public ModelAndView getAllClothes(){
        List<Clothes> list = clothesService.getAllClothes();
        ModelAndView object = new ModelAndView();
        object.setViewName("availableClothes");
        object.addObject("clothes", list);
        return new ModelAndView("availableClothes","clothes", list);
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
