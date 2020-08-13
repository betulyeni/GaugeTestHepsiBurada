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
* "betul.yeni@outlook.com" ve "btly.1995" ile giris yap


 Kullanıcı Girişi
--------------------------
Tags:Hatali kullanici giris kontrol
* "/" adresine git
* "betul.yeni@outlook.com" ve "btly.1995" ile giris yap
* ekranda "Betül Yeni" yazisini gormen gerekiyor
* Login kontrol "Betül Yeni"


Rasgele Bir Kategori Seçimi
---------------------------
Tags: Kategori ve alt kategori seçimi
* "/" adresine git
*"//*[@id=footer_11]" id nesnesi varsa tikla
//*Mouse over1
//* "MenuItems-1-U3X" id nesnesi altindaki "Mod" yazisina tikla
//* "Menu-Banner" id nesnesi altindaki "Elektronik" yazisina tikla

Fiyat girme
------------------------
Tags: Fiyat aralığı belirleme
* "/bilgisayarlar-c-2147483646" adresine git
* "#\35 b8a9b97-a3d3-4b4b-97c0-a26833dd8ebe > div > ol > li.box-container.fiyat > div > div > div:nth-child(1) > input" css alanina "10" yazdin
* "#\35 b8a9b97-a3d3-4b4b-97c0-a26833dd8ebe > div > ol > li.box-container.fiyat > div > div > div:nth-child(3) > input" css alanina "4000" yazdin

Yeni adres ekle
---------------------
* "/" adresine git
* "betul.yeni@outlook.com" ve "btly.1995" ile giris yap
* "//*[@id=shoppingCart]" xpath nesnesine tikla
* "Alışverişi Tamamla" yazisina tikla
* "link-type-two" className nesnesine tikla
* "first-name" id alanina "Tetinium" yaz
* "last-name" id alanina "Tetinium" yaz
* "filter-option pull-left" seçiminiz "1"
* "//*[@id=form-address]" seçiminiz "2"
* "//*[@id=form-address]/div/div/section[2]/div[4]/div/div/button/span[1]" seçiminiz "3"
*"address" id alanina "Acıbadem-İstanbul" yaz
* "address-name" id alanina "iş" yaz
* "phone" id alanina "555 575 05 50" yaz
*"citizen-id" id alanina "44443532222" yaz
* "Adresi Kaydet" yazisina tikla
* "Devam Et" yazisina tikla
* "plus-icon" className nesnesine tikla
* "card-no" id alanina "1234123412341234" yaz
*"holder-Name" id alanina "Testinium" yaz
*"//*[@id=payment-type-1]/div/form/fieldset/div[3]/div/div[1]/div/button" seçiminiz "02"
*"filter-option pull-left " seçiminiz "2021"
*"cvc" id alanina "123" yaz
* "/" adresine git
* "//*[@id=shoppingCart]" xpath nesnesine tikla
* "btn-delete" className nesnesine tikla
* Mouse over
*"//*[@id=myAccount]" id nesnesi varsa tikla
* "NavigationMenuItem-3JKIS" className nesnesine tikla
* "btn-delete btn-text" className nesnesine tikla
* "btn btn-md" className nesnesine tikla


