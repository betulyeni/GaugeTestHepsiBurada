Getting Started with Gauge
==========================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, use `mvn test`
Siteye Giriş
-----------
 Tags: Anasayfaya giriş
  * "/" adresine git

Kullanıcı başarılı giriş kontrol edilmeli
--------------------
 Tags:Kullanici girisi
* "/" adresine git
* Mouse over
* "login" id nesnesine tikla
* "txtUserName" id alanina "betul.yeni@outlook.com" yaz
* "txtPassword" id alanina "btly.1995" yaz
* "btnLogin" id nesnesine tikla


 Kullanıcı hatalı giriş kontrol edilmeli
--------------------------
  Tags:Hatali kullanici girisi
* "/" adresine git
* Mouse over
* "login" id nesnesine tikla
* "txtUserName" id alanina "deneme@gmail.com" yaz
* "txtPassword" id alanina "12345" yaz
* "btnLogin" id nesnesine tikla


Rasgele Bir Kategori Seçimi
---------------------------
* "Menu-Banner" id nesnesi altindaki "Mod" yazisina tikla
* ekranda "POPÜLER MARKALAR" yazisini gormen gerekiyor
* "/" adresine git
* "Menu-Banner" id nesnesi altindaki "Elektronik" yazisina tikla
* ekranda "Popüler Markalar" yazisini gormen gerekiyor

