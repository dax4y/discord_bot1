package Bot;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;


public class RoleReactions extends ListenerAdapter {

    final long channelIDP = 806591609789218829L;
    final long channelID =807352353421787146L; //pupkoši

    //final long roleID = 807318884990189648L;
    HashMap<Long, Long> reactionToRoleID = new HashMap<>();


    public RoleReactions (){
        //reactionToRoleID.put(emoji , role);
        reactionToRoleID.put(807330475600248833L, 806849393889247252L); //hacker member
        reactionToRoleID.put(807336342404726814L, 807326049456357429L);  //fizz impostor

        //pupkoši
        reactionToRoleID.put(807352151214129182L, 807352934202998854L);  //impostor impostor
        reactionToRoleID.put(807351737177866250L, 807352972988121088L);  //200iq 200iq
        reactionToRoleID.put(807059533062471790L, 807353114893090857L);  //matovic troll
        reactionToRoleID.put(807414953585410089L, 807411900174172160L);  //kekw autism
        reactionToRoleID.put(807411213754957864L, 807372464312811540L);  //crew crewmate
    }

    @Override
    public void onGuildMessageReactionAdd( GuildMessageReactionAddEvent e) {
        if ((e.getChannel().getIdLong() == channelID) || (e.getChannel().getIdLong() == channelIDP)) {
            //System.out.println(e.getReactionEmote().getIdLong());
            Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
            if(roleID == null){
                return;
            }
            e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e){
        if ((e.getChannel().getIdLong() == channelID) || (e.getChannel().getIdLong() == channelIDP)) {
            Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
            if(roleID == null){
                return;
            }
            e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();
        }
    }
}
