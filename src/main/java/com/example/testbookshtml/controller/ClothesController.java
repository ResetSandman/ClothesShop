package com.example.testbookshtml.controller;

import com.example.testbookshtml.model.Clothes;
import com.example.testbookshtml.model.MyClothesList;
import com.example.testbookshtml.service.ClothesService;
import com.example.testbookshtml.service.MyClothesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClothesController {

    private final ClothesService clothesService;

    private final MyClothesListService myClothesListService;


    public ClothesController(ClothesService clothesService, MyClothesListService myClothesListService) {
        this.clothesService = clothesService;
        this.myClothesListService = myClothesListService;
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
    public String getMyClothes(Model model){
        List<MyClothesList> all = myClothesListService.getAllMyClothes();
        model.addAttribute("myClothesList", all);
        return "myClothes";
    }


    @PostMapping("/save")
    public String addClothes(@ModelAttribute Clothes c){
        clothesService.save(c);
        return "redirect:/available_clothes";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") Long id){
        Clothes c = clothesService.getClothesByID(id);
        MyClothesList mc = new MyClothesList(c.getId(),c.getType(),c.getBrand(),c.getSize(),c.getSellPrice(),c.getShopPrice());
        myClothesListService.saveMyClothes(mc);
        return "redirect:/my_clothes";
    }




}
