package com.repair.web.Controller.AE;/*
    Author:Yin
*/

import com.repair.web.Service.AE.TeachToolAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TeachToolAEController {
    private final TeachToolAEService teachToolAEService;

    public TeachToolAEController(TeachToolAEService teachToolAEService){
        this.teachToolAEService=teachToolAEService;
    }

    @RequestMapping(value = "/BaseTeachTool",method = RequestMethod.POST)
    public ModelAndView teachToolPage(String company){
        Map<String,Object>map =new HashMap<>();
        map.put("teachTool",teachToolAEService.getAllTeachTool(company));
        map.put("company",company);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("BaseTeachTool");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelTeachTool",method = RequestMethod.POST)
    public ModelAndView delteachToolFunction(String teach_tool_id,String company){
        ModelAndView modelAndView=new ModelAndView();
        Map<String,Object>map =new HashMap<>();
        if(!teachToolAEService.delTeachToolService(teach_tool_id, company)){
            modelAndView.setViewName("Error");
        }
        map.put("teachTool",teachToolAEService.getAllTeachTool(company));
        map.put("company",company);
        modelAndView.setViewName("BaseTeachTool");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
