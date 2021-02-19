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
        System.out.println(allTest);
        allT = allTest;
        Elements positivePlus = document.select("#block_5e9991c460002 .govuk-body");
        String pcrPositive = positivePlus.text().replace("Pozitívnych ľudí testovaných PCR Pribudlo: ", "");
        System.out.println(pcrPositive);
        pcrP = pcrPositive;


//        newe = ticker.substring(0, 3);
        }

    public String getAllT() {
        System.out.println("all " +allT);
        return this.allT;
    }

    public String getPcrP() {
        System.out.println("pcr " +pcrP);
        return this.pcrP;
    }

}
