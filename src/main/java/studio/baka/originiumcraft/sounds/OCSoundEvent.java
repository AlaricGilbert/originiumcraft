package studio.baka.originiumcraft.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import studio.baka.originiumcraft.util.ReferenceConsts;

public class OCSoundEvent extends SoundEvent {
    public OCSoundEvent(String name) {
        super(new ResourceLocation(ReferenceConsts.MODID,name));
        setRegistryName(new ResourceLocation(ReferenceConsts.MODID,name));
        OCSounds.SOUND_EVENTS.add(this);
    }
}
