package com.repair.web.Controller.AE;

import com.repair.web.Service.AE.TakeListAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TakeListAEController {
    private final TakeListAEService takeListAEService;

    public TakeListAEController(TakeListAEService takeListAEService){
        this.takeListAEService=takeListAEService;
    }

    @RequestMapping(value = "/TakeList",method = RequestMethod.POST)
    public ModelAndView takeList(String company){
        Map<String, List>map=new HashMap<>();
        List list=new ArrayList();
        list.add(0,company);
        map.put("company",list);
        map.put("takeList",takeListAEService.getTakeList(company));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("TakeList");
        modelAndView.addObject(map);
        return modelAndView;
    }
}
