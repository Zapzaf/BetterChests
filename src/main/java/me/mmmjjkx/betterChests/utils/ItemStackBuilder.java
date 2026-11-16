package me.mmmjjkx.betterChests.utils;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Getter
public class ItemStackBuilder {
    private final ItemStack itemStack;

    public ItemStackBuilder(Material material, Consumer<ItemMeta> metaConsumer) {
        itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        metaConsumer.accept(itemMeta);
        itemStack.setItemMeta(itemMeta);
    }

    public ItemStackBuilder(ItemStack itemStack, Consumer<ItemMeta> metaConsumer) {
        this.itemStack = itemStack;
        ItemMeta itemMeta = itemStack.getItemMeta();
        metaConsumer.accept(itemMeta);
        itemStack.setItemMeta(itemMeta);
    }

    public ItemStackBuilder(Material material, String displayName, String... lore) {
        itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(displayName));
        itemMeta.setLore(Stream.of(lore).map(ItemStackBuilder::color).toList());
        itemStack.setItemMeta(itemMeta);
    }

    public ItemStackBuilder(Material material, String displayName, List<String> lore) {
        this.itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(displayName));
        itemMeta.setLore(lore.stream().map(ItemStackBuilder::color).toList());
        itemStack.setItemMeta(itemMeta);
    }

    public ItemStackBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    private static String color(String s) {
        return s == null ? null : ChatColor.translateAlternateColorCodes('&', s);
    }
}
