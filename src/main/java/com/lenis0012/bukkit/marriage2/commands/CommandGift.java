package com.lenis0012.bukkit.marriage2.commands;

import com.lenis0012.bukkit.marriage2.MData;
import com.lenis0012.bukkit.marriage2.MPlayer;
import com.lenis0012.bukkit.marriage2.Marriage;
import com.lenis0012.bukkit.marriage2.config.Message;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandGift extends Command {

    public CommandGift(Marriage marriage) {
        super(marriage, "gift");
        setDescription(Message.COMMAND_GIFT.toString());
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        MData marriage = mPlayer.getMarriage();
        if(marriage == null) {
            reply(Message.NOT_MARRIED);
            return;
        }

        Player partner = Bukkit.getPlayer(marriage.getOtherPlayer(player.getUniqueId()));
        if(partner == null) {
            reply(Message.PARTNER_NOT_ONLINE);
            return;
        }

        ItemStack item = player.getInventory().getItemInMainHand(); // Firestarter :: use undeprecated method
        if (item.getType() == Material.AIR) {
            reply(Message.NO_ITEM);
            return;
        }

        partner.getInventory().addItem(item.clone());
        // Firestarter start :: fix item name in chat
        player.getInventory().setItemInMainHand(null);
        String itemName = WordUtils.capitalize(item.getType().toString().toLowerCase().replace("_", " "));
        reply(Message.ITEM_GIFTED, item.getAmount(), itemName);
        reply(partner, Message.GIFT_RECEIVED, item.getAmount(), itemName);
        // Firestarter end
    }
}
