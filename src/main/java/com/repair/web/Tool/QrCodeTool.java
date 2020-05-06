package com.repair.web.Tool;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

public class QrCodeTool {
    public static final String FORMAT = "JPG";
    private static final int QrCODE_SIZE = 300;

    public boolean creat(OutputStream outputStream,String info) throws WriterException, IOException{
        Hashtable<EncodeHintType,ErrorCorrectionLevel> hashtable=new Hashtable<>();
        hashtable.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.H);
        QRCodeWriter qrCodeWriter=new QRCodeWriter();
        BitMatrix bitMatrix=qrCodeWriter.encode(info,BarcodeFormat.QR_CODE,QrCODE_SIZE,QrCODE_SIZE,hashtable);
        int matrixWidth=bitMatrix.getWidth();
        int revise=matrixWidth*2/9;
        BufferedImage image=new BufferedImage(matrixWidth-revise,matrixWidth-revise,BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics2D=(Graphics2D)image.getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,matrixWidth,matrixWidth);
        graphics2D.setColor(Color.BLACK);
        for(int i=0;i<matrixWidth;i++){
            for(int j=0;j<matrixWidth;j++){
                if(bitMatrix.get(i,j)){
                    graphics2D.fillRect(i-revise/2,j-revise/2,1,1);
                }
            }
        }
        return ImageIO.write(image,FORMAT,outputStream);
    }
}
