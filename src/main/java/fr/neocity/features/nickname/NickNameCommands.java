package fr.neocity.features.nickname;

import fr.neocity.utils.Messages.MessageType;
import fr.neocity.utils.Messages.Prefix;
import fr.neocity.utils.Messages.MessagesManager;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Description;
import revxrsal.commands.annotation.Named;

public class NickNameCommands {
    @Command("name set")
    @Description("change le nom du joueur")
    private void onNameSet (Player sender, @Named("name") String name){
        if (name==null){
            MessagesManager.sendMessageType(sender, MessagesManager.Message.MISSINGARGUMENT.getMessage(), Prefix.NEOCITY, MessageType.ERROR, false);
            return;
        }
        if (sender.getDisplayName().equals(name)){
            MessagesManager.sendMessageType(sender,"§4Vous portez déjà ce nom", Prefix.NEOCITY, MessageType.INFO, false);
            return;
        }
        sender.setDisplayName(name);
        sender.setPlayerListName(name);
        MessagesManager.sendMessageType(sender,"Votre nom a été changer en : " + name, Prefix.NEOCITY, MessageType.SUCCESS, false);
    }

    @Command("name reset")
    @Description("change le nom du joueur sur celui de base")
    private void onNameReset (Player sender){
        if (!sender.getDisplayName().equals(sender.getName())){
            sender.setDisplayName(sender.getName());
            sender.setPlayerListName(sender.getName());
            MessagesManager.sendMessageType(sender,"Votre nom a été remis a celui de base :" + sender.getName(), Prefix.NEOCITY, MessageType.SUCCESS, false);
            return;
        }
        MessagesManager.sendMessageType(sender,"§4Votre nom est déjà définit sur celui de base ", Prefix.NEOCITY, MessageType.ERROR, false);
    }
}
