package Bot.scraping;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScrapingData {
    private String allT;
    private String pcrP;

    public void scraping () throws IOException {
        //html scraping data
        final String url = "https://korona.gov.sk/";


        Document document = Jsoup.connect(url).get();
        Elements allTests = document.select("#block_5e9990e25ffff .govuk-body");
        String allTest = allTests.text().replace("Vykonaných PCR testov Pribudlo: ", "");
        //System.out.println(allTest);
        allT = allTest;
        Elements positivePlus = document.select("#block_5e9991c460002 .govuk-body");
        String pcrPositive = positivePlus.text().replace("Pozitívnych ľudí testovaných PCR Pribudlo: ", "");
        //System.out.println(pcrPositive);
        pcrP = pcrPositive;

//        newe = ticker.substring(0, 3);
    }
    public void print (String allT,String pcrP){
        System.out.println(allT);
        System.out.println(pcrP);
    }

    public String getAllT() {
        return allT;
    }

    public String getPcrP() {
        return pcrP;
    }

}
