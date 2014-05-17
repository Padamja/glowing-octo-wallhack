package k4unl.minecraft.gow.items;

import java.util.List;

import k4unl.minecraft.gow.lib.CustomTabs;
import k4unl.minecraft.gow.lib.config.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GOWItemBase extends Item {

	private String mName;
	private boolean hasEffect = false;
	private String defaultInfo = "";
	
	public GOWItemBase(String name){
		super();
		
		mName = name;
		setMaxStackSize(64);
		setUnlocalizedName(ModInfo.LID + ":" + name);
		
		setCreativeTab(CustomTabs.tabGOW);
	}
	
	
	public void setEffect(boolean _hasEffect){
		hasEffect = _hasEffect;
	}
	
	public void setEffect(ItemStack itemStack, boolean _hasEffect){
		itemStack.getTagCompound().setBoolean("hasEffect", _hasEffect);
	}
	
	@Override
	public boolean hasEffect(ItemStack itemStack){
		return hasEffect || itemStack.getTagCompound().getBoolean("hasEffect");
	}
	
	public void setDefaultInfo(String info){
		defaultInfo = info;
	}
	
	public void setDefaultInfo(ItemStack itemStack, String info){
		itemStack.getTagCompound().setString("defaultInfo", info);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4){
		list.add(defaultInfo);
		if(itemStack.getTagCompound().getString("defaultInfo") != ""){
			list.add(itemStack.getTagCompound().getString("defaultInfo"));
		}
	}
	
	
}