package fr.neocity.utils.rank;

import fr.neocity.utils.Messages.MessageType;
import fr.neocity.utils.Messages.Prefix;
import fr.neocity.utils.Messages.MessagesManager;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Description;
import revxrsal.commands.annotation.Named;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

import java.sql.SQLException;
import java.util.Objects;

@Command({"rank", "ranks", "grades", "grade", "r"})
@Description("command des ranks")
public class RankCommand {

    @Subcommand("set")
    @Description("définit le rank d'une personne")
    @CommandPermission("nc.admins.commands.*.set")
    private void setRank (Player sender,@Named("target") Player target, @Named("rank") String rank) throws SQLException {
        if (rank==null){
            MessagesManager.sendMessageType(sender, MessagesManager.Message.MISSINGARGUMENT.getMessage(), Prefix.NEOCITY, MessageType.ERROR, false);
            return;
        }
        if (Objects.equals(RankManager.getRank(target.getUniqueId()), rank)){
            MessagesManager.sendMessageType(sender,"§4" + target.getName() + " possède déjà ce rank", Prefix.NEOCITY, MessageType.ERROR, false);
            return;
        }
        RankManager.addRank(target.getUniqueId(), rank);
        MessagesManager.sendMessageType(sender,rank + " donner à " + target.getName() , Prefix.NEOCITY, MessageType.SUCCESS, false);
    }

    @Subcommand("remove")
    @Description("définit le rank d'une personne")
    @CommandPermission("nc.admins.commands.*.remove")
    private void removeRank (Player sender,@Named("target") Player target) throws SQLException {
        if (RankManager.getRank(target.getUniqueId())!=null){
            MessagesManager.sendMessageType(sender,"§4" + target.getName() + " ne possède aucun rank", Prefix.NEOCITY, MessageType.ERROR, false);
            return;
        }
        String rank = RankManager.getRank(target.getUniqueId());
        RankManager.removeRank(target.getUniqueId());
        MessagesManager.sendMessageType(sender,rank + " a été retirer à " + target.getName() , Prefix.NEOCITY, MessageType.SUCCESS, false);
    }
}
