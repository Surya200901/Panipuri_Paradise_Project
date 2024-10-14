package com.panipuriparadise.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.WriterException;
import com.panipuriparadise.qrcode.QRCodeGenerator;

@RestController
public class QRCodeController {

    // End point to generate the QR code
    @GetMapping("/generate-qr")
    public String generateQRCode() {
        String menuUrl = "https://panipuri-paradise.onrender.com/menu"; // Updated URL to the menu endpoint
        int width = 300;
        int height = 300;
        String base64Image;

        try {
            base64Image = QRCodeGenerator.getQRCodeImageAsBase64(menuUrl, width, height); // Generate QR code for the menu URL
            return "<img src='data:image/png;base64," + base64Image + "' alt='QR Code'/>";
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return "Error generating QR code.";
        }
    }

    // End point to display the menu
    @GetMapping("/menu")
    public String showMenu() {
        return "<html>" +
                "<head><title>Menu</title></head>" +
                "<body>" +
                "<h2>Menu</h2>" +
                "<ul>" +
                "<li>Panipuri - ₹30</li>" +
                "<li>Bhel Puri - ₹40</li>" +
                "<li>Sev Puri - ₹40</li>" +
                "<li>Chaat - ₹30</li>" +
                "<li>Sweet Puri - ₹30</li>" + // Fixed the syntax error here
                "</ul>" +
                "</body>" +
                "</html>";
    }
}
