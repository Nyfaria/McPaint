package ichttt.mods.mcpaint;

import net.minecraftforge.common.config.Config;

@Config(modid = MCPaint.MODID)
public class MCPaintConfig {
    @Config.Comment("Client-Only options")
    public static final Client CLIENT = new Client();

    public static class Client {

        @Config.Comment("True if stamps should set the picture directly instead of opening the GUI")
        public boolean directApplyStamp = false;

        @Config.Comment("True to allow MCPaint to optimize picture draw calls in the background to improve performance in the long run")
        public boolean optimizePictures = true;
    }
}
