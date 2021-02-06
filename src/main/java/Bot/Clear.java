package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Clear extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "clear")){
            if(args.length < 2 ){
                //not success
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(0xff3923);
                error.setTitle("Specify amount to delete");
                error.setDescription("Usage: " + Bot.prefix + "clear [# of messages]");
                event.getChannel().sendMessage(error.build()).queue();
            }else{
                try{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();
                    //success
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(0x22ff2a);
                    error.setTitle("✅ Successfully deleted " + args[1] + ".");
                    event.getChannel().sendMessage(error.build()).queue();
                }
                catch(IllegalArgumentException e){
                    if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                        //too many messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("📛 Too many messages selected");
                        error.setDescription("Betwen 1-100 messages can be deleted at once time");
                        event.getChannel().sendMessage(error.build()).queue();
                    }else{
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("📛 Selected messages are older than 2 weeks");
                        error.setDescription("Messages older than 2 weeks cannot be deleted");
                        event.getChannel().sendMessage(error.build()).queue();

                    }

                }

            }
        }
    }
}
