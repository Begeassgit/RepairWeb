package com.repair.web.Controller.AE;/*
    Author:Yin
*/

import com.repair.web.Service.AE.FurnitureAEService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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

    @RequestMapping(value = "/OutputFurniture",method = RequestMethod.POST)
    public void outputFurniture(HttpServletResponse response,String company){
        XSSFWorkbook xssfWorkbook=furnitureAEService.outputFurnitureSheet(company);
        OutputStream outputStream;
        String fileName="交通载具.xlsx";
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

    @RequestMapping(value = "/OutputFurnitureTemplate",method = RequestMethod.GET)
    public void outputFurniture(HttpServletResponse response){
        XSSFWorkbook xssfWorkbook=furnitureAEService.outputFurnitureSheetTemplate();
        OutputStream outputStream;
        String fileName="交通载具模板.xlsx";
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
}
