/**
 * 
 */
package com.storyfortomorrow.core.cmdframework.cmds;

import com.storyfortomorrow.core.cmdframework.Command;
import com.storyfortomorrow.core.cmdframework.CommandArgs;
import com.storyfortomorrow.core.cmdframework.CommandListener;
import com.storyfortomorrow.core.util.Item;

/**
 * @author John
 * 		
 */
public class Test implements CommandListener
{
	@Command(name = "test", permission = "no.no.no")
	public void test(CommandArgs info)
	{
		info.getPlayer().getInventory().addItem(Item.translate(
				"Diamond Sword;1;0;&cRed Ruby Sword;&fFancy lore line 1~&cCool lore 52;Damage All,10~Fire Aspect,5;"));
	}
}
