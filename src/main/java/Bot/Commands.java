package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class Commands extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();

        //COMMAND LIST
        if(args[0].equalsIgnoreCase(Bot.prefix + "commands")) {
            EmbedBuilder role = new EmbedBuilder();
            role.setTitle("<:hacker:807330475600248833> Commands that i know: <:hacker:807330475600248833> ");
            role.addField("- - - - - - - - - - - - - - -\n" +
                            "→Hello, my name is 'Dax BOT (.)' and i am bot created by @Dax.\n I am sill learning so stfu.\n",
                      "→My primary work is updating and improving this server,\n" +
                            " you can use me by typing this command: \n" +
                            " *** <:hacker:807330475600248833>♻️🟦   have fun  🟦 ♻️<:hacker:807330475600248833> ***\n" +
                            "- - - - - - - - - - -\n"+
                            ".info \n" +
                            ".hello/hi || hello/hi <somebody> - edited\n" +
                            ".avatar <somebody>\n" +
                            ".stab <somebody>\n" +
                            ".bye || bye <somebody> - new\n" +
                            ".hug <somebody> - new\n" +
                            ".bot" , false);

            event.getChannel().sendMessage(role.build()).queue();
            role.clear();
        }


        //1 creator information
        if (args[0].equalsIgnoreCase(Bot.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Dax-BOT (.)");
            info.setDescription("Developing and improving server.           \n My prefix is (.)");
            info.addField("For my commands type: ", "`.commands`", false);
            info.setColor(0x9342f5);
            info.setImage("https://github.com/dax4y/Foto.first/blob/main/hacker-2655534-2199228.png?raw=true");
            info.setFooter("Created by Dax", "https://github.com/dax4y/Foto.first/blob/main/IMG_3902.JPG?raw=true" ); //event.getMember().getUser().getAvatarUrl()
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }

        //2 hello command
        String[] hello = {
                "Hello",
                "Hi",
                "Adios",
                "Čavelo",
                "Zdrow",
                "Fuck you",
        };
        Random rand = new Random();
        int helloRandom = rand.nextInt(hello.length);

        if (args[0].equalsIgnoreCase(Bot.prefix + "hi" ) || args[0].equalsIgnoreCase(Bot.prefix + "hello" )){
            if (args.length < 2 ) {
                //2 hello name command
                if (!event.getMember().getUser().isBot()) {
                    if(args[0].equalsIgnoreCase(Bot.prefix + "hi") || args[0].equalsIgnoreCase(Bot.prefix + "hello")){
                        event.getChannel().sendTyping().queue();
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0x99ccff);
                        error.setTitle("️<:morfTH:809116280795824198> " + hello[helloRandom] + " " + name + ".");
                        error.setImage("https://media.tenor.com/images/acc4116372dcc4b342cb1a00ae657151/tenor.gif");    //pingui
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }else{
                //3 hello someone
                if (!event.getMember().getUser().isBot()) {
                    if (args[0].equalsIgnoreCase(Bot.prefix + "hi") || args[0].equalsIgnoreCase(Bot.prefix + "hello")) {
                        event.getChannel().sendTyping().queue();
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff8533);
                        error.setTitle("<:shibaHmmm:809103770360873040> " + hello[helloRandom] + " " + args[1] + ".");
                        error.setImage("https://pandagif.com/gifs/ClekxvrYAj.gif"); //dog
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }


        //4 Stab Someone
        if (args[0].equalsIgnoreCase(Bot.prefix + "stab") && args[1].equalsIgnoreCase(args[1])) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(name +" stab 🔪🔪"  + args[1] + " 💥").queue();
        }

        //5 bot picture
        if (args[0].equalsIgnoreCase(Bot.prefix + "bot")) {
            event.getChannel().sendMessage("<:hacker:807330475600248833>").queue();
        }

        //6 hug command
        String[] hug = {
                "vymojkal",
                "objal",
                "poláskal",
                "poslal pusu",
        };
        String[] emojihug = {
                "<:pepolove:809103769454379068> ",
                "<:cahlLoved:809116012582010910> ",
                "<:otzBlush:809116359367327754> ",
                "<:shibalovepic:809109564267036722> ",
        };

        int number = rand.nextInt(hug.length);
        int emoNumber = rand.nextInt(emojihug.length);


        if (args[0].equalsIgnoreCase(Bot.prefix + "hug") && args[1].equalsIgnoreCase(args[1])) {
            event.getChannel().sendTyping().queue();
            EmbedBuilder error = new EmbedBuilder();
            error.setColor(0x99ccff);
            error.setTitle(name + " " + hug[number] + "  <:shibalovepic:809109564267036722>  " + args[1] + "a/u "+ emojihug[emoNumber] + ".");
            //error.setImage("https://media.tenor.com/images/8601403589f18983eddc14f71c80caa4/tenor.gif");
            event.getChannel().sendMessage(error.build()).queue();

        }

        //7 bye command
        String[] bye = {
                "Byeee",
                "Adios",
                "Take a rest",
        };

        int byeRandom = rand.nextInt(hug.length);

        if (args[0].equalsIgnoreCase(Bot.prefix + "bye") ){
            event.getChannel().sendTyping().queue();
            if (args.length < 2 ) {
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(0x99ccff);
                error.setTitle(bye[byeRandom] + " " + name + ".  <:otzFine:809116359031259218> ");
                error.setImage("https://media.tenor.com/images/de9af7116ae81f8d7e365015f3526ba4/tenor.gif");    //bye small boy
                event.getChannel().sendMessage(error.build()).queue();
            }else{
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(0x99ccff);
                error.setTitle(bye[byeRandom] + " " + args[1] + ".  <:morfYear:809116280233263105> ");
                error.setImage("https://media.tenor.com/images/de9af7116ae81f8d7e365015f3526ba4/tenor.gif");    //bye small boy
                event.getChannel().sendMessage(error.build()).queue();
            }
        }

    }

}
