package Bot.scraping;

import Bot.Bot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MessageBuilder implements Runnable {


    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // in seconds
    private static final int PERIOD = 5;
    private static final int INITIAL_DELAY = 0;
    JDA jda = Bot.getJda();


    public MessageBuilder() {
        scheduler.scheduleAtFixedRate(this, INITIAL_DELAY, PERIOD, TimeUnit.MINUTES);
    }

    public String createMessage(Message message) {
        return "\n__**DAILY AUTO-UPDATE INFO**__📨 \n\n" +
                "🦠***COVID***🦠\n\n" +
                "Vykonaných PCR testov bolo **" + message.getTest() + "**.\n" +
                "Pozitívne testovaných ľudí pribudlo **" + message.getPcr() + "**.\n" +
                "Za posledný deň zomrelo **" + message.getDeathGuys() + "** ľudí.\n" +
                "Prvou vakcínou sa zaočkovalo **" + message.getVaccineNumber() + "** ľudí.\n\n" +
                "🎈***Dnes má meniny***🎈\n" +
                "*" + message.getNameDay() + "*  🎁\n\n" +
                "<@&812697171752779776>" +
                "\n\n*Ak nechceš dostávať upozornenia tohto typu, stačí použiť `.unsub/sub Daily info`*\n";

    }

    //scheduler loop
    @Override
    public void run() {
        TextChannel textChannel = jda.getTextChannelById(806591609789218829L);

        ScrapingData scraping = new ScrapingData();

        try {
            scraping.scraping();

            textChannel.sendMessage(createMessage(
                    new Message(
                            scraping.getAllT(),
                            scraping.getPcrP(),
                            scraping.getDeathP(),
                            scraping.getVac11(),
                            scraping.getNameDayFinal())
            )).queue();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}