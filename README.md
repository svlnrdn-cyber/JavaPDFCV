# Java PDF CV Generator

Bu proje, Java programlama dili kullanılarak kişisel bilgileri ve iş deneyimlerini içeren bir özgeçmişi PDF formatında oluşturan bir uygulamadır.

Uygulama konsol üzerinden çalışmaktadır ve herhangi bir grafik arayüz kullanılmamıştır.

## Projenin Amacı

Projenin amacı Java'da nesne yönelimli programlama yapısını kullanarak kişisel bilgilerin, iş deneyimlerinin ve diğer CV bilgilerinin nesneler halinde modellenmesi ve bu bilgilerin PDF formatında bir özgeçmişe dönüştürülmesidir.

PDF oluşturma işlemi Main sınıfı içerisinde yapılmamıştır. Bu işlem ayrı bir PdfGenerator sınıfı içerisinde gerçekleştirilmiştir.

## Kullanılan Teknolojiler

- Java
- Maven
- Apache PDFBox
- IntelliJ IDEA
- Git
- GitHub

## Proje Yapısı

Proje içerisinde aşağıdaki sınıflar bulunmaktadır:

### Main

Programın başlangıç noktasıdır.

Main sınıfında kişisel bilgiler ve iş deneyimleri için nesneler oluşturulur. Daha sonra bu nesneler bir CV nesnesi içerisinde birleştirilir ve PdfGenerator sınıfına gönderilir.

PDF oluşturma işleminin kendisi Main sınıfında gerçekleştirilmemektedir.

### PersonalInfo

Kişiye ait temel bilgileri tutan sınıftır.

Bu sınıfta;

- Ad soyad
- Telefon
- E-posta
- Adres

bilgileri tutulmaktadır.

Alanlar private olarak tanımlanmıştır ve bu bilgilere getter metotları aracılığıyla erişilmektedir.

### Experience

Bir iş deneyimini temsil eden sınıftır.

Her Experience nesnesinde;

- Şirket adı
- Pozisyon
- Başlangıç tarihi
- Bitiş tarihi
- Açıklama

bilgileri bulunmaktadır.

Projede üç farklı Experience nesnesi oluşturulmuştur.

### CV

PersonalInfo ve Experience nesnelerini bir arada tutan sınıftır.

CV sınıfında bir adet PersonalInfo ve üç adet Experience nesnesi bulunmaktadır.

Bu yapı sayesinde CV içerisindeki bilgiler tek bir nesne üzerinden PdfGenerator sınıfına aktarılabilmektedir.

### PdfGenerator

PDF oluşturma işleminin gerçekleştirildiği sınıftır.

Bu sınıfta Apache PDFBox kütüphanesi kullanılarak A4 boyutunda bir PDF sayfası oluşturulur.

Kişisel bilgiler, eğitim bilgileri, iş deneyimleri, teknik beceriler ve yabancı dil bilgileri PDF üzerine yazılır.

Ayrıca CV içerisinde kullanılacak profil fotoğrafı resources klasöründen alınarak PDF'e eklenir.

## Kullanılan Nesneler

Projede temel olarak aşağıdaki nesneler kullanılmıştır:

- PersonalInfo nesnesi
- Experience nesneleri
- CV nesnesi
- PdfGenerator nesnesi
- PDDocument nesnesi
- PDPage nesnesi
- PDPageContentStream nesnesi

Nesneler, programdaki farklı sorumlulukların birbirinden ayrılması amacıyla kullanılmıştır.

## Nesne Yaşam Döngüsü

Program çalıştırıldığında Main sınıfı içerisinde PersonalInfo ve üç farklı Experience nesnesi oluşturulur.

Daha sonra bu nesneler CV nesnesinin oluşturulması sırasında kullanılır.

Ardından PdfGenerator nesnesi oluşturulur ve CV nesnesi generateCV metodu aracılığıyla PdfGenerator sınıfına gönderilir.

PdfGenerator PDF belgesini oluşturur, bilgileri belgeye ekler ve işlem sonunda PDF dosyasını kaydeder.

Programın çalışması sona erdiğinde oluşturulan nesneler artık kullanılmadıkları için Java'nın bellek yönetimi kapsamında yaşam döngülerini tamamlar.

## Erişim Düzenleyiciler

Projede farklı erişim düzenleyiciler kullanılmıştır.

### private

Sınıflardaki veri alanları private olarak tanımlanmıştır.

Örneğin PersonalInfo sınıfındaki name, phone, email ve address alanları dışarıdan doğrudan erişime kapatılmıştır.

Bu yaklaşım encapsulation yani kapsülleme prensibinin uygulanmasını sağlar.

### public

Sınıflar, constructorlar ve dışarıdan kullanılmasına ihtiyaç duyulan metotlar public olarak tanımlanmıştır.

Örneğin PdfGenerator sınıfındaki generateCV metodu public olarak tanımlanmıştır.

## Kullanılan Kütüphane

Projede PDF oluşturmak için Apache PDFBox kullanılmıştır.

PDFBox sayesinde Java programı içerisinde PDF belgesi oluşturulmuş, A4 boyutunda sayfa eklenmiş, metinler ve fotoğraf PDF içerisine yerleştirilmiştir.

## Kaynak Dosyalar

- `src/main/java/com/cvgenerator/Main.java`
- `src/main/java/com/cvgenerator/PersonalInfo.java`
- `src/main/java/com/cvgenerator/Experience.java`
- `src/main/java/com/cvgenerator/CV.java`
- `src/main/java/com/cvgenerator/PdfGenerator.java`
- `src/main/resources/profile.jpg`
- `src/main/resources/Arial.ttf`
- `pom.xml`


## Yapay Zeka Araçlarından Faydalanma

Projenin geliştirilmesi sırasında ChatGPT'den sınırlı şekilde destek alınmıştır.

ChatGPT, özellikle bazı Java kodlarının anlaşılması, Apache PDFBox kullanımıyla ilgili takıldığım noktaların açıklanması ve oluşan hataların çözümünde yardımcı bir kaynak olarak kullanılmıştır.

Projenin temel yapısı ve kodların IntelliJ IDEA içerisinde oluşturulması ve test edilmesi tarafımdan gerçekleştirilmiştir. ChatGPT tarafından verilen öneriler incelenmiş, gerekli görülen kısımlar projeye uygulanmış ve program çalıştırılarak kontrol edilmiştir.

Yapay zeka aracı geliştirme sürecinde karşılaşılan problemlerde destek almak amacıyla kullanılmıştır.

## Çalıştırma

Projeyi çalıştırmak için Main.java dosyası çalıştırılmalıdır.

Program başarılı bir şekilde çalıştığında proje klasörü içerisinde:

`ozgecmis.pdf`

adında bir PDF dosyası oluşturulur.