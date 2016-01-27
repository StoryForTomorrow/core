package com.storyfortomorrow.core.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Item.newI("DIAMOND_SWORD;");
 * 
 * @author John
 * 		
 */
public class Item
{
	/**
	 * Item; Amount; Durability; Name; Lore1~Lore2~Etc.;
	 * Enchantment,Level~Enchantment2,Level2~Etc.;
	 * 
	 * <p>
	 * Example:
	 * </p>
	 * 
	 * Diamond Sword; 1; 0; &cRed Ruby Sword; &fFancy lore line 1~&cCool lore
	 * 52; Damage All,10~Fire Aspect,5;
	 * 
	 * @param t
	 * @return
	 */
	public static ItemStack translate(String t)
	{
		System.out.println(t);
		String[] s = t.split(";");
		for (String sa : s)
			System.out.println(sa);
		String item = s[0].toUpperCase().replace(" ", "_").trim();
		Integer amount = Integer.parseInt(s[1].trim());
		Integer durability = Integer.parseInt(s[2].trim());
		String name = s[3].trim();
		String[] lore = s[4].trim().split("~");
		String[] enchantments = s[5].trim().split("~");
		HashMap<String, Integer> levels = new HashMap<String, Integer>();
		for (String s2 : enchantments)
		{
			String[] el = s2.trim().split(",");
			levels.put(el[0].toUpperCase().replace(" ", "_"), Integer.parseInt(el[1].trim()));
		}
		
		ItemStack item_object = new ItemStack(Material.valueOf(item));
		item_object.setAmount(amount);
		item_object.setDurability(durability.shortValue());
		for (String e : levels.keySet())
			item_object.addUnsafeEnchantment(Enchantment.getByName(e), levels.get(e));
			
		ItemMeta meta = item_object.getItemMeta();
		meta.setDisplayName(C.f(name));
		ArrayList<String> ll = new ArrayList<String>();
		for (String l : lore)
			ll.add(C.f(l));
		meta.setLore(ll);
		item_object.setItemMeta(meta);
		
		return item_object;
	}
}
