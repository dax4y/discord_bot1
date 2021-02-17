package Bot.scraping;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BeepClock implements Runnable {

    public void run(){
        System.out.println("Test");
    }

    public static void dailyUpdate(){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new BeepClock();
        int initialDelay = 4;
        int periodicDelay = 2;
        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay, TimeUnit.SECONDS);
    }



    public static void main(String[] args) {



        //html scraping data
        /*
        final String url = "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";

        try{
            final Document document = Jsoup.connect(url).get();

            for(Element row : document.select("table.tablesorter.full tr")){

                if(row.select("td:nth-of-type(1)").text().equals("")){
                    continue;
                }
                else{
                    final String ticker = row.select("td:nth-of-type(1)").text();

                    final String name = row.select("td:nth-of-type(2)").text();

                    final String tempPrice = row.select("td.right:nth-of-type(3)").text();
                    final String tempPrice1 = tempPrice.replace(",", "");
                    final double price = Double.parseDouble(tempPrice1);

                    System.out.println(ticker + " " + name + " " + price);
                }
            }

        }
        catch (Exception ex){
            ex.printStackTrace();

        }*/
    }

}
