package me.dartanman.exampleexternalailment;

import me.dartanman.ailments.ailments.Ailment;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExampleAilment extends Ailment
{

    // You can hard-code this if you want, but this makes it statically readable elsewhere
    public static final String AILMENT_NAME = "Example Ailment";

    // Name and symptoms
    public ExampleAilment()
    {
        super(AILMENT_NAME);
        symptoms.add("An example symptom");
        symptoms.add("More symptoms here");
        symptoms.add("This is a symptom of this ailment");
    }

    // This runs every 10 seconds
    @Override
    public void effect(Player player)
    {
        player.sendMessage("This is the repeating effect of Example Ailment!");
    }

    // This is what happens when a player is cured of the Ailment
    @Override
    public void cureActions(Player player)
    {
        player.sendMessage("You were cured of Example Ailment!");
    }

    // Create the cure item
    // You'll have to make your own Crafting recipe(s), but the Ailments plugin will handle the
    // the permission automatically.
    @Override
    public ItemStack getCureItem()
    {
        ItemStack item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + "Magic Emerald");
        item.setItemMeta(meta);
        return item;
    }

    // This is what happens when a player uses the cure item but doesn't have the corresponding ailment
    @Override
    public void wrongCureEffect(Player player)
    {
        player.sendMessage("You don't have Example Ailment!");
    }
}
