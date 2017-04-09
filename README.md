<h1>Robot</h1>
<h2>Informatika érettségi emelt szintű feladat: 2008. október</h2>
<p>Gáborék iskolai szakkörön robotot építenek. Már elkészítettek egy olyan változatot, amelyik sík terepen kellő pontossággal vezérelhető. A robot a memóriájába előre betáplált programok egyikét hajtja végre. A robot jelenleg csak az E, K, D, N utasításokat érti, amelyek a négy égtáj (sorrendben: észak, kelet, dél, nyugat) irányában tett 1 centiméteres elmozdulást eredményezik.</p>
<p>A robotba táplált programokat a program.txt állományban rögzítettük. Az állomány első sorában a betáplált programok száma található, amely legfeljebb 100. Alatta soronként egy-egy program olvasható. Egy sor legfeljebb 200 karakter hosszúságú, benne az E, K, D, N karakterek mint utasítások találhatók. A sorok nem tartalmaznak szóközt.</p>
<p>Például: <em>program.txt</em></p>
<pre>
12
ENNNDKENDND
ENNDDDDENDENDEEDDNNKED
...
</pre>
<p>A 2. sorban az első betáplált program utasításai vannak.</p>
<p>Készítsen programot, amely az alábbi kérdésekre válaszol! A program forráskódját <b><em>robot</em></b> néven mentse!</p>
<p>Minden részfeladat megoldása előtt írja a képernyőre a feladat sorszámát! Ha a felhasználótól kér be adatot, jelenítse meg a képernyőn, hogy milyen értéket vár (például <code>2. feladat: Kérem az utasítássor sorszámát!</code>)!</p>
<ol>
<li>Olvassa be a <b><em>program.txt</em></b> állományban talált adatokat, s azok felhasználásával oldja     meg a következő feladatokat! Ha az állományt nem tudja beolvasni, az állomány első 10 sorának adatait jegyezze be a programba és dolgozzon azzal!</li>
<li>Kérje be egy utasítássor számát, majd írja a képernyőre, hogy:</li>
    <ol style="list-style-type: lower-alpha">
    <li>Egyszerűsíthető-e az utasítássorozat! Az <code>egyszerűsíthető</code>, illetve <code>nem egyszerűsíthető</code> választ írja a képernyőre! (Egy utasítássort egyszerűsíthetőnek nevezünk, ha van benne két szomszédos, ellentétes irányt kifejező utasításpár, hiszen ezek a párok elhagyhatók. Ilyen ellentétes utasításpár az <code>ED, DE, KN, NK</code>.)</li>
    <li>Az utasítássor végrehajtását követően legkevesebb mennyi E vagy D és K vagy N utasítással lehetne a robotot a kiindulási pontba visszajuttatni! A választ a következő formában jelenítse meg: <code>3 lépést kell tenni az ED, 4 lépést a KN tengely mentén.</code></li>
    <li>Annak végrehajtása során hányadik lépést követően került (légvonalban) legtávolabb a robot a kiindulási ponttól és mekkora volt ez a távolság! A távolságot a lépés sorszámát követően 3 tizedes pontossággal írja a képernyőre!</li>
    </ol>
<li>A robot a mozgáshoz szükséges energiát egy beépített akkuból nyeri. A robot 1 centiméternyi távolság megtételéhez 1 egység, az irányváltásokhoz és az induláshoz 2 egység energiát használ. Ennek alapján az <code>EKK</code> utasítássor végrehajtásához 7 egység energia szükséges. A szakkörön használt teljesen feltöltött kis kapacitású akkuból 100, a nagykapacitásúból 1000 egységnyi energia nyerhető ki. Adja meg azon utasítássorokat, amelyek végrehajtásához a teljesen feltöltött kis kapacitású akku is elegendő! Írja a képernyőre egymástól szóközzel elválasztva az utasítássor sorszámát és a szükséges energia mennyiségét! Minden érintett utasítássor külön sorba kerüljön!</li>
<li>Gáborék továbbfejlesztették az utasításokat értelmező programot. Az új, jelenleg még tesztelés alatt álló változatban a több, változatlan irányban tett elmozdulást helyettesítjük az adott irányban tett elmozdulások számával és az irány betűjével. Tehát például a <code>DDDKDD</code> utasítássor leírható rövidített <code>3DK2D</code> formában is. Az önállóan álló utasításnál az 1-es számot nem szabad kiírni! Hozza létre az <b><em>ujprog.txt</em></b> állományt, amely a <b><em>program.txt</em></b> állományban foglalt utasítássorozatokat az új formára alakítja úgy, hogy az egymást követő azonos utasításokat minden esetben a rövidített alakra cseréli! Az <b><em>ujprog.txt</em></b> állományba soronként egy utasítássor kerüljön, a sorok ne tartalmazzanak szóközt!</li>
<li>Sajnos a tesztek rámutattak arra, hogy a program új verziója még nem tökéletes, ezért vissza kell térni az utasítássorok leírásának régebbi változatához. Mivel a szakkörösök nagyon bíztak az új változatban, ezért néhány utasítássort már csak ennek megfelelően készítettek el. Segítsen ezeket visszaírni az eredeti formára! Az ismétlődések száma legfeljebb 200 lehet! Kérjen be egy új formátumú utasítássort, majd írja a képernyőre régi formában!</li>
</ol>
<hr>
<h3>Források:</h3>
<li><a href="https://www.oktatas.hu/pub_bin/dload/kozoktatas/erettsegi/feladatok2008osz/e_info_08okt_fl.pdf">Feladatlap</a>
<li><a href="https://www.oktatas.hu/pub_bin/dload/kozoktatas/erettsegi/feladatok2008osz/e_infoforras_08okt_fl.zip">Forrásállományok</a>