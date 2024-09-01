package dev.bronzylobster.localrp.Commands;

import dev.bronzylobster.localrp.Completers.effclrCompleter;
import dev.bronzylobster.localrp.LocalRP;
import dev.bronzylobster.localrp.Utils.DataBase;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class effclr extends AbstractCommand{

    DataBase db;
    {
        try {
            db = new DataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public effclr(){super("effclr", new effclrCompleter());}


    @Override
    public void execute(CommandSender sender, String[] s) {
        int len = s.length;
        Player p = Bukkit.getPlayer(s[0]);
        assert p != null;
        if (len == 1) {
            db.remove(s[0]);

            Collection<PotionEffect> effs = p.getActivePotionEffects();

                    for (PotionEffect eff: effs) {
                        p.removePotionEffect(eff.getType());
                    }
        } else if (len == 2){
            db.remove(s[0], s[1]);
            p.removePotionEffect(PotionEffectType.getByName(s[1]));
        }
    }
}
