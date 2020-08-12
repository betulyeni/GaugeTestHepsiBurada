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
* "/" adresine git
* "betul.yeni@outlook.com" ve "btly.1995" ile giris yap
* "shoppingCart" id nesnesi varsa tikla

 Kullanıcı hatalı giriş kontrol edilmeli
--------------------------
  Tags:Hatali kullanici girisi
* "/" adresine git
* "deneme@gmail.com" ve "12345" ile hatalı giris yap
