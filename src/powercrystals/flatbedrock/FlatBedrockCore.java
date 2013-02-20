package powercrystals.flatbedrock;

import powercrystals.core.updater.IUpdateableMod;
import powercrystals.core.updater.UpdateManager;
import cpw.mods.fml.common.Mod;
import net.minecraftforge.Configuration;
import net.minecraftforge.Property;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = FlatBedrockCore.modId, version = FlatBedrockCore.version, name = FlatBedrockCore.modName, dependencies = "required-after:PowerCrystalsCore")
public class FlatBedrockCore implements IUpdateableMod
{
	public static final String modId = "FlatBedrock";
	public static final String version = "1.4.6R1.0.3";
	public static final String modName = "FlatBedrock";
	public static bool reallyGenerate = false;
	
	private static FlatBedrockCore _instance;
	
	public static FlatBedrockCore instance()
	{
		return _instance;
	}
	
	@Mod.PreInit
	public void preload(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		Property doGenerate;
		doGenerate = config.get("WorldGen","reallyFlattenBedrock",true);
		reallyGenerate = doGenerate.getBool();		
	}
	
	@Init
	public void load(FMLInitializationEvent e)
	{
		_instance = this;
		
		if(reallyGenerate)
		{
		
		GameRegistry.registerWorldGenerator(new FlatBedrockWorldGen());
		
		TickRegistry.registerScheduledTickHandler(new UpdateManager(this), Side.CLIENT);
		
		}
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
