package powercrystals.flatbedrock;

import powercrystals.core.updater.IUpdateableMod;
import powercrystals.core.updater.UpdateManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = FlatBedrockCore.modId, version = FlatBedrockCore.version, name = FlatBedrockCore.modName)
public class FlatBedrockCore implements IUpdateableMod
{
	public static final String modId = "FlatBedrock";
	public static final String version = "1.4.6R1.0.1";
	public static final String modName = "FlatBedrock";
	
	private static FlatBedrockCore _instance;
	
	public static FlatBedrockCore instance()
	{
		return _instance;
	}
	
	@Init
	public void load(FMLInitializationEvent e)
	{
		_instance = this;
		
		GameRegistry.registerWorldGenerator(new FlatBedrockWorldGen());
		
		TickRegistry.registerScheduledTickHandler(new UpdateManager(this), Side.CLIENT);
	}

	@Override
	public String getModId()
	{
		return modId;
	}

	@Override
	public String getModName()
	{
		return modName;
	}

	@Override
	public String getModFolder()
	{
		return modId;
	}

	@Override
	public String getModVersion()
	{
		return version;
	}
}
