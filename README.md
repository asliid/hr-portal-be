# ÖZET
Şirket içinde kullanılabilecek bir HR(İnsan Kaynakları) uygulaması oluşturmak amaçlanmaktadır.Bu bağlamda kullanıcı, personellerin temel bilgilerini giriş güncelleme ile ilgili  işlemler yapabilecektir. Şirket içi personellere teslim edilecek envanter tiplerini ve listesini yöneten işlevsellikler sağlanacaktır.
<br>  <br>
Aiming to create an HR (Human Resources) application for internal company use, users will be able to perform tasks related to entering and updating basic information about personnel. Functionalities will be provided to manage the types and lists of inventory that will be assigned to company personnel.

# Genel Bilgiler
Bu proje, bir şirketin insan kaynakları yönetimini ve envanter takip süreçlerini dijitalleştirmek amacıyla tasarlanmış bir HR (İnsan Kaynakları) uygulaması geliştirilmiştir. Uygulama, personel bilgilerinin giriş ve güncelleme işlemlerini kolaylaştıracak, şirket içi envanter yönetimini verimli bir şekilde gerçekleştirecek ve personellere teslim edilen envanterlerin takibini sağlayacak bir dizi işlevsellik sunar.
<br>  <br>
This project involves the development of an HR (Human Resources) application designed to digitize a company’s human resources management and inventory tracking processes. The application facilitates the entry and updating of personnel information, efficiently manages internal inventory, and provides a range of functionalities to track the inventory assigned to personnel.
<br>  <br>

<img src="https://github.com/asliid/ik-portal-be/blob/main/photos/home.png" 
  style="  
    display: block;
  margin-left: auto;
  margin-right: auto;
  "/><br> Giriş ekranı <br>  <br>

# Genel İşlevsellikler
1. Personel Yönetimi (IK Rolü)
 <br>  <br>
•	Filtreleme ve Listeleme: Kullanıcılar, personel adı, soyadı, TCKN ve birim bilgilerine göre personel araması yapabilirler. Arama sonuçları bir tabloda görüntülenebilir ve her satırda güncelleme işlemleri için bir buton yer alır.
<br>  <br>
•	Filtering and Listing: Users can search for personnel by first name, last name, TCKN, and department information. The search results can be displayed in a table, with a button for update operations available in each row.
<br>  <br>
•	Personel Ekleme ve Güncelleme: “Yeni Personel” butonu ile yeni personel ekleme ve mevcut personel bilgilerini güncelleme işlemleri yapılabilir. Personel ekleme ve güncelleme işlemleri, tanımlanan PERSONEL İŞLEMLERİ ekranı üzerinden gerçekleştirilir.
<br>  <br>
•	Adding and Updating Personnel: The “Add New Personnel” button allows for the addition of new personnel and the updating of existing personnel information. Personnel addition and updating operations are carried out through the defined PERSONNEL OPERATIONS screen.
<br>  <br>
<img src="https://github.com/asliid/ik-portal-be/blob/main/photos/personel.png" 
  style="  
    display: block;
  margin-left: auto;
  margin-right: auto;
  "/><br> Personel işlemleri ekranı <br>  <br>

3. Envanter Yönetimi (Envanter Yönetimi Rolü)
 <br>  <br>
	•	Filtreleme ve Listeleme: Kullanıcılar, zimmet tipine göre envanter araması yapabilirler. Arama sonuçları, envanter tipi, marka, model ve seri numarası bilgileriyle listelenir. Her satırda envanter güncelleme butonu bulunur.
<br>  <br>
	•	Filtering and Listing: Users can search for inventory based on zimmet type. The search results are listed with details such as inventory type, brand, model, and serial number. Each row includes an inventory update button.
<br> <br>

	•	Zimmet Ekleme ve Güncelleme: “Yeni Zimmet Ekle” butonu ile yeni zimmet ekleme ve mevcut zimmet bilgilerini güncelleme işlemleri yapılabilir. Zimmet ekleme ve güncelleme işlemleri, tanımlanan ENVANTER BİLGİLERİ ekranı üzerinden gerçekleştirilir.
<br>  <br>
	•  	Adding and Updating Zimmet: Users can add a new zimmet or update existing zimmet information using the “Add New Zimmet” button. The zimmet adding and updating operations are carried out through the defined INVENTORY INFORMATION screen.
<br>  <br>
<img src="https://github.com/asliid/ik-portal-be/blob/main/photos/envanter.png" 
  style="  
    display: block;
  margin-left: auto;
  margin-right: auto;
  "/><br> Envanter işlemleri ekranı <br>  <br>
  
4. Zimmet İşlemleri (IK Rolü)
 <br>  <br>
	•	Personel Arama ve Zimmet Yönetimi: Personel sicil numarası ve ada göre arama yapılacak ve sonuçlar bir tabloda görüntülenecek. Bu tabloda, personelin mevcut zimmet bilgilerine erişim sağlanacak. “Zimmeti Geri Al” butonu ile zimmet geri alma işlemi yapılabilecek ve envanter başka bir personele atanabilir hale getirilecek.
 <br>  <br>
	• 	Personnel Search and Zimmet Management: Search will be conducted by personnel identification number and name, and the results will be displayed in a table. This table will provide access to the personnel’s current zimmet information. The “Return Zimmet” button will allow the zimmet return process, making the inventory available to be assigned to another person.
<br>  <br>
	•	Yeni Zimmet Ekleme: “Yeni Zimmet Ekle” butonu ile kullanılmayan envanterler listelenecek ve seçilen envanterin teslim tarihi belirlenerek zimmet işlemi tamamlanacak.
<br>  <br>
•	Adding New Zimmet: The “Add New Zimmet” button will list unused inventories, and by selecting an inventory and specifying the delivery date, the zimmet process will be completed.
<br>  <br>
<img src="https://github.com/asliid/ik-portal-be/blob/main/photos/zimmet1.png" 
  style="  
    display: block;
  margin-left: auto;
  margin-right: auto;
  "/><br> Zimmet işlemleri detayları ekranı <br>  <br>
<img src="https://github.com/asliid/ik-portal-be/blob/main/photos/zimmet2.png" 
  style="  
    display: block;
  margin-left: auto;
  margin-right: auto;
  "/><br> Zimmet işlemleri ekranı <br>  <br>
# Sonuç
Bu uygulama ile, şirketin insan kaynakları ve envanter süreçlerini daha etkili yönetmesine olanak tanıyan, kullanıcı dostu bir platform sunmayı amaçlanmıştır.
<br> <br> 
This application aims to provide a user-friendly platform that allows the company to manage its human resources and inventory processes more effectively.
