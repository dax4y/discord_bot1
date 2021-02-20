package Bot.scraping;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScrapingData {
    private String allT;
    private String pcrP;
    private String deathP;
    private int vaccine;
    private String vac11;
    private String vac22;




    public void scraping () throws IOException {
        //html scraping data
        final String url = "https://korona.gov.sk/";


        Document document = Jsoup.connect(url).get();
        //1.
        Elements allTests = document.select("#block_5e9990e25ffff .govuk-body");
        String allTest = allTests.text().replace("Vykonaných PCR testov Pribudlo: ", "");
        //System.out.println(allTest);
        allT = allTest;
        //2.
        Elements positivePlus = document.select("#block_5e9991c460002 .govuk-body");
        String pcrPositive = positivePlus.text().replace("Pozitívnych ľudí testovaných PCR Pribudlo: ", "");
        //System.out.println(pcrPositive);
        pcrP = pcrPositive;
        //3.
        Elements deathMate = document.select("#block_5e9991ed60005 .govuk-body");
        String death = deathMate.text().replace("Úmrtí Pribudlo: ", "");
        //System.out.println(death);
        deathP = death;
        //4.
        Elements vaccine1 = document.select("#block_6007f1bbea5a1 .govuk-body");
        Elements vaccine2 = document.select("#block_6022f9c0fe1c9 .govuk-body");
        String vac1 = vaccine1.text().replace("Počet zaočkovaných osôb prvou dávkou Pribudlo: ", "");
        String vac2 = vaccine2.text().replace("Počet zaočkovaných osôb druhou dávkou Pribudlo: ", "");
        vac11 = vac1;
        vac22 = vac2;

        final String url2 = "https://www.zones.sk/kalendar-udalosti/meniny/";
        Document doc = Jsoup.connect(url2).get();
        //5.
        Elements nameD = doc.select("#zmena_casu .zmena_datum_meniny [href]");
        String nameDay = nameD.text().replace("", "");
        //System.out.println("meniny " + nameD);


//        newe = ticker.substring(0, 3);
    }

    public int change (String string){
        int integer = Integer.parseInt(string);
        return integer;
    }

    public String getAllT() {
        return allT;
    }

    public String getPcrP() {
        return pcrP;
    }
    public String getDeathP() {
        return deathP;
    }

    public int getVaccine() {
        return vaccine;
    }

    public String getVac11() {
        return vac11;
    }

    public String getVac22() {
        return vac22;
    }

}
