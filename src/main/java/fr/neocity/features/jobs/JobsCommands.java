package fr.neocity.features.jobs;

import fr.neocity.features.jobs.menu.JobsMenu;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Description;
import revxrsal.commands.annotation.Subcommand;

@Command({"job", "jobs", "j"})
@Description("command des jobs")
public class JobsCommands {

    @Subcommand("open")
    @Description("ouvre le menu des jobs")
    private void OpenJobsMenu (Player player) {
        new JobsMenu(player).open();
    }
}
