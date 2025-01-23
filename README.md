# Book n' Bite
  

# Opis projekta
Ovaj projekt je rezultat timskog rada u sklopu projeknog zadatka kolegija [Programsko inženjerstvo](https://www.fer.unizg.hr/predmet/proinz) na Fakultetu elektrotehnike i računarstva Sveučilišta u Zagrebu. 

Zamislite scenarij u kojem se nalazite u grupi prijatelja i svi želite nešto pojesti, ali se ne možete 
međusobno dogovoriti u koji restoran želite otići, odnosno iz kojeg restorana želite nešto naručiti. 
Glavna zadaća ove aplikacije je olakšati vam vaš izbor te na temelju osobnih preferencija svih 
članova odrediti koji bi restoran najviše odgovarao grupi u cjelini. Naime, svaki korisnik bi u aplikaciji 
dobio listu jela iz raznih restorana te bi svako od ponuđenih jela ocjenjivao zvjezdicama od 1 do 5, 
ovisno o tome koliko mu se to jelo sviđa i koliko bi ga tom trenutku želio jesti. Kada bi svi članovi grupe 
prošli ovaj postupak aplikacija bi na temelju ocjena odredila koji restoran bi najviše odgovarao grupi 
odnosno ispisala i cijelu rang listu restorana.

# Funkcijski zahtjevi
- Signup: restoran ili ocjenjivač
- Login: restoran, ocjenjivač ili admin
- Funkcionalni zahtjevi restorana 
  - forma podataka: unos lokacija, informacija o restoranu
- Funkcionalni zahtjevi ocjenjivača
  - profil page: osnovni podaci o ocjenjivaču

- Funkcionalnost 
  - generiranje grupe 
  - generiranje/unos koda 
  - odabir lokacije, grupe, vrste proizvoda koju ocjenjivač želi konzumirati 
  - popis restorana koji najbolje odgovaraju zahtjevima ocjenjivača
  - reference na stranice restorana, stranice na aplikacijama za narudžbu 

- Funkcionalnost Admin
  - pristup svim registriranim ocjenjivačima i restoranima
  - uklanjanje korisničkog profila ili restorana


# Tehnologije

- Front-end: React.js
- Back-end: Spring Boot (Java)
- Baza podataka: PostgreSQL
- Autentifikacija: OAuth 2.0
- Servisi za obavijesti: Firebase Cloud Messaging (FCM)
- Geolokacijski servisi: Google Maps API

# Članovi tima 
- Ivo Gabud ivo.gabud@fer.unizg.hr  - Voditelj projekta
- Gabriel Leko gabriel.leko@fer.unizg.hr
- Rene Filipović rene.filipovic@fer.unizg.hr
- Adrian Ambroz adrian.ambroz@fer.unizg.hr
- Filip Knapić filip.knapic@fer.unizg.hr
- Jelena Ivanković jelena.ivankovic2@fer.unizg.hr
- Ivana Renić ivana.renic@fer.unizg.hr

# Kontribucije
>Pravila ovise o organizaciji tima i su često izdvojena u CONTRIBUTING.md



# 📝 Kodeks ponašanja [![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg)](CODE_OF_CONDUCT.md)
Kao studenti sigurno ste upoznati s minimumom prihvatljivog ponašanja definiran u [KODEKS PONAŠANJA STUDENATA FAKULTETA ELEKTROTEHNIKE I RAČUNARSTVA SVEUČILIŠTA U ZAGREBU](https://www.fer.hr/_download/repository/Kodeks_ponasanja_studenata_FER-a_procisceni_tekst_2016%5B1%5D.pdf), te dodatnim naputcima za timski rad na predmetu [Programsko inženjerstvo](https://wwww.fer.hr).
Očekujemo da ćete poštovati [etički kodeks IEEE-a](https://www.ieee.org/about/corporate/governance/p7-8.html) koji ima važnu obrazovnu funkciju sa svrhom postavljanja najviših standarda integriteta, odgovornog ponašanja i etičkog ponašanja u profesionalnim aktivnosti. Time profesionalna zajednica programskih inženjera definira opća načela koja definiranju  moralni karakter, donošenje važnih poslovnih odluka i uspostavljanje jasnih moralnih očekivanja za sve pripadnike zajenice.

Kodeks ponašanja skup je provedivih pravila koja služe za jasnu komunikaciju očekivanja i zahtjeva za rad zajednice/tima. Njime se jasno definiraju obaveze, prava, neprihvatljiva ponašanja te  odgovarajuće posljedice (za razliku od etičkog kodeksa). U ovom repozitoriju dan je jedan od široko prihvačenih kodeks ponašanja za rad u zajednici otvorenog koda.
>### Poboljšajte funkcioniranje tima:
>* definirajte načina na koji će rad biti podijeljen među članovima grupe
>* dogovorite kako će grupa međusobno komunicirati.
>* ne gubite vrijeme na dogovore na koji će grupa rješavati sporove primjenite standarde!
>* implicitno podrazmijevamo da će svi članovi grupe slijediti kodeks ponašanja.
 
>###  Prijava problema
>Najgore što se može dogoditi je da netko šuti kad postoje problemi. Postoji nekoliko stvari koje možete učiniti kako biste najbolje riješili sukobe i probleme:
>* Obratite mi se izravno [e-pošta](mailto:vlado.sruk@fer.hr) i  učinit ćemo sve što je u našoj moći da u punom povjerenju saznamo koje korake trebamo poduzeti kako bismo riješili problem.
>* Razgovarajte s vašim asistentom jer ima najbolji uvid u dinamiku tima. Zajedno ćete saznati kako riješiti sukob i kako izbjeći daljnje utjecanje u vašem radu.
>* Ako se osjećate ugodno neposredno razgovarajte o problemu. Manje incidente trebalo bi rješavati izravno. Odvojite vrijeme i privatno razgovarajte s pogođenim članom tima te vjerujte u iskrenost.

# 📝 Licenca
Važeča (1)
[![CC BY-NC-SA 4.0][cc-by-nc-sa-shield]][cc-by-nc-sa]

Ovaj repozitorij sadrži otvoreni obrazovni sadržaji (eng. Open Educational Resources)  i licenciran je prema pravilima Creative Commons licencije koja omogućava da preuzmete djelo, podijelite ga s drugima uz 
uvjet da navođenja autora, ne upotrebljavate ga u komercijalne svrhe te dijelite pod istim uvjetima [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License HR][cc-by-nc-sa].
>
> ### Napomena:
>
> Svi paketi distribuiraju se pod vlastitim licencama.
> Svi upotrijebleni materijali  (slike, modeli, animacije, ...) distribuiraju se pod vlastitim licencama.

[![CC BY-NC-SA 4.0][cc-by-nc-sa-image]][cc-by-nc-sa]

[cc-by-nc-sa]: https://creativecommons.org/licenses/by-nc/4.0/deed.hr 
[cc-by-nc-sa-image]: https://licensebuttons.net/l/by-nc-sa/4.0/88x31.png
[cc-by-nc-sa-shield]: https://img.shields.io/badge/License-CC%20BY--NC--SA%204.0-lightgrey.svg

Orginal [![cc0-1.0][cc0-1.0-shield]][cc0-1.0]
>
>COPYING: All the content within this repository is dedicated to the public domain under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
>
[![CC0-1.0][cc0-1.0-image]][cc0-1.0]

[cc0-1.0]: https://creativecommons.org/licenses/by/1.0/deed.en
[cc0-1.0-image]: https://licensebuttons.net/l/by/1.0/88x31.png
[cc0-1.0-shield]: https://img.shields.io/badge/License-CC0--1.0-lightgrey.svg

### Reference na licenciranje repozitorija
