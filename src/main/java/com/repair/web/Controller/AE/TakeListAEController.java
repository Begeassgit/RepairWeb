package com.repair.web.Controller.AE;

import com.repair.web.Service.AE.TakeListAEService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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
        modelAndView.setViewName("BaseTakeList");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/OutputTakeList",method = RequestMethod.POST)
    public void getFileList(HttpServletResponse response,String company){
        XSSFWorkbook xssfWorkbook=takeListAEService.sheetOutput(company);
        String fileName="领用单.xlsx";
        OutputStream outputStream;
        try{
            fileName= URLEncoder.encode(fileName,"UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition","attachment;filename="+fileName);
            outputStream=response.getOutputStream();
            xssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException eio){
            eio.printStackTrace();
        }
    }

    @RequestMapping(value ="/DelList",method = RequestMethod.POST)
    public ModelAndView delList(String list_id,String company){
        ModelAndView modelAndView=new ModelAndView();
        if(!takeListAEService.delList(list_id)){
            modelAndView.setViewName("Error");
        }
        else{
            Map<String, List>map=new HashMap<>();
            List list=new ArrayList();
            list.add(0,company);
            map.put("company",list);
            map.put("takeList",takeListAEService.getTakeList(company));

            modelAndView.setViewName("BaseTakeList");
            modelAndView.addAllObjects(map);

        }
        return modelAndView;
    }
}
