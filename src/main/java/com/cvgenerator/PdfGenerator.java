package com.cvgenerator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PdfGenerator {

    public void generateCV(CV cv) {

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Türkçe karakter destekli fontları yükle
            InputStream fontStream =
                    getClass().getResourceAsStream("/Arial.ttf");

            PDType0Font normalFont =
                    PDType0Font.load(document, fontStream);

            InputStream boldFontStream =
                    getClass().getResourceAsStream("/Arial_Bold.ttf");

            PDType0Font boldFont;

            if (boldFontStream != null) {
                boldFont = PDType0Font.load(document, boldFontStream);
                boldFontStream.close();
            } else {
                boldFont = normalFont;
            }

            if (fontStream != null) {
                fontStream.close();
            }

            PDPageContentStream content =
                    new PDPageContentStream(document, page);

            // =========================
            // AD SOYAD
            // =========================

            content.beginText();
            content.setFont(boldFont, 22);
            content.newLineAtOffset(50, 780);
            content.showText(cv.getPersonalInfo().getName());
            content.endText();


            // =========================
            // KİŞİSEL BİLGİLER
            // =========================

            content.beginText();
            content.setFont(normalFont, 11);
            content.newLineAtOffset(50, 750);

            content.showText(
                    "Telefon: "
                            + cv.getPersonalInfo().getPhone()
            );

            content.newLineAtOffset(0, -18);

            content.showText(
                    "E-posta: "
                            + cv.getPersonalInfo().getEmail()
            );

            content.newLineAtOffset(0, -18);

            content.showText(
                    "Adres: "
                            + cv.getPersonalInfo().getAddress()
            );

            content.endText();


            // =========================
            // PROFİL
            // =========================

            content.beginText();
            content.setFont(boldFont, 16);
            content.newLineAtOffset(50, 675);
            content.showText("PROFİL");
            content.endText();

            content.beginText();
            content.setFont(normalFont, 10);
            content.newLineAtOffset(50, 650);

            content.showText(
                    "Yazılım mühendisliği alanında kendini geliştiren,"
            );

            content.newLineAtOffset(0, -15);

            content.showText(
                    "Java ve nesne yönelimli programlama konusunda"
            );

            content.newLineAtOffset(0, -15);

            content.showText(
                    "çalışmalar yapan bir yazılım mühendisidir."
            );

            content.endText();


            // =========================
            // EĞİTİM
            // =========================

            content.beginText();
            content.setFont(boldFont, 16);
            content.newLineAtOffset(50, 580);
            content.showText("EĞİTİM");
            content.endText();

            content.beginText();
            content.setFont(boldFont, 11);
            content.newLineAtOffset(50, 555);
            content.showText("Yazılım Mühendisliği");
            content.endText();

            content.beginText();
            content.setFont(normalFont, 10);
            content.newLineAtOffset(50, 535);
            content.showText("Kırklareli Üniversitesi - 2022 - Devam ediyor");
            content.endText();


            // =========================
            // İŞ DENEYİMLERİ
            // =========================

            content.beginText();
            content.setFont(boldFont, 16);
            content.newLineAtOffset(50, 490);
            content.showText("İŞ DENEYİMLERİ");
            content.endText();

            writeExperience(
                    content,
                    cv.getExperience1(),
                    460,
                    boldFont,
                    normalFont
            );

            writeExperience(
                    content,
                    cv.getExperience2(),
                    385,
                    boldFont,
                    normalFont
            );

            writeExperience(
                    content,
                    cv.getExperience3(),
                    310,
                    boldFont,
                    normalFont
            );


            // =========================
            // TEKNİK BECERİLER
            // =========================

            content.beginText();
            content.setFont(boldFont, 16);
            content.newLineAtOffset(50, 225);
            content.showText("TEKNİK BECERİLER");
            content.endText();

            content.beginText();
            content.setFont(normalFont, 10);
            content.newLineAtOffset(50, 200);

            content.showText("Java");
            content.newLineAtOffset(0, -15);

            content.showText("Python");
            content.newLineAtOffset(0, -15);

            content.showText("HTML");
            content.newLineAtOffset(0, -15);

            content.showText("Git ve GitHub");
            content.newLineAtOffset(0, -15);

            content.showText("SQL");
            content.endText();


            // =========================
            // YABANCI DİL
            // =========================

            content.beginText();
            content.setFont(boldFont, 16);
            content.newLineAtOffset(300, 225);
            content.showText("YABANCI DİL");
            content.endText();

            content.beginText();
            content.setFont(normalFont, 10);
            content.newLineAtOffset(300, 200);

            content.showText("İngilizce - Orta Seviye");
            content.newLineAtOffset(0, -15);

            content.showText("Rusça - Başlangıç / Orta Seviye");
            content.endText();


            // =========================
            // FOTOĞRAF
            // =========================

            InputStream imageStream =
                    getClass().getResourceAsStream("/profile.jpg");

            if (imageStream != null) {

                BufferedImage bufferedImage =
                        ImageIO.read(imageStream);

                PDImageXObject image =
                        LosslessFactory.createFromImage(
                                document,
                                bufferedImage
                        );

                content.drawImage(
                        image,
                        430,
                        700,
                        120,
                        120
                );

                imageStream.close();
            }


            content.close();

            document.save("ozgecmis.pdf");

            System.out.println(
                    "CV başarıyla oluşturuldu: ozgecmis.pdf"
            );

        } catch (IOException e) {

            System.out.println(
                    "PDF oluşturulurken hata meydana geldi."
            );

            e.printStackTrace();
        }
    }


    private void writeExperience(
            PDPageContentStream content,
            Experience experience,
            float y,
            PDType0Font boldFont,
            PDType0Font normalFont) throws IOException {

        content.beginText();

        content.setFont(boldFont, 11);
        content.newLineAtOffset(50, y);

        content.showText(
                experience.getCompany()
                        + " - "
                        + experience.getPosition()
        );

        content.newLineAtOffset(0, -17);

        content.setFont(normalFont, 10);

        content.showText(
                experience.getStartDate()
                        + " - "
                        + experience.getEndDate()
        );

        content.newLineAtOffset(0, -17);

        content.showText(
                experience.getDescription()
        );

        content.endText();
    }
}