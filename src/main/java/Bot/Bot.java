package Bot;

import Bot.scraping.DailyMessage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Bot implements Runnable {

    public static JDA jda;
    public static String prefix = ".";

    //------------------------------------------------------------//
    //daily auto update info
    String dailyAnnouncements =
            "__**DAILY AUTO-UPDATE INFO**__ \n\n" +
                    "**COVID **\n\n" +
                    "Vykonaných PCR testov bolo " + "\n" +
                    "Pozitívne testovaných ľudí pribudlo " + "\n" +
                    "Za posledný deň zomrelo " + "\n" +
                    "Taktiež jedna z vecí ktoré pribudli na serveri sú nové Emoji";
    public void run() {
        System.out.println("TEST");
        for(int i = 1; i != 2; i++) {
            jda.addEventListener(new DailyMessage());
        }
    }

    public static void dailyUpdate(){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new Bot();
        int initialDelay = 1;
        int periodicDelay = 30;
        scheduler.scheduleAtFixedRate(task,initialDelay , periodicDelay, TimeUnit.SECONDS);
    }
    //------------------------------------------------------------//

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
        dailyUpdate();
    }
}
