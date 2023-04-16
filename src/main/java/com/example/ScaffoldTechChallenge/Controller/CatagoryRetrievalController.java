package com.example.ScaffoldTechChallenge.Controller;

import com.example.ScaffoldTechChallenge.Entity.Catagories;
import com.example.ScaffoldTechChallenge.Service.CatagoryRetrievalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class CatagoryRetrievalController {

    @RequestMapping(value = "all")
    public static String findAll(Model model) throws IOException {
        model.addAttribute("catagories", CatagoryRetrievalService.findAll() );
        return "table";
    }

    @RequestMapping(value = "{device}/{brand}")
    public static String findByBrand(@PathVariable("brand") String brand,@PathVariable("device") String catagory, Model model) throws IOException {
        model.addAttribute("catagories", CatagoryRetrievalService.findByBrand(catagory, brand));
        return "table";
    }

    //TODO Finish method to allow single item to be returned for "view more" screen
//    @RequestMapping(value = "{id}")
//    public static String findByid(@PathVariable("id") int id, Model model) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        int i = 0;
//        Catagories[] all = objectMapper.readValue(new File("src/main/resources/products.json"), Catagories[].class);
//        List<Catagories> queried = new ArrayList<Catagories>();
//        while (i < all.length){
//            if (id == all[i].getId()){
//                queried.add(all[i]);
//                model.addAttribute("device", queried);
//                return "table";
//            }
//            i++;
//        }
//        return "error";
//    }
    @RequestMapping(value = "phone")
    public static String phoneCatagory(){
        return "brandPhone";
    }

    @RequestMapping(value = "tablet")
    public static String tabletCatagory(){
        return "brandTablet";
    }

    @RequestMapping(value = "")
    public static String catagories(){
        return "catagories";
    }
}
