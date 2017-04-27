**SÄÄNNÖT:**

Kukin pelaaja saa vuorollaan heittää noppia kolme kertaa. Ensimmäisellä kerralla on heitettävä kaikki nopat. Seuraavalla kahdella heittokerralla pelaaja saa vapaasti valita, mitkä nopat heittää. Kun pelaaja päättää heittovuoronsa, tulos kirjataan pöytäkirjaan ja vuoro siirtyy seuraavalle pelaajalle.
Mikäli pelaaja ei saa sellaista yhdistelmää, joka voidaan kirjata pöytäkirjan johonkin kohtaan, on pöytäkirjaan merkittävä pelaajan valitsemaan kohtaan nolla pistettä.

***YHDISTELMÄT**

Yhdistelmistä saa pisteitä aina mukaan laskettavien noppien silmälukujen summan mukaan (poislukien Kniffel, josta saa aina 50p). 
Esimerkiksi: yhdistelmä 6,6,4,1,5 tuottaisi Ykkösiin 1 pisteen, Kutosiin 12 pistettä, Pariin 12 pistettä, Sattumaan 22 pistettä, Kolmosiin 0 pistettä jne.

Pöytäkirjan yläosan yhdistelmät:

    Ykköset: 	1-silmälukujen summa
    Kakkoset:	2-silmälukujen summa
    Kolmoset: 	3-silmälukujen summa
    Neloset: 	4-silmälukujen summa
    Viitoset: 	5-silmälukujen summa
    Kutoset: 	6-silmälukujen summa

Mikäli pöytäkirjan yläosan yhdistelmistä pelaaja saa 63 pistettä tai yli (välisumma), hän saa 50 pisteen hyvityksen lopputulokseensa.

Pöytäkirjan alaosan yhdistelmät:

    Yksi pari: 	 kaksi kappaletta samaa silmälukua
    Kaksi paria: kaksi eri paria (esim. 4,4,4,4,2 yhdistelmä ei kelpaa)
    Kolmoisluku: kolmessa nopassa sama silmäluku
    Neloisluku:  neljässä nopassa sama luku
    Pieni suora: silmäluvut 1,2,3,4,5
    Suuri suora: 2+3+4+5+6
    Täyskäsi:    yksi pari ja yksi kolmoisluku (viisi samaa lukua ei kelpaa)
    Sattuma:     Silmälukujen summa
    Kniffel:     kaikissa viidessä nopassa sama silmäluku: aina 50 pistettä.

(LÄHDE: https://fi.wikipedia.org/wiki/Yatzy)

**TOIMINNOT**

Pelaajat lisätään kirjoittamalla nimi aloitusikkunan tekstiruutuun ja painamalla "Lisää Pelaaja" painiketta. Pelaajia pelissä voi olla 1-4. Peli aloitetaan Aloita Peli napilla.

Ensimmäisenä syötetty pelaaja aloittaa pelin painamalla "Heitä nopat!" nappia. Ensimmäisen heiton jälkeen noppia voi lukita painamalla niitä, jolloin ne muuttuvat punaisiksi. Nopan voi myös vapauttaa painamalla sitä uudestaan. Halutessaan voi lukita kaikki nopat vaikka ensimmäisen heiton jälkeen, mutta heittonappia on silti painettava kunnes kolmen heiton jälkeen Heittonappi lukittuu ja tulosnapit vapautuvat tuloksen merkitsemistä varten. 

Tulos merkitään painamalla sitä tulosnappia(Ykköset, Kakkoset.. jne.), johon haluataan tulos laskettavan. Kun nappia painetaan, ohjelma laskee parhaat mahdolliset pisteet saadusta noppayhdistelmästä kyseiseen tulokseen ja merkitsee tuloksen vuorossa olevan pelaajan taulukkoon tulosta vastaavaan kohtaan. Tämän jälkeen noppien heittonappi vapautuu, tulosnapit lukittuvat ja vuoro siirtyy seuraavalle pelaajalle.

Peli etenee tähän tapaan, kunnes kaikkien pelaajien kaikki tulosruudut on täytetty, jolloin peli ilmoittaa voittajan ja noppien heittonappi vaihtuu "Lopeta peli" napiksi, jota painamalla PeliIkkuna sammuu ja aukeaa uusi AloitusIkkuna uuden pelin aloittamista varten.


