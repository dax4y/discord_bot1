package Bot.scraping;

import Bot.Bot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DailyMessage implements Runnable {
    JDA jda = Bot.getJda();
    Bot bot = new Bot();
    private String test = "";
    private String pcr = "";

    public void setTest(String test) {
        this.test = test;
    }

    public void setPcr(String pcr) {
        this.pcr = pcr;
    }



    public String text() {
        String dailyAnnouncements =
                "__**DAILY AUTO-UPDATE INFO**__ \n\n" +
                        "**COVID**\n\n" +
                        "Vykonaných PCR testov bolo " + test + " obeti \n" +
                        "Pozitívne testovaných ľudí pribudlo " + pcr + "\n" +
                        "Za posledný deň zomrelo " + "\n" +
                        "Taktiež jedna z vecí ktoré pribudli na serveri sú nové Emoji";
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
        int initialDelay = 0;
        int periodicDelay = 1;
        scheduler.scheduleAtFixedRate(task,initialDelay , periodicDelay, TimeUnit.HOURS);

    }
}
