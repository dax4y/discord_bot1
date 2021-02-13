package Bot;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class Roles extends ListenerAdapter {
    String[] messages = {
//            "[member] joined. You must construct addition pylons!",
//            "Never gonna give [member] up! Never gonna let [member] down!",
//            "Hey! Listen! [member] has joined!",
            "Ha! [member] has joined! You activated my trap card!"
//            "Welcome, [member]. Leave your weapons by the door.",
//            "Welcome, [member]. We hope you brought pizza.",
//            "Brace yourselves. [member] just joined the server.",
//            "[member] just joined. Hide your bananas.",
//            "[member] just arrived. Seems OP - please nerf.",
//            "A [member] has spawned in the server.",
//            "Big [member] showed up!",
//            "Where’s [member]? In the server!",
//            "[member] hopped into the server. Kangaroo!!",
//            "[member] just showed up. Hold my beer.",
//            "Challenger approaching - [member] has appeared!",
//            "It's a bird! It's a plane! Nevermind, it's just [member].",
//            "It's [member]! Praise the sun! [T]/",
//            "Roses are red, violets are blue, [member] joined this server with you",
//            "Hello. Is it [member] you're looking for?",
//            "[member] is here to kick butt and chew bubblegum. And [member] is all out of gum.",
//            "[member] has arrived. Party's over.",
//            "Ready player [member]"
    };

/*    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        //join emblem
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setTitle("SERVER UPDATE");
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();


        //add role

    //    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(809751992704303126L)).complete();
    //   event.getGuild().getController().addRoleToMember(event.getMember(), event.getGuild().getRoleById(809751992704303126L)).complete();
        event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("member", true)).complete();
    }*/

    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event){
        final List<TextChannel> listOfChannel = event.getGuild().getTextChannelsByName("server", true);

        if(listOfChannel.isEmpty()){
            return;
        }
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        final TextChannel channelPlsChannel = listOfChannel.get(0);

        final String userGuildSpecificSettingsInstead = String.format("Welcome %s to %s", event.getMember().getUser().getAsTag(),
                event.getGuild().getName());

        channelPlsChannel.sendMessage(userGuildSpecificSettingsInstead).queue();
    }
    @Override
    public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent event){
        final List<TextChannel> listOfChannel = event.getGuild().getTextChannelsByName("server", true);

        if(listOfChannel.isEmpty()){
            return;
        }

        final TextChannel channel = listOfChannel.get(0);

        final String userGuildSpecificSettingsInstead = String.format("Goodbye %s to %s", event.getMember().getUser().getAsTag(),
                event.getGuild().getName());

        channel.sendMessage(userGuildSpecificSettingsInstead).queue();
    }
}
