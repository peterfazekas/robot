package hu.robot.service;

import hu.robot.data.api.Data;
import hu.robot.model.Program;
import hu.robot.service.convert.ConvertProgram;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class Robot {

    private static final int BATTERY_LIMIT = 100;

    private final List<Program> programList;
    private final ConvertProgram convert;

    public Robot(final String source) {
        Data data = new Data();
        convert = new ConvertProgram();
        programList = data.getData(source);
    }

    /**
     * 2. feladat: Kérje be egy utasítássor számát, majd írja a képernyőre, hogy:
     * a. Egyszerűsíthető-e az utasítássorozat!
     *    Az egyszerűsíthető, illetve nem egyszerűsíthető választ írja a képernyőre!
     *    (Egy utasítássort egyszerűsíthetőnek nevezünk, ha  van benne két szomszédos,
     *    ellentétes irányt kifejező utasításpár, hiszen ezek a párok elhagyhatók.
     *    Ilyen ellentétes utasításpár az ED, DE, KN, NK.)
     * b. Az utasítássor végrehajtását követően legkevesebb mennyi E vagy D és K vagy N utasítással
     *    lehetne a robotot a kiindulási pontba visszajuttatni! A választ a következő formában
     *    jelenítse meg: 3 lépést kell tenni az ED, 4 lépést a KN tengely mentén.
     * c. Annak végrehajtása során hányadik lépést követően került (légvonalban) legtávolabb a
     *    robot a kiindulási ponttól és mekkora volt ez a távolság! A távolságot a lépés sorszámát
     *    követően 3 tizedes pontossággal írja a képernyőre!
     * @param id a program sorszáma
     * @return - String formájában a megfelelő válaszok.
     */
    public String programAnalysis(final int id) {
        Program program = programList.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .get();
        return String.format("   a. feladat: A program %s%n", reducible(program))
               + String.format("   b. feladat: %s%n", program.getOrigin())
               + String.format("   c. feladat: %s", program);
    }

    private String reducible(Program program) {
        return program.isReducible() ? "egyszerűsithető" : "nem egyszerűsithető";
    }

    /**
     * 3. feladat: A robot a mozgáshoz szükséges energiát egy beépített akkuból nyeri. A robot 1 centiméternyi
     * távolság megtételéhez 1 egység, az irányváltásokhoz és az induláshoz 2 egység energiát használ.
     * Ennek alapján az EKK utasítássor végrehajtásához 7 egység energia szükséges.
     * A szakkörön használt teljesen feltöltött kis kapacitású akkuból 100, a nagykapacitásúból 1000 egységnyi
     * energia nyerhető ki. Adja meg azon utasítássorokat, amelyek végrehajtásához a teljesen feltöltött kis
     * kapacitású akku is elegendő!
     * Írja a képernyőre egymástól szóközzel elválasztva az utasítássor sorszámát és a szükséges energia
     * mennyiségét! Minden érintett utasítássor külön sorba kerüljön!
     * @return - String formájában a megfelelő válaszok.
     */
    public String getLowEnergyPrograms() {
        StringBuilder sb = new StringBuilder();
        programList.stream()
                .filter(this::isSmallCapacityBattery)
                .map(this::printProgramEnergy)
                .forEach(sb::append);
        return sb.toString();
    }

    private boolean isSmallCapacityBattery(final Program program) {
        return program.getBattery() <= BATTERY_LIMIT;
    }

    private String printProgramEnergy(final Program program) {
        return String.format("%n   %d %d", program.getId(), program.getBattery());
    }

    /**
     * 4. feladat: Gáborék továbbfejlesztették az utasításokat értelmező programot. Az új, jelenleg még
     * tesztelés alatt álló változatban a több, változatlan irányban tett elmozdulást helyettesítjük az
     * adott irányban tett elmozdulások számával és az irány betűjével. Tehát például a DDDKDD utasítássor
     * leírható rövidített 3DK2D formában is. Az önállóan álló utasításnál az 1-es számot nem szabad kiírni!
     * Hozza létre az ujprog.txt állományt, amely a program.txt állományban foglalt utasítássorozatokat az
     * új formára alakítja úgy, hogy az egymást követő azonos utasításokat minden esetben a rövidített alakra
     * cseréli! Az ujprog.txt állományba soronként egy utasítássor kerüljön, a sorok ne tartalmazzanak szóközt!
     * @return - String formájában a megfelelő válaszok.
     */
    public String getNewFormatPrograms() {
        StringBuilder sb = new StringBuilder();
        programList.forEach(i -> sb.append(String.format("%s%n", convert.toNewFormat(i.getProgram()))));
        return sb.toString();
    }

    /**
     * 5. feladat: Sajnos a tesztek rámutattak arra, hogy a program új verziója még nem tökéletes, ezért
     *  vissza kell térni az utasítássorok leírásának régebbi változatához. Mivel a szakkörösök nagyon
     *  bíztak az új változatban, ezért néhány utasítássort már csak ennek megfelelően készítettek el.
     *  Segítsen ezeket visszaírni az eredeti formára! Az ismétlődések száma legfeljebb 200 lehet!
     *  Kérjen be egy új formátumú utasítássort, majd írja a képernyőre régi formában!
     * @param newFormatProgram - Az új formátumú program
     * @return - String formájában a megfelelő válaszok.
     */
    public String getOldFormatProgram(final String newFormatProgram) {
        return "   " + convert.toOldFormat(newFormatProgram);
    }


}
