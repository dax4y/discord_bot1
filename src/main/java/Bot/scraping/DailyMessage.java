package Bot.scraping;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DailyMessage extends ListenerAdapter {
    private final JDA jda;

    public DailyMessage(JDA jda) {
        this.jda = jda;
    }


    public void onMessageReceived(MessageReceivedEvent event) {

        String dailyAnnouncements =
                "@everyone \n" +
                        "*****Ahojte*****, <:cahlVVd:809116009045819433> \n\n" +
                        "týmto oznamom by som vám chcel dať do pozornosti že náš server úspešne dosiahol \n" +
                        "a odomkol ***prvú úroveň*** vďaka @Server Booster . Kvalita zvuku a obrazu (sharingu) \n" +
                        "by mala byť od tohto momentu lepšia, uvidíme dokedy nám to vydrží. <:shibaDepressed:809109694870061087> \n\n" +
                        "Taktiež jedna z vecí ktoré pribudli na serveri sú nové Emoji,\n" +
                        "verím že sa vám budú páčiť a nájdu si svoje využitie. Ostalo tam ešte zopár miest \n" +
                        "takže ak máte súkromne želanie neváhajte napísať. <:vinceStupid:809116169763815474> \n\n" +
                        "Užívajte server a jeho výhody. \n" +
                        "Pekný zvyšok večera. @Dax <:dax:807352185713065995> ";


        jda.getTextChannelById(806591609789218829L).sendMessage(dailyAnnouncements).queue();
    }
}
