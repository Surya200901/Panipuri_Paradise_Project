package com.panipuriparadise.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Base64;

public class QRCodeGenerator {

    // Method to generate a QR code image and save it to the specified file path (not used in this implementation)
    public static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = Path.of(filePath); // Update for the correct file path
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    // Method to generate a QR code image as a Base64 encoded string
    public static String getQRCodeImageAsBase64(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        // Convert the BitMatrix to Base64 encoded string
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // Use ByteArrayOutputStream to hold image bytes
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        byte[] bytes = outputStream.toByteArray(); // Get the byte array from the output stream
        return Base64.getEncoder().encodeToString(bytes); // Convert byte array to Base64 string
    }
}
