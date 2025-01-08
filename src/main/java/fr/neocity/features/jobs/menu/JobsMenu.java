package fr.neocity.features.jobs.menu;

import dev.xernas.menulib.Menu;
import dev.xernas.menulib.utils.InventorySize;
import dev.xernas.menulib.utils.ItemBuilder;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class JobsMenu extends Menu {

    Player player;

    public JobsMenu(Player owner) {
        super(owner);
        this.player = owner;
    }

    @Override
    public @NotNull String getName() {
        return PlaceholderAPI.setPlaceholders(player, "§r§f%img_offset_-8%%img_test%");
    }

    @Override
    public @NotNull InventorySize getInventorySize() {
        return InventorySize.NORMAL;
    }

    @Override
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    public @NotNull Map<Integer, ItemStack> getContent() {
        Map<Integer, ItemStack> map = new HashMap<>();

        map.put(13, new ItemBuilder(this, Material.PAPER, itemMeta -> {
            itemMeta.setDisplayName("Training dungeon");
        }).setCloseButton());

        return map;
    }
}
