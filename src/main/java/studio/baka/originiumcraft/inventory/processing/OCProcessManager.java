package studio.baka.originiumcraft.inventory.processing;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;
import scala.actors.threadpool.Arrays;
import studio.baka.originiumcraft.OriginiumCraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class OCProcessManager {
    private static final List<OCProcess> processOneMaterial = new ArrayList<>();
    private static final List<OCProcess> processTwoMaterial = new ArrayList<>();
    private static final List<OCProcess> processThreeMaterial = new ArrayList<>();

    public static void register(String modId) {
        ResourceLocation processFileLocation = new ResourceLocation(modId + ":processes/processes.json");
        try {
            Gson gson = new Gson();
            InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(processFileLocation).getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            List<OCProcess> processes = Arrays.asList(gson.fromJson(reader, OCProcess[].class));
            registerAll(processes);
        } catch (IOException e) {
            OriginiumCraft.logger.error("Failed to load process recipes for \"" + modId + "\"");
            OriginiumCraft.logger.error(e);
        }
    }

    public static void register(OCProcess process) {
        switch (process.Materials.size()) {
            case 1:
                processOneMaterial.add(process);
                break;
            case 2:
                processTwoMaterial.add(process);
                break;
            case 3:
                processThreeMaterial.add(process);
                break;
            default:
                OriginiumCraft.logger.error("Unexpected OCProcess with " + process.Materials.size() + " type of material cannot be loaded.");
                break;
        }
    }

    public static void registerAll(List<OCProcess> processes) {
        for (OCProcess process :
                processes) {
            register(process);
        }
    }

    public static OCProcess tryMatch(ItemStackHandler itemStackHandler) {
        int materialCount = 0;
        List<String> currentRegistryNames = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (!itemStackHandler.getStackInSlot(i).isEmpty()) {
                materialCount++;
                currentRegistryNames.add(itemStackHandler.getStackInSlot(i).getItem().getRegistryName().toString());
            }
        }
        switch (materialCount) {
            case 1:
                return tryMatch(currentRegistryNames, processOneMaterial);
            case 2:
                return tryMatch(currentRegistryNames, processTwoMaterial);
            case 3:
                return tryMatch(currentRegistryNames, processThreeMaterial);
            default:
                return null;
        }
    }

    public static boolean canExactMatch(ItemStackHandler itemStackHandler, OCProcess process) {
        int materialCount = 0;
        Hashtable<String, Integer> current = new Hashtable<>();
        for (int i = 0; i < 3; i++) {
            if (!itemStackHandler.getStackInSlot(i).isEmpty()) {
                materialCount++;
                current.put(itemStackHandler.getStackInSlot(i).getItem().getRegistryName().toString(),
                        new Integer(itemStackHandler.getStackInSlot(i).getCount()));
            }
        }
        for (OCProcess.ProcessMaterial material : process.Materials
        ) {
            if (!current.containsKey(material.RegistryName) || current.get(material.RegistryName) < material.Quantity)
                return false;
        }
        return true;
    }

    private static OCProcess tryMatch(List<String> currentMaterialRegistryNames, List<OCProcess> processList) {
        for (OCProcess process :
                processList) {
            if (match(currentMaterialRegistryNames, process))
                return process;
        }
        return null;
    }

    private static boolean match(List<String> currentMaterialRegistryNames, OCProcess process) {
        List<String> requiredMaterialNameList = new ArrayList<>();
        for (OCProcess.ProcessMaterial material :
                process.Materials) {
            requiredMaterialNameList.add(material.RegistryName);
        }
        return currentMaterialRegistryNames.containsAll(requiredMaterialNameList);
    }
}
