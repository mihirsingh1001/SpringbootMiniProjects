package com.springboot.qrgeneration.controller;

import java.io.IOException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.google.zxing.WriterException;
import com.springboot.qrgeneration.service.QrCodeService;

@Controller
@RequestMapping("/generate")
public class QrCodeWebController {

    @Autowired
    private QrCodeService codeService;

    Logger logger = LoggerFactory.getLogger(QrCodeWebController.class);

    @GetExchange("/QRCode")
    public String showQRCode(@RequestParam String text, Model model) throws IOException, WriterException {
        logger.info("inside function");
        byte[] image = codeService.generateQRCodeImage(text, 300, 300);
        logger.info("image ::: " + image);
        String base64Image = Base64.getEncoder().encodeToString(image);
        logger.info("Base64 QR Code: " + base64Image);
        model.addAttribute("qrCodeImage", "data:image/png;base64," + base64Image);
        logger.info("After base64Image");
        return "qrcode";
    }

}
