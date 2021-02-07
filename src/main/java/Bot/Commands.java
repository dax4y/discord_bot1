package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();

        //
        if(args[0].equalsIgnoreCase(Bot.prefix + "commands")) {
            EmbedBuilder role = new EmbedBuilder();
            role.setTitle("<:hacker:807330475600248833> Commands that i know: <:hacker:807330475600248833> ");
            role.addField("- - - - - - - - - - - - - - -\n" +
                            "→Hello, my name is 'Dax BOT (.)' and i am bot created by @Dax.\n I am sill learning so stfu.\n",
                      "→My primary work is updating and improving this this server,\n" +
                            " you can use me by typing this command: \n" +
                            " *** <:hacker:807330475600248833>♻️🟦   have fun  🟦 ♻️<:hacker:807330475600248833> ***\n" +
                            "- - - - - - - - - - -\n"+
                            ".info \n" +
                            ".hello/hi \n" +
                            ".hello/hi <somebody> \n" +
                            ".avatar <somebody>\n" +
                            ".stab <somebody>\n" +
                            ".bot" , false);

            event.getChannel().sendMessage(role.build()).queue();
            role.clear();
        }


        //role info
        if(args[0].equalsIgnoreCase(Bot.prefix + "use")) {
            EmbedBuilder role = new EmbedBuilder();
            role.setTitle("→Role activation: ");
            role.addField("- - - - - - - - - - - - - - -\n" +
                            "→Hello guys in this section we will make some crazy stuff.",
                      "→The only thing you have to do is to click with the \n" +
                            " right button on this post and select out of these roles \n" +
                            " which you want to have. ✅\n" +
                              "-\n"+
                            "<:crewmatee:807411213754957864>"+" : crew mate\n" +
                              "-\n"+
                            "<:amoungus:807352151214129182>"+" : impostor\n" +
                              "-\n"+
                            "<:tudom:807059533062471790>"+" : troll\n" +
                              "-\n"+
                            "<:kekw:807414953585410089>"+" : autism\n" +
                              "-\n"+
                            "<:200iq:807351737177866250>"+" : 200iq" , false);

            event.getChannel().sendMessage(role.build()).queue();
            role.clear();
        }

        //1 creator info
        if (args[0].equalsIgnoreCase(Bot.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Dax-BOT (.)");
            info.setDescription("Developing and improving server.           \n My prefix is (.)");
            info.addField("Creator", "jda java", false);
            info.setColor(0x9342f5);
            info.setImage("https://github.com/dax4y/Foto.first/blob/main/hacker-2655534-2199228.png?raw=true");
            info.setFooter("Created by Dax", "https://github.com/dax4y/Foto.first/blob/main/IMG_3902.JPG?raw=true" ); //event.getMember().getUser().getAvatarUrl()
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }

        //2 hello command
        if (args[0].equalsIgnoreCase(Bot.prefix + "hi" ) || args[0].equalsIgnoreCase(Bot.prefix + "hello" )){
            if (args.length < 2 ) {
                //2 hello name command
                if (!event.getMember().getUser().isBot()) {
                    if(args[0].equalsIgnoreCase(Bot.prefix + "hi")){
                        event.getChannel().sendTyping().queue();
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0x99ccff);
                        error.setTitle("🙋‍️ Helloo " + name + ".");
                        error.setImage("https://media.tenor.com/images/acc4116372dcc4b342cb1a00ae657151/tenor.gif");
                        event.getChannel().sendMessage(error.build()).queue();
                    }else if(args[0].equalsIgnoreCase(Bot.prefix + "hello")) {
                        event.getChannel().sendTyping().queue();
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0x99ccff);
                        error.setTitle("🙋‍️ Hi " + name + ".");
                        error.setImage("https://media.tenor.com/images/acc4116372dcc4b342cb1a00ae657151/tenor.gif");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }else{
                //3 hello someone
                if (!event.getMember().getUser().isBot()) {
                    if (args[0].equalsIgnoreCase(Bot.prefix + "hi")) {
                        event.getChannel().sendTyping().queue();
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff8533);
                        error.setTitle("🔪 Hello  " + args[1] + ".");
                        error.setImage("https://media.tenor.com/images/2ef18a7ae12bd7ddf98d8c071a5c8640/tenor.gif");
                        event.getChannel().sendMessage(error.build()).queue();
                    } else if (args[0].equalsIgnoreCase(Bot.prefix + "hello")) {
                        event.getChannel().sendTyping().queue();
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff8533);
                        error.setTitle("🔪 Hi  " + args[1] + ".");
                        error.setImage("https://media.tenor.com/images/2ef18a7ae12bd7ddf98d8c071a5c8640/tenor.gif");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }


        //4 funny eat
        if (args[0].equalsIgnoreCase(Bot.prefix + "stab") && args[1].equalsIgnoreCase(args[1])) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(name +" stab 🔪🔪"  + args[1] + " 💥").queue();
        }

        //5 test
        if (args[0].equalsIgnoreCase(Bot.prefix + "bot")) {
            event.getChannel().sendMessage("<:hacker:807330475600248833>").queue();
        }



    }


}
