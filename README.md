# UniqueQRCodeGenerator
"UniqueQRCodeGenerator" is a Java-based project that enables the generation of diverse and distinct QR codes for different inputs.


# Features

**Unique QR Code Generation:** Generates diverse QR codes for different input data.
**Scalability:** Built to handle a large number of unique data inputs without repetition.
**Customizable:** Easily adjustable for various sizes and error correction levels of QR codes.

# Usage
### Clone the Repository:
[git clone https://github.com/Hugs-4-Bugs/UniqueQRCodeGenerator.git](https://github.com/Hugs-4-Bugs/UniqueQRCodeGenerator.git)


# Compile and Run:
Use your favorite Java IDE to compile and execute the project.
Ensure all necessary dependencies are installed as specified in the pom.xml file.


# SQL Query
### Use below query for creating the database👇

create database if not exists QRCodeAPI;

use QRCodeAPI;

CREATE TABLE QRCodeEntity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data VARCHAR(255)
);

ALTER TABLE qrcode_entity MODIFY qr_code_data BLOB;


# Postman
Postman is used to test the user input 'data'.

**URL:-** http://localhost:8100/generateQRCode


# Contributing
Contributions are welcome! Fork this repository and submit a pull request with your enhancements.

# License
This project is licensed under the MIT License.

Feel free to tailor this content to fit your project specifics!





