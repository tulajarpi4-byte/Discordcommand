package hu.discordcommand;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class DiscordCommand extends JavaPlugin implements CommandExecutor {

    private static final String DISCORD_URL = "https://discord.gg/3AGPHaB2WE";

    @Override
    public void onEnable() {
        getLogger().info("DiscordCommand enabled!");

        if (getCommand("dc") != null) {
            getCommand("dc").setExecutor(this);
        }

        if (getCommand("discord") != null) {
            getCommand("discord").setExecutor(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("DiscordCommand disabled!");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        Component message = Component.text()
            .append(Component.text("Discord ", NamedTextColor.BLUE).decorate(TextDecoration.BOLD))
            .append(Component.text("» ", NamedTextColor.DARK_GRAY))
            .append(Component.text("Kattints ide: ", NamedTextColor.WHITE))
            .append(Component.text("[ DISCORD MEGNYITÁSA ]", NamedTextColor.AQUA)
                .decorate(TextDecoration.BOLD)
                .clickEvent(ClickEvent.openUrl(DISCORD_URL)))
            .build();

        player.sendMessage(message);
        return true;
    }
}
