package Bot;

import Bot.scraping.MessageBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


public class Bot  {

    public static JDA jda;
    public static String prefix = ".";


    public static void main(String[] args) throws Exception {
        jda = new JDABuilder().setToken("ODA2NTU0OTgyMDI3NDkzNDQ2.YBrI3A.DyIMh7RpXifYxUxoAETPcXqMB1w").build(); //(AccountType.BOT).setToken
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("developing java"));

        jda.addEventListener(new Commands());
        jda.addEventListener(new Roles());
        jda.addEventListener(new Clear());
        jda.addEventListener(new UserInfo());
        jda.addEventListener(new RoleReactions());
        jda.addEventListener(new TextMessage());

        jda.awaitReady();

        //------------------------------------------------------------//
        MessageBuilder messageBuilder = new MessageBuilder();
        //messageBuilder.run();
        //------------------------------------------------------------//

    }
    public static JDA getJda() {
        return jda;
    }
}
