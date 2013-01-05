package powercrystals.flatbedrock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = FlatBedrockCore.modId, version = FlatBedrockCore.version, name = "FlatBedrock")
public class FlatBedrockCore
{
	public static final String modId = "FlatBedrock";
	public static final String version = "1.4.6R1.0.0";
	
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
		
	}
}
