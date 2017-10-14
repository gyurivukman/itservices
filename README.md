# IT Services

## Funckionális Követelmények:

### Leírás:
Ez a webes alkalmazás a fiktív Sampletext Company nevű multinacionális cég számára készült és mint neve is sejteti, a cég belső informatikai szogáltatásait hivatott támogatni: 
Egyrészt az alkalmazottaknak lehetőségük van informatikai szolgáltatásokat igényelni és/vagy ezekkel kapcsolatos hibákat bejelenteni, valamint az operátorok ezekre a hibákra a szokásos igényekkel kapcsolatos tevékenységeken túl (in progress-be helyezés, lezárás, approveolás, más bevonása, disapproveolás, további adatok bekérése, stb.) reagálni is tudnak "személyesen" kommentek/emailek formájában.

A rendszerhez való hozzáférés regisztrációhoz és bejelentkezéshez kötött.

### Szerepkörök:

**Alkalmazott**
Az alkalmazottaknak legyen lehetőségük szolgáltatásokat igényelni, mint például:
   * Munkaállomás céges image-el való újratelepítése
   * Munkaállomás tulajdonosának megváltoztatása
   * VPN token igénylés
   * Rendszergazdai jog igénylése munkaállomáshoz
   * Hozzáférés különböző belsős toolokhoz és más szolgáltatásokhoz
   * Support vagy training kérése
   * Igényelt alkalmazás feltelepíttetése
   * Munkaállomás hardveres hibájának bejelentése
   * Céges e-mail igénylés
   * stb

**Operátor**
Az operátorok tevékenységköre:
   * A különböző requestek állapotának megváltoztatása(Approve, disapprove, lezár, újranyit, információt kér, prioritást változtat, stb)
   * Egy request eszkalálása, mások bevonása
   * Kommentek/emailek írása
   * stb

**Manager Operátor**
    * Beosztott operátorok tevékenységének ellenőrzése (Megoldott/in progress requestek száma, azok megtekintése, kommentek elolvasása)
    * Eszkalált requestek kezelése
    * Operátorok hozzárendelése/leválasztása application  areak-hoz és taskokhoz.
**Admin**
Adminisztrátorok tevékenyégköre:
   *  Új szolgáltatás felvétele, szolgáltatás módosítása, törlése (archiválás)
   * Hozzáférési szintek beállítása mind az operátorok mind a felhasználók számára
   * Jelszavak resetelése
   * stb

Bejelentkezés után mind a három felhasználó-típus a tevékenységkörüknek megfelelő műveleteket tud elvégezni:
    Egy alkalmazott, attól függően , hogy beosztott vagy manager, képes az alkalmazotti tevékenységkör különböző részeit elvégezni, megnézni az igényelt szolgáltatások állapotát, kommenteket írni és olvasni, de a saját adataik egy részének módosítása is ide tartozik.
   * A felhasználók jelszavait bizonyos időközönként megkell újítani.
   *  Hasonlóan a többi szerepkörre is.


## Nem funkcionális követelmények:
Ha egy felhasználó nincs bejelentkezve, akkor egy bejelentkezési képernyő fogadja, ahonnan a fő nézetre csak a bejelentkezést követően tud lépni.
Bejelentkezett felhasználó kijelentkezhet.

Bejelentkezés után a főoldalon az adott felhasználó számára elérhető szolgáltatások listáját látjuk.
   * Adminisztrátorok számára további kezelő gombok is látszanak.
   * Hozzáadás, módosítás, törlés, stb

A szolgáltatás megigényléséhez a megfelelő listaelemre vagy ikonra kattintva egy új nézetet kapunk, rajta egy a szolgáltatáshoz kapcsolható kitöltendő űrlappal - melynek bizonyos részeit előre kitöltheti a szoftver a bejelentkezett felhasználó alapján. Csak a teljesen és helyesen kitöltött űrlap esetén fogadunk el egy kérést. 

Egy service request igényléshez az igénylés dátuma és a hozzátartozó azonosítók a létrehozás pillanatában automatikusan generálódnak.
Elküldeni csak egy áttekintő/megerősítő nézet után van lehetőség. Utólag módosítani egy service requestet csak adminisztrátor tud.

Az operátorok egy külön nézetet látnak, ahol a rájuk vonatkozó application area-knak és level-nek megfelelő service requestek látszanak egy áttekintő listában, néhány fontosabb adatukkal: Külön azok, amelyekhez éppen hozzá vannak rendelve és külön azok is, amelyekhez még nincs senki rendelve. A service requesteket mindkét nézet esetén elsősorban a fontossági sorrendjük szerint csökkenő másodsorban a frissességük szerint növekvő sorrendben látják. (Legfontosabb/Legrégebbi).
Képesek kiválasztani egy service requestet, annak részletes adatait megtekinteni és azt magukhoz vagy egy beosztottjukhoz hozzárendelni.
Egy service request állapotának megváltoztatását is itt végezhetik.

Az operátor managerek az operátorok munkáján felül képesek a beosztottaik tevékenységét ellenőrizni, service requestet rendelni hozzájuk valamint application areakhoz hozzárendelni vagy onnan leválasztani őket.

Az adminisztrátorok képesek elvégezni mindazt, amit az operátorok, operátor managerek is, valamint:
   * Új szolgáltatást vehetnek fel: Itt meg kell adni a szolgáltatás nevét, application area-ját és meg kell szerkeszteni egy speciális nézet segítségével a szolgáltatáshoz tartozó űrlapot.
   * Új application area-t vehetnek fel
   * Meghatározhatják a többi felhasználó típus jogkörének részeit.

Szolgáltatás állapotának változásáról a felhasználót értesíteni lehet (email).
Egy lezárt service requesthez ne tudjon kommentelni senki sem és csak adminisztrátor tudja újra nyitni - amikor is ismét lehet kommentelni.
Adott felhasználóhoz tartozó service request-ek állapotának lekérdezéséhez jól látható helyen kell egy menüpont vagy gomb.
Egy alkalmazott csak bizonyos mennyiségű service requestet kérhet egyszerre, hasonlóan egy operátor csak bizonyos mennyiségűt kezelhet egyszerre.
A különböző adatokat és a funkcionális követelményeknek megfelelő entitásokat perzisztens adatbázisban kell tárolni.
A szoftver felhasználói felületét úgy kell kialakítani, hogy minél gyorsabban és egyszerűbben tudjon minden alkalmazott ügyet intézni, ezért az egyértelműség és letisztultság kulcsfontosságú.

## Szótár
   * in-progress - az igénylés operátorhoz lett rendelve és dolgozik rajta
   * approve - igénylés elfogadása
   * disapprove - igénylés megtagadása
   * closed - lezárt kérés
   * céges image - operációs rendszer telepítőfájl, a cég igénye szerint testreszabva
   * VPN token - VPN azonosító, mellyel a felhasználó használni tudja a VPN-t
   * belsős tool - csak a cégen belül használt specializált szoftver
   * service request - szolgáltatás igénylés
   * application area - egy operátor szakértelmét jellemző terület/területek
   * level - hozzáértési szint, manager operátor esetén