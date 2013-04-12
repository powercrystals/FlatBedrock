package powercrystals.flatbedrock;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import powercrystals.core.mod.BaseMod;
import powercrystals.core.updater.IUpdateableMod;
import powercrystals.core.updater.UpdateManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = FlatBedrockCore.modId, version = FlatBedrockCore.version, name = FlatBedrockCore.modName, dependencies = "required-after:PowerCrystalsCore")
public class FlatBedrockCore extends BaseMod implements IUpdateableMod
{
	public static final String modId = "FlatBedrock";
	public static final String version = "1.5.1R1.1.0";
	public static final String modName = "FlatBedrock";
	public static boolean doFlatten = false;
	
	private static FlatBedrockCore _instance;
	
	public static FlatBedrockCore instance()
	{
		return _instance;
	}
	
	@Mod.PreInit
	public void preload(FMLPreInitializationEvent e)
	{
		setConfigFolderBase(e.getModConfigurationDirectory());
		
		Configuration config = new Configuration(getCommonConfig());
		config.load();
		Property doGenerate;
		doGenerate = config.get("WorldGen","reallyFlattenBedrock",true);
		doFlatten = doGenerate.getBoolean(true);		
	}
	
	@Init
	public void load(FMLInitializationEvent e)
	{
		_instance = this;
		
		if(doFlatten)
		{
			GameRegistry.registerWorldGenerator(new FlatBedrockWorldGen());
		}
		
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
	public String getModVersion()
	{
		return version;
	}
}
