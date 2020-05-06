package com.repair.web.Controller.FE;

import com.repair.web.Service.FE.QrCodeService;
import com.repair.web.Tool.QrCodeTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@Controller
public class QrCodeController {
    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService){
        this.qrCodeService=qrCodeService;
    }
    @RequestMapping(value = "/outPutQrCode",method = RequestMethod.POST)
    public void outPutQrCode(HttpServletResponse response){
        String name="code.jpeg";
        OutputStream outputStream;
        try{
            name= URLEncoder.encode(name,"UTF-8");
            response.setHeader("Content-Disposition","attachment;filename="+name);
            response.setContentType("image/jpeg");
            InputStream inputStream= new FileInputStream(new File("asd"));
            outputStream=response.getOutputStream();
            outputStream.flush();
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
