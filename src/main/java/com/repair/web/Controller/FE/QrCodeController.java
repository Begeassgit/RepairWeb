package com.repair.web.Controller.FE;

import com.google.zxing.WriterException;
import com.repair.web.Service.FE.QrCodeService;
import com.repair.web.Tool.QrCodeTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URLEncoder;


@Controller
public class QrCodeController {
    private final QrCodeService qrCodeService;
    public static final String FORMAT = "JPG";

    public QrCodeController(QrCodeService qrCodeService){
        this.qrCodeService=qrCodeService;
    }
    @RequestMapping(value = "/OutputQrCode",method = RequestMethod.POST)
    public void outPutQrCode(HttpServletResponse response,String device_id){
        String name="code.jpeg";
        OutputStream outputStream=null;
        try{
            name= URLEncoder.encode(name,"UTF-8");
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition","attachment;filename="+name);
            QrCodeTool qrCodeTool=new QrCodeTool();
            outputStream=response.getOutputStream();
            ImageIO.write((RenderedImage) qrCodeTool.creat(device_id),FORMAT,outputStream);
            outputStream.flush();
            outputStream.close();
        }catch (IOException | WriterException e){
            e.printStackTrace();
        }

    }
}
