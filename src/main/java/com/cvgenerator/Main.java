package com.cvgenerator;

public class Main {

    public static void main(String[] args) {

        // Kişisel bilgiler
        PersonalInfo personalInfo = new PersonalInfo(
                "Şevval Nur Üreden",
                "0555 123 45 67",
                "seval@gmail.com",
                "Kırklareli, Türkiye"
        );

        // 1. iş deneyimi
        Experience experience1 = new Experience(
                "Atlas Teknoloji",
                "Java Developer",
                "2024",
                "2025",
                "Java kullanarak yazılım geliştirme çalışmalarında görev aldı."
        );

        // 2. iş deneyimi
        Experience experience2 = new Experience(
                "Nova Bilişim",
                "Software Intern",
                "2023",
                "2024",
                "Yazılım projelerinde test ve kodlama çalışmalarına katıldı."
        );

        // 3. iş deneyimi
        Experience experience3 = new Experience(
                "TeknoSoft",
                "Junior Developer",
                "2022",
                "2023",
                "Web ve masaüstü uygulamalarının geliştirilmesine destek oldu."
        );

        // CV nesnesi
        CV cv = new CV(
                personalInfo,
                experience1,
                experience2,
                experience3
        );

        // PDF oluşturucu
        PdfGenerator pdfGenerator = new PdfGenerator();

        // CV'yi PDF olarak oluştur
        pdfGenerator.generateCV(cv);
    }
}