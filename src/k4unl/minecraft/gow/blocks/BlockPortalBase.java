package k4unl.minecraft.gow.blocks;

import k4unl.minecraft.gow.GlowingOctoWallHack;
import k4unl.minecraft.gow.items.ItemIPCard;
import k4unl.minecraft.gow.lib.CustomTabs;
import k4unl.minecraft.gow.lib.config.GuiIDS;
import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPortalBase extends GOWBlockRendering {

	protected BlockPortalBase() {
		super(Names.portalBase);
		setCreativeTab(CustomTabs.tabGOW);
	}

	@Override
	protected Class<? extends TileEntity> getTileEntity() {
		return TilePortalBase.class;
	}
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		if(player.isSneaking()){
			return false;
		}
		
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity == null || !(entity instanceof TilePortalBase)){
			return false;
		}
		
		if(player.getCurrentEquippedItem() != null){
			if(player.getCurrentEquippedItem().getItem() instanceof ItemIPCard){
				return false;
			}
			if(player.getCurrentEquippedItem().getItem() instanceof ItemDye){
				//Dye that shit!
				if(((TilePortalBase)entity).getIsValid()){
					((TilePortalBase)entity).dye(~player.getCurrentEquippedItem().getItemDamage() & 15);
				}
				return false;
			}
		}
		
		if(((TilePortalBase)entity).getIsValid()){
			player.openGui(GlowingOctoWallHack.instance, GuiIDS.GUIPortalBase, world, x, y, z);
		}else{
			return false;
		}
		return true;
	}
}
