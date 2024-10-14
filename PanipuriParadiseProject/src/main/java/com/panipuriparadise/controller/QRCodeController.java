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
                "    background-image: url('https://i.imgur.com/KGZiv9F.png');" + // Background image
                "    background-size: cover;" + // Make the background cover the entire container
                "    background-position: center;" + // Center the background image
                "    border-radius: 15px;" + // Round corners
                "    box-shadow: 0 8px 30px rgba(0, 0, 0, 0.3);" + // Stronger shadow
                "    padding: 30px;" + // Increased padding
                "    width: 400px;" +
                "    text-align: center;" +
                "    border: 2px solid rgba(255, 255, 255, 0.5);" + // Light border
                "    transition: transform 0.3s, box-shadow 0.3s;" + // Transition effects
                "}" +
                ".menu-container:hover {" + // Hover effect for the container
                "    transform: translateY(-5px);" + // Slight upward movement
                "    box-shadow: 0 12px 50px rgba(0, 0, 0, 0.5);" + // Stronger shadow on hover
                "}" +
                "h2 {" +
                "    color: #fff;" + // Change text color to white for better visibility
                "    margin-bottom: 20px;" +
                "    font-size: 26px;" + // Increased font size
                "    font-weight: bold;" + // Bold title
                "    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);" + // Shadow for text
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
                "    font-size: 20px;" + // Slightly larger font size
                "    color: #fff;" + // Change text color to white for better visibility
                "    display: flex;" +
                "    align-items: center;" +
                "    justify-content: flex-start;" + // Align items to the left
                "    padding: 10px;" +
                "    border-radius: 5px;" + // Rounded corners for items
                "    transition: background-color 0.3s;" + // Transition for hover effect
                "}" +
                "li:hover {" + // Hover effect for list items
                "    background-color: rgba(255, 255, 255, 0.2);" + // Light background on hover
                "}" +
                "img {" +
                "    width: 50px;" + // Set a fixed width for the images
                "    height: 50px;" + // Set a fixed height for the images
                "    border-radius: 5px;" +
                "    margin-right: 10px;" +
                "    transition: transform 0.3s;" + // Transition effect for images
                "}" +
                "img:hover {" + // Hover effect for images
                "    transform: scale(1.1);" + // Slightly enlarge the image on hover
                "}" +
                "span.price {" +
                "    font-weight: bold;" +
                "    color: #007BFF;" + // Price color
                "    font-size: 18px;" + // Price font size
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='menu-container'>" +
                "<h2>Menu</h2>" +
                "<ul>" +
                "<li><img src='https://images.pexels.com/photos/17184404/pexels-photo-17184404/free-photo-of-deep-fried-bread-pani-puri-with-chickpea-filling-served-with-spread.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2' alt='Panipuri'> Panipuri <span class='price'>₹30</span></li>" +
                "<li><img src='https://images.pexels.com/photos/13063315/pexels-photo-13063315.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2' alt='Bhel Puri'> Bhel Puri <span class='price'>₹40</span></li>" +
                "<li><img src='https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgrXp7d6jIeWUS6CQiajKwaWM29tBuQLRy6kYrYf7VtMhrjA12hqycSot2uBnsQy6I_tFbd5uGNhXBgaElA-hHxWCB2H-x1kb3sZQJTY4BSYDCdjSJKqsPYZkTNqNoQH8gSvCpCZ9y6kK2q/s320/IMG_20200106_183637.jpg' alt='Sev Puri'> Sev Puri <span class='price'>₹40</span></li>" +
                "<li><img src='https://i0.wp.com/www.tomatoblues.com/wp-content/uploads/2021/01/masala-poori-chaat-2-scaled.jpg?w=1440&ssl=1' alt='Chaat'> Chaat <span class='price'>₹30</span></li>" +
                "<li><img src='https://chaiandchurros.com/wp-content/uploads/2021/06/GolGappayPic-1024x1536.jpeg' alt='Sweet Puri'> Sweet Puri <span class='price'>₹30</span></li>" +
                "</ul>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

}
