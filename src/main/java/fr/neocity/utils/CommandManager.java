package fr.neocity.utils;

import fr.neocity.NeoCity;
import fr.neocity.features.jobs.JobsCommands;
import fr.neocity.features.nickname.NickNameCommands;
import fr.neocity.utils.admin.AdminCommands;
import fr.neocity.utils.rank.RankCommand;
import lombok.Getter;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class CommandManager {
    @Getter static CommandManager instance;
    @Getter static BukkitCommandHandler handler;

    public CommandManager() {
        instance = this;
        NeoCity plugin = NeoCity.getInstance();
        handler = BukkitCommandHandler.create(plugin);

        registerSuggestions();
        registerCommands();
    }

    private void registerCommands() {
        handler.register(
                new AdminCommands(),
                new NickNameCommands(),
                new JobsCommands(),
                new RankCommand()
        );
    }

    private void registerSuggestions() {}
}

