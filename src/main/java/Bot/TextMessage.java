package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TextMessage extends ListenerAdapter {
    //Public announce
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        //Role Information
        if (args[0].equalsIgnoreCase(Bot.prefix + "use")) {
            EmbedBuilder role = new EmbedBuilder();
            role.setTitle("→Role activation: ");
            role.addField("- - - - - - - - - - - - - - -\n" +
                            "→Hello guys in this section we will make some crazy stuff.",
                    "→The only thing you have to do is to click with the \n" +
                            " right button on this post and select out of these roles \n" +
                            " which you want to have. ✅\n" +
                            "-\n" +
                            "<:crewmatee:807411213754957864>" + " : crew mate\n" +
                            "-\n" +
                            "<:amoungus:807352151214129182>" + " : impostor\n" +
                            "-\n" +
                            "<:tudom:807059533062471790>" + " : troll\n" +
                            "-\n" +
                            "<:kekw:807414953585410089>" + " : autism\n" +
                            "-\n" +
                            "<:200iq:807351737177866250>" + " : 200iq", false);

            event.getChannel().sendMessage(role.build()).queue();
            role.clear();
        }

        String messages =
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

        if (args[0].equalsIgnoreCase(Bot.prefix + "ann")) {
            event.getChannel().sendMessage(messages).queue();
        }

    }
}
