package com.repair.web.Controller.AE;/*
    Author:Yin
*/

import com.repair.web.Service.AE.CopyrightAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CopyrightAEController {
    private final CopyrightAEService copyrightAEService;

    public CopyrightAEController(CopyrightAEService copyrightAEService){
        this.copyrightAEService=copyrightAEService;
    }

    @RequestMapping(value = "/BaseCopyright",method = RequestMethod.POST)
    public ModelAndView copyrightsPage(String company){
        ModelAndView modelAndView=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        modelAndView.setViewName("BaseCopyright");
        map.put("copyrightList",copyrightAEService.getAllCopyright(company));
        map.put("company",company);
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @RequestMapping(value = "/DelCopyright",method = RequestMethod.POST)
    public ModelAndView delCopyrightFunction(String copyright_id,String company){

        ModelAndView modelAndView=new ModelAndView();
        Map<String,Object> map=new HashMap<>();
        if(!copyrightAEService.delCopyright(copyright_id,company)){
            modelAndView.setViewName("Error");
        }
        modelAndView.setViewName("BaseCopyright");
        map.put("copyrightList",copyrightAEService.getAllCopyright(company));
        map.put("company",company);
        modelAndView.addAllObjects(map);

        return modelAndView;
    }
}
