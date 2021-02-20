package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Roles extends ListenerAdapter {
    String[] messages = {
            "Welcome, **[member]** joined. You must construct addition pylons!",
            "Welcome, Never gonna give **[member]** up! Never gonna let **[member]** down!",
            "Hey! Listen! **[member]** has joined!",
            "Ha! **[member]** has joined! You activated my trap card!",
            "Welcome, **[member]**. Leave your weapons by the door.",
            "Welcome, **[member]**. We hope you brought pizza.",
            "Brace yourselves. **[member]** just joined the server.",
            "**[member]** just joined. Hide your bananas.",
            "**[member]** just arrived. Seems OP - please nerf.",
            "A **[member]** has spawned in the server.",
            "Big **[member]** showed up!",
            "Where’s **[member]**? In the server!",
            "**[member]** hopped into the server. Kangaroo!!",
            "**[member]** just showed up. Hold my beer.",
            "Challenger approaching - **[member]** has appeared!",
            "It's a bird! It's a plane! Nevermind, it's just **[member]**.",
            "Roses are red, violets are blue, **[member]** joined this server with you",
            "Hello. Is it **[member]** you're looking for?",
            "**[member]** is here to kick butt and chew bubblegum. And **[member]** is all out of gum.",
            "**[member]** has arrived. Party's over.",
            "Ready player **[member]**"
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

    }*/

    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event){
        final List<TextChannel> listOfChannel = event.getGuild().getTextChannelsByName("server-messages", true);

        if(listOfChannel.isEmpty()){
            return;
        }
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x0ad13f);
        join.setTitle("Join message:");
        final TextChannel channelPlsChannel = listOfChannel.get(0);
        final String userWelcomeMessage = (messages[number].replace("[member]",event.getMember().getUser().getName()));
        join.setDescription(userWelcomeMessage);

        channelPlsChannel.sendMessage(join.build()).queue();

        //role add
        event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("member", true)).complete();

        Guild guild = event.getJDA().getGuildById(801860011105714176L);//pupkoši

        if (guild != null) {
            event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(812320852783136800L))).queue();//class
            event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(812323615256346664L))).queue();//group
            event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(812324417580564490L))).queue();//mentions
            event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(801864518724091905L))).queue();//member
            event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(812324646229770300L))).queue();//daily info
            event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(812324795555381248L))).queue();//Server update
        }

        //event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("member", true)).queue();

    }
    @Override
    public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent event){
        final List<TextChannel> listOfChannel = event.getGuild().getTextChannelsByName("server-messages", true);

        if(listOfChannel.isEmpty()){
            return;
        }

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0xbd2b26);
        join.setTitle("Leave message:");
        final TextChannel channelPlsChannel = listOfChannel.get(0);
        final String userByeMessage = String.format("Goodbye **%s** from %s", event.getMember().getUser().getName(),
                event.getGuild().getName());
        join.setDescription(userByeMessage);

        channelPlsChannel.sendMessage(join.build()).queue();

    }
}
