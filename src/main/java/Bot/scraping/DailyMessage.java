package Bot.scraping;

import Bot.Bot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DailyMessage extends ScrapingData implements Runnable {
    JDA jda = Bot.getJda();


    String dailyAnnouncements =
                    "__**DAILY AUTO-UPDATE INFO**__ \n\n" +
                    "**COVID**\n\n" +
                    "Vykonaných PCR testov bolo " + getAllT() +" obeti \n" +
                    "Pozitívne testovaných ľudí pribudlo " + getPcrP() +"\n" +
                    "Za posledný deň zomrelo " + "\n" +
                    "Taktiež jedna z vecí ktoré pribudli na serveri sú nové Emoji";

    //scheduler loop
    @Override
    public void run() {
        TextChannel textChannel = jda.getTextChannelById(806591609789218829L);
        textChannel.sendMessage(dailyAnnouncements).queue();
    }

    public void messageOfTheData() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new DailyMessage();
        int initialDelay = 0;
        int periodicDelay = 1;
        scheduler.scheduleAtFixedRate(task,initialDelay , periodicDelay, TimeUnit.HOURS);

    }
}
