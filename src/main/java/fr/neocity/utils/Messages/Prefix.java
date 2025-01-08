package fr.neocity.utils.Messages;

import lombok.Getter;

/**
 * Enum representing various prefixes for messages.
 * Each prefix is associated with a formatted string using custom colors and fonts.
 */
public enum Prefix {

    // Font: https://lingojam.com/MinecraftSmallFont
    // For gradient color: https://www.birdflop.com/resources/rgb/
    // Color format: §x§r§r§g§g§b§b§l

    NEOCITY("§x§F§F§4§5§4§5ɴ§x§F§F§5§2§7§0ᴇ§x§F§F§6§0§9§Aᴏ§x§F§F§6§D§C§5ᴄ§x§C§1§7§B§C§Cɪ§x§8§2§8§A§D§4ᴛ§x§4§4§9§8§D§Bʏ"),;

    @Getter private final String prefix;
    Prefix(String prefix) {
        this.prefix = prefix;
    }
}