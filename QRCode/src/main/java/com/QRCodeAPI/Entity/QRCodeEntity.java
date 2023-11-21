package com.QRCodeAPI.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Base64;


//@Entity
//public class QRCodeEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String data;
//    
//    @Lob
//    private byte[] qrCodeData;
//
//    public byte[] getQrCodeData() {
//		return qrCodeData;
//	}
//
//	public void setQrCodeData(byte[] qrCodeData) {
//		this.qrCodeData = qrCodeData;
//	}
//
//	// Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }
//}


//
//@Entity
//@Table(name = "qrcode_entity")
//public class QRCodeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "qr_code_data", length = 5000)
//    private byte[] qrCodeData;
//
//    private String data;
//
//    public QRCodeEntity() {
//        // Default constructor
//    }
//
//    public QRCodeEntity(byte[] qrCodeData, String data) {
//        this.qrCodeData = qrCodeData;
//        this.data = data;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public byte[] getQrCodeData() {
//        return qrCodeData;
//    }
//
//    public void setQrCodeData(byte[] qrCodeData) {
//        this.qrCodeData = qrCodeData;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }
//}













@Entity
@Table(name = "qrcode_entity")
public class QRCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qr_code_data", columnDefinition = "TEXT")
    private String qrCodeData; // Change the type to String

    private String data;

    public QRCodeEntity() {
        // Default constructor
    }

    public QRCodeEntity(byte[] qrCodeData, String data) {
        this.qrCodeData = Base64.getEncoder().encodeToString(qrCodeData);
        this.data = data;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrCodeData() {
        return qrCodeData;
    }

    public void setQrCodeData(String qrCodeData) {
        this.qrCodeData = qrCodeData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Additional method to decode Base64 string back to byte array
    public byte[] decodeBase64ToByteArray() {
        return Base64.getDecoder().decode(this.qrCodeData);
    }
}

