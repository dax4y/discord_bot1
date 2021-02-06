package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserInfo extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] message = e.getMessage().getContentRaw().split(" ");

        if(message.length == 1 && message[0].equalsIgnoreCase(Bot.prefix + "avatar")){
            e.getChannel().sendMessage("To get a user's avatar, type:  " + Bot.prefix + "avatar [ @name ]").queue();

        }else if(message.length == 2 && message[0].equalsIgnoreCase(".avatar")){
            String userName = message[1];
            //search list of members with this name
            User user = e.getGuild().getMembersByName(userName, true).get(0).getUser();
            String avatar = user.getAvatarUrl();
            EmbedBuilder avatarEmblem = new EmbedBuilder();

            avatarEmblem.setTitle(userName + "'s Avatar: ");
            avatarEmblem.setColor(0xffe6ff);
            avatarEmblem.addField("Name", user.getName(), true);
            //avatarEmblem.addField("Online Status: ", e.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmblem.setImage(avatar);


            e.getChannel().sendMessage(avatarEmblem.build()).queue();
        }


    }

}
