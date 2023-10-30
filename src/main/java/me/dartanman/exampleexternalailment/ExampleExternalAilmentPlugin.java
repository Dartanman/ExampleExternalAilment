package me.dartanman.exampleexternalailment;

import me.dartanman.ailments.AilmentsAPI;
import me.dartanman.ailments.ailments.Ailment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ExampleExternalAilmentPlugin extends JavaPlugin implements Listener
{

    @Override
    public void onEnable()
    {
        // Only work if Ailments exists
        if(getServer().getPluginManager().getPlugin("Ailments") == null)
        {
            getLogger().severe("Ailments not found! This plugin will not work properly!");
            return;
        }

        // Make sure to register your Ailments
        AilmentsAPI api = AilmentsAPI.getAPI();
        api.registerAilment(new ExampleAilment());

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        AilmentsAPI api = AilmentsAPI.getAPI();
        Ailment ailment = api.getAilment(ExampleAilment.AILMENT_NAME);
        // Give this Ailment to all Players when they join
        // In a real plugin, you wouldn't do this. It would be a random chance on a scheduler, or perhaps in a different event (e.g. Rabies when a wolf bites you)
        ailment.infect(event.getPlayer());
    }

}
