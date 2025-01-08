package fr.neocity.utils.admin;

import fr.neocity.utils.Messages.MessageType;
import fr.neocity.utils.Messages.Prefix;
import fr.neocity.utils.Messages.MessagesManager;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Description;
import revxrsal.commands.annotation.Named;
import revxrsal.commands.bukkit.annotation.CommandPermission;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AdminCommands {

    public static Map<UUID, UUID> freezeList = new HashMap<>();

    @Command("freeze")
    @Description("freeze le joueur")
    @CommandPermission("nc.admins.commands.freeze")
    private void FreezePlayer (Player sender, @Named("target") Player target){
        if (!target.isOnline()) sender.sendMessage("test");
        if (!freezeList.containsKey(target.getUniqueId())) {
            freezeList.put(target.getUniqueId(), target.getUniqueId());
            MessagesManager.sendMessageType(target,"§4Vous avez été freeze par un admin ! si vous vous déconnectez une sanction sera appliqué", Prefix.NEOCITY, MessageType.INFO, false);
        }
        else {
            MessagesManager.sendMessageType(sender,"§4" + target.getName() + "est déjà freeze", Prefix.NEOCITY, MessageType.INFO, false);
        }
    }

    @Command("unfreeze")
    @Description("unfreeze le joueur")
    @CommandPermission("nc.admins.commands.unfreeze")
    private void UnFreezePlayer (Player sender, @Named("target") Player target){
        if (!target.isOnline()){
            MessagesManager.sendMessageType(sender,"§4Ce joueur n'est pas en ligne !", Prefix.NEOCITY, MessageType.INFO, false);
            return;
        }
        if (freezeList.containsKey(target.getUniqueId())) {
            freezeList.remove(target.getUniqueId(), target.getUniqueId());
            MessagesManager.sendMessageType(target,"§4Vous avez été unfreeze par un admin !", Prefix.NEOCITY, MessageType.INFO, false);
        }
        else {
            MessagesManager.sendMessageType(sender,"§4" + target.getName() + "n'est pas déjà freeze", Prefix.NEOCITY, MessageType.INFO, false);
        }
    }

    @Command("vip give")
    @Description("donner le role vip au joueur")
    @CommandPermission("nc.admins.commands.unfreeze")
    private void playerGiveVip (Player sender, @Named("target") Player target){
        if (!target.isOnline()){
            MessagesManager.sendMessageType(sender,"§4Ce joueur n'est pas en ligne !", Prefix.NEOCITY, MessageType.INFO, false);
            return;
        }
    }
}
