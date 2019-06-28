package studio.baka.originiumcraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OCEntities {
    public static final List<Tuple<Class<? extends  Entity>,EntityRegistryProperties>> ENTITIYCLASSES = new ArrayList<>(
            Arrays.asList(
                    new Tuple<>(EntityOriginiumInsect.class,EntityOriginiumInsect.REGISTRY_PROPERTIES)
            )
    );
}
