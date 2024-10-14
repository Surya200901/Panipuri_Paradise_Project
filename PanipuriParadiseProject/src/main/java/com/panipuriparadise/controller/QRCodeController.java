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
                "<head>" +
                "<title>Menu</title>" +
                "<link href='https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap' rel='stylesheet'>" +
                "<style>" +
                "body {" +
                "    font-family: 'Roboto', sans-serif;" +
                "    background-color: #f9f9f9;" +
                "    margin: 0;" +
                "    padding: 0;" +
                "    display: flex;" +
                "    justify-content: center;" +
                "    align-items: center;" +
                "    height: 100vh;" +
                "}" +
                ".menu-container {" +
                "    background-color: #fff;" +
                "    border-radius: 10px;" +
                "    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);" +
                "    padding: 20px;" +
                "    width: 400px;" +
                "    text-align: center;" +
                "    border: 2px solid #ddd;" +
                "}" +
                "h2 {" +
                "    color: #333;" +
                "    margin-bottom: 20px;" +
                "    font-size: 24px;" +
                "    border-bottom: 2px solid #007BFF;" +
                "    padding-bottom: 10px;" +
                "}" +
                "ul {" +
                "    list-style: none;" +
                "    padding: 0;" +
                "    margin: 0;" +
                "}" +
                "li {" +
                "    margin: 15px 0;" +
                "    font-size: 18px;" +
                "    color: #555;" +
                "    display: flex;" +
                "    align-items: center;" +
                "    justify-content: space-between;" +
                "    padding: 10px;" +
                "    border-bottom: 1px solid #eee;" +
                "}" +
                "img {" +
                "    width: 50px;" + // Adjust the size of the images
                "    height: 50px;" + // Adjust the size of the images
                "    border-radius: 5px;" +
                "    margin-right: 10px;" +
                "}" +
                "span.price {" +
                "    font-weight: bold;" +
                "    color: #007BFF;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='menu-container'>" +
                "<h2>Menu</h2>" +
                "<ul>" +
                "<li><img src='https://example.com/panipuri.jpg' alt='Panipuri'> Panipuri <span class='price'>₹30</span></li>" +
                "<li><img src='https://example.com/bhelpuri.jpg' alt='Bhel Puri'> Bhel Puri <span class='price'>₹40</span></li>" +
                "<li><img src='https://example.com/sevpuri.jpg' alt='Sev Puri'> Sev Puri <span class='price'>₹40</span></li>" +
                "<li><img src='https://example.com/chaat.jpg' alt='Chaat'> Chaat <span class='price'>₹30</span></li>" +
                "<li><img src='https://example.com/sweetpuri.jpg' alt='Sweet Puri'> Sweet Puri <span class='price'>₹30</span></li>" +
                "</ul>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

}
