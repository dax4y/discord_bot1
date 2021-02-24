package Bot.scraping;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScrapingData {
    private String allT;
    private String pcrP;
    private String deathP;
    private String vaccineFirst;
    private String vaccineTwo;
    private String nameDayFinal;


    public void scraping () throws IOException {
        //html scraping data
        final String url = "https://korona.gov.sk/";


        Document document = Jsoup.connect(url).get();
        //1.
        Elements allTests = document.select("#block_5e9990e25ffff .govuk-body");
        String allTest = allTests.text().replace("Vykonaných PCR testov Pribudlo: ", "");
        allT = allTest;
        //2.
        Elements positivePlus = document.select("#block_5e9991c460002 .govuk-body");
        String pcrPositive = positivePlus.text().replace("Pozitívnych ľudí testovaných PCR Pribudlo: ", "");
        pcrP = pcrPositive;
        //3.
        Elements deathMate = document.select("#block_5e9991ed60005 .govuk-body");
        String death = deathMate.text().replace("Úmrtí Pribudlo: ", "");
        deathP = death;
        //4.
        Elements vaccine1 = document.select("#block_6007f1bbea5a1 .govuk-body");
        Elements vaccine2 = document.select("#block_6022f9c0fe1c9 .govuk-body");
        String vac1 = vaccine1.text().replace("Počet zaočkovaných osôb prvou dávkou Pribudlo: ", "");
        String vac2 = vaccine2.text().replace("Počet zaočkovaných osôb druhou dávkou Pribudlo: ", "");
        vaccineFirst = vac1;
        vaccineTwo = vac2;

        final String url2 = "https://calendar.zoznam.sk/nameday-sksxhor.php";
        Document doc = Jsoup.connect(url2).get();
        //5.
        Elements nameD = doc.select("#container #header #headline2 #headline21 ");
        String nameDay = nameD.text().replace("meniny <div id=\"headline21\">", "");
        //System.out.println(nameDay);
        //String name = nameDay.substring( 0, nameDay.indexOf(","));
        nameDayFinal = nameDay;

//        newe = ticker.substring(0, 3);
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

    public String getVaccineFirst() {
        return vaccineFirst;
    }

    public String getVaccineTwo() {
        return vaccineTwo;
    }

    public String getNameDayFinal() {
        return nameDayFinal;
    }
}
