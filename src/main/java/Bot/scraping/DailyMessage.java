package Bot.scraping;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DailyMessage extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String dailyAnnouncements =
                "__**DAILY AUTO-UPDATE INFO**__ \n\n" +
                        "**COVID **\n\n" +
                        "Vykonaných PCR testov bolo " + "\n" +
                        "Pozitívne testovaných ľudí pribudlo " + "\n" +
                        "Za posledný deň zomrelo " + "\n" +
                        "Taktiež jedna z vecí ktoré pribudli na serveri sú nové Emoji";

        event.getJDA().getTextChannelById(806591609789218829L).sendMessage(dailyAnnouncements).queue();

        //TextChannel textChannel = event.getJDA().getTextChannelById(806591609789218829L);
        //textChannel.sendMessage(dailyAnnouncements).queue();

    }
}
