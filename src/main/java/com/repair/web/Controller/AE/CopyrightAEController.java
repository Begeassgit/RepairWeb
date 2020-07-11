package com.repair.web.Controller.AE;/*
    Author:Yin
*/

import com.repair.web.Service.AE.CopyrightAEService;
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

    @RequestMapping(value = "/OutputCopyright",method = RequestMethod.POST)
    public void outputSheet(HttpServletResponse response, String company){
        XSSFWorkbook xssfWorkbook=copyrightAEService.outputSheet(company);
        String fileName="土地使用权及软件.xlsx";
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

    @RequestMapping(value = "/OutputCopyrightTemplate",method = RequestMethod.GET)
    public void outputSheetTemplate(HttpServletResponse response){
        XSSFWorkbook xssfWorkbook=copyrightAEService.outputSheetTemplate();
        String fileName="土地使用权及软件模板.xlsx";
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
}
