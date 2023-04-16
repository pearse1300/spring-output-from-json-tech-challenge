package com.example.ScaffoldTechChallenge.Service;

import com.example.ScaffoldTechChallenge.Entity.Catagories;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CatagoryRetrievalService {

    public static Catagories[] findAll() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catagories[] all = objectMapper.readValue(new File("src/main/resources/products.json"), Catagories[].class);
        return all;
    }

    public static List<Catagories> findByBrand(String catagory, String brand) throws IOException{
        int i = 0;
        Catagories[] all = findAll();
        List<Catagories> queried = new ArrayList<Catagories>();
        while (i < all.length){
            if (brand.toLowerCase(Locale.ROOT).equals(all[i].getBrand().toLowerCase(Locale.ROOT))
                    && (catagory.toLowerCase(Locale.ROOT).equals(all[i].getCatagory().toLowerCase(Locale.ROOT)))){
                queried.add(all[i]);
            }
            i++;
        }
        return queried;
    }

    public static Catagories findById(int id) throws IOException {
        int i = 0;
        Catagories[] catagories = findAll();
        while (i < catagories.length){
            if (id == catagories[i].getId()){
                return catagories[i];
            }
            i++;
        }
        return null;
    }
}
