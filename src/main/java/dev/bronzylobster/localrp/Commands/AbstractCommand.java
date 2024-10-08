package dev.bronzylobster.localrp.Commands;

import dev.bronzylobster.localrp.LocalRP;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractCommand implements CommandExecutor {

    public AbstractCommand (String name) {
        LocalRP.getInstance().getCommand(name).setExecutor(this);
    }

    public AbstractCommand(String command, TabCompleter completer) {
        PluginCommand pluginCommand = LocalRP.getInstance().getCommand(command);
        if (pluginCommand != null) {
            pluginCommand.setExecutor(this);
            pluginCommand.setTabCompleter(completer);
        }
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        execute(commandSender, strings);
        return true;
    }

    public abstract void execute(CommandSender sender, String[] s);
}
