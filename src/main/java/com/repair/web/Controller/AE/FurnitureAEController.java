package com.repair.web.Controller.AE;/*
    Author:Yin
*/

import com.repair.web.Service.AE.FurnitureAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FurnitureAEController {
    private final FurnitureAEService furnitureAEService;

    public FurnitureAEController(FurnitureAEService furnitureAEService){
        this.furnitureAEService=furnitureAEService;
    }

    @RequestMapping(value = "/BaseFurniture",method = RequestMethod.POST)
    public ModelAndView furniturePage(String company){
        ModelAndView modelAndView=new ModelAndView();
        Map<String,Object>map=new HashMap<>();
        map.put("furnitureList",furnitureAEService.getAllFurniture(company));
        map.put("company",company);
        modelAndView.setViewName("BaseFurniture");
        modelAndView.addAllObjects(map);

        return modelAndView;
    }
}
