package com.QRCodeAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.QRCodeAPI.Entity.QRCodeEntity;
import com.QRCodeAPI.Repository.QRCodeRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.security.MessageDigest;
import java.util.Base64;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeRepository qrCodeRepository;

    
    @GetMapping("/generateQRCode")
    public ResponseEntity<String> generateQRCodeGET(@RequestParam("data") String data, @RequestParam("number") int number) {
        try {
            byte[] qrCodeBytes = generateQRCode(data, number);

//            // Print or log the generated QR code bytes for verification
            System.out.println("Generated QR Code Bytes: " + Arrays.toString(qrCodeBytes));

            QRCodeEntity entity = createQRCodeEntity(qrCodeBytes, data);
            qrCodeRepository.save(entity);
            return ResponseEntity.ok("QR Code generated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate QR Code");
        }
    }
    
    private QRCodeEntity createQRCodeEntity(byte[] qrCodeBytes, String data) {
        QRCodeEntity entity = new QRCodeEntity();
        entity.setQrCodeData(Base64.getEncoder().encodeToString(qrCodeBytes)); // Encode to Base64
        entity.setData(data);
        return entity;
    }
 // Example method to decode Base64 string back to byte array
    private byte[] decodeBase64ToByteArray(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }


	@PostMapping("/generateQRCode")
    public ResponseEntity<String> generateQRCodePOST(@RequestBody Map<String, Object> requestData) {
        try {
            String data = requestData.containsKey("data") ? requestData.get("data").toString() : "";
            int number = requestData.containsKey("number") ? Integer.parseInt(requestData.get("number").toString()) : 0;

            byte[] qrCodeBytes = generateQRCode(data, number);
            qrCodeRepository.save(createQRCodeEntity(qrCodeBytes, data));
            return ResponseEntity.ok("QR Code generated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate QR Code");
        }
    }
	
	
	
	
//	LOGIC 1 TO GENERATE QR CODE
	

//	private byte[] generateQRCode(String data, int number) {
//	    try {
//	        if (data == null) data = "";
//	        if (number <= 0) number = 1;
//
//	        // Configure QR code hints
//	        Map<EncodeHintType, Object> hints = new HashMap<>();
//	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//
//	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//	        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200, hints);
//
//	        // Convert BitMatrix to BufferedImage
//	        BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
//	        bufferedImage.createGraphics();
//	        int white = 255 << 16 | 255 << 8 | 255;
//	        int black = 0;
//	        for (int i = 0; i < 200; i++) {
//	            for (int j = 0; j < 200; j++) {
//	                bufferedImage.setRGB(i, j, bitMatrix.get(i, j) ? black : white);
//	            }
//	        }
//
//	        // Convert BufferedImage to byte array (PNG format)
//	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	        ImageIO.write(bufferedImage, "png", outputStream);
//	        return outputStream.toByteArray();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new RuntimeException("Error generating QR code bytes");
	// Example method to decode Base64 string back to byte array
	
	
	
	
	
//	LOGIC 2 TO GENERATE QR CODE
	
//	private byte[] generateQRCode(String data, int number) {
//	    try {
//	        if (data == null) data = "";
//	        if (number <= 0) number = 1;
//
//	        // Configure QR code hints
//	        Map<EncodeHintType, Object> hints = new HashMap<>();
//	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//
//	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//	        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200, hints);
//	        
//	        
//
//	        // Write the QR code bit matrix to a byte array
//	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
//	        return outputStream.toByteArray();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new RuntimeException("Error generating QR code bytes");
//	        
//	        
	
	
	
	        
	        
//	        LOGIC 3 TO GENERATE QR CODE
	
//	private byte[] generateQRCode(String data, int number) {
//	    try {
//	        if (data == null) data = "";
//	        if (number <= 0) number = 1;
//
//	        // Generate a unique identifier (e.g., timestamp)
//	        String uniqueIdentifier = data + "_" + System.currentTimeMillis();
//
//	        // Configure QR code hints
//	        Map<EncodeHintType, Object> hints = new HashMap<>();
//	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//
//	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//	        BitMatrix bitMatrix = qrCodeWriter.encode(uniqueIdentifier, BarcodeFormat.QR_CODE, 200, 200, hints);
//
//	        // Write the QR code bit matrix to a byte array
//	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
//	        return outputStream.toByteArray();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new RuntimeException("Error generating QR code bytes");
//	    }
//	}

	
	
	
//	LOGIC 4 TO GENERATE QR CODE
	

//	private byte[] generateQRCode(String data, int number) {
//	    try {
//	        if (data == null) data = "";
//	        if (number <= 0) number = 1;
//
//	        // Append a unique value (based on input and number) to create different data for each input
//	        String uniqueData = data + "-" + number;
//
//	        // Convert the uniqueData to a byte array
//	        byte[] dataBytes = uniqueData.getBytes(StandardCharsets.UTF_8);
//
//	        // Configure QR code hints
//	        Map<EncodeHintType, Object> hints = new HashMap<>();
//	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//
//	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//	        BitMatrix bitMatrix = qrCodeWriter.encode(new String(dataBytes), BarcodeFormat.QR_CODE, 200, 200, hints);
//
//	        // Write the QR code bit matrix to a byte array
//	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
//	        return outputStream.toByteArray();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new RuntimeException("Error generating QR code bytes");
//	    }
//	}
//
//



	
	
	
	
	
	
//	LOGIC 5 TO GENERATE QR CODE
	


	private byte[] generateQRCode(String data, int number) {
	    try {
	        if (data == null) data = "";
	        if (number <= 0) number = 1;

	        // Hash the input data using SHA-256
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(data.getBytes());

	        // Encode the hash to Base64 to generate the QR code
	        String encodedHash = Base64.getEncoder().encodeToString(hash);

	        // Configure QR code hints
	        Map<EncodeHintType, Object> hints = new HashMap<>();
	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(encodedHash, BarcodeFormat.QR_CODE, 200, 200, hints);

	        // Write the QR code bit matrix to a byte array
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
	        return outputStream.toByteArray();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error generating QR code bytes");
	    }
	}

}





