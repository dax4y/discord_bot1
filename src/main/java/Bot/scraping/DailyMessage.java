package Bot.scraping;

import Bot.Bot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DailyMessage implements Runnable {
    JDA jda = Bot.getJda();

    private String test = "";
    private String pcr = "";
    private String deathGuys = "";
    private String vaccineNumber = "";
    private String nameDay = "";

    public void setTest(String test) {
        this.test = test;
    }

    public void setPcr(String pcr) {
        this.pcr = pcr;
    }

    public void setDeathGuys(String deathGuys) {
        this.deathGuys = deathGuys;
    }

    public void setVaccineNumber(String vaccineNumber) {
        this.vaccineNumber = vaccineNumber;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public String text() {
        String dailyAnnouncements =
                        "\n" +
                        "__**DAILY AUTO-UPDATE INFO**__📨 \n\n" +
                        "🦠***COVID***🦠\n\n" +
                        "Vykonaných PCR testov bolo **" + test + "**.\n" +
                        "Pozitívne testovaných ľudí pribudlo **" + pcr + "**.\n" +
                        "Za posledný deň zomrelo **" + deathGuys +"**.\n" +
                        "Zaočkovalo sa **"+ vaccineNumber +"**\n\n"+
                        "🎈***Dnes má meniny***🎈\n" +
                        "*"+ nameDay +"*  🎁\n\n" +
                        "@pig" +
                        "\n\n*Ak mechceš dostávať upozornenia tohto typu, stačí použiť .unsub Daily Updates*\n"
                        ;
        return dailyAnnouncements;
    }

    //scheduler loop
    @Override
    public void run() {
        TextChannel textChannel = jda.getTextChannelById(806591609789218829L);
        textChannel.sendMessage(text()).queue();
    }

    public void messageOfTheData() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new DailyMessage();
        int initialDelay = 1;
        int periodicDelay = 30;
        scheduler.scheduleAtFixedRate(task,initialDelay , periodicDelay, TimeUnit.MINUTES);

    }
}
