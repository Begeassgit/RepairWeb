package com.repair.web.Controller.FE;

import com.repair.web.Service.FE.QrCodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QrCodeController {
    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService){
        this.qrCodeService=qrCodeService;
    }
    @RequestMapping(value = "/outPutQrCode",method = RequestMethod.POST)
    public void qrCode(){

    }
}
