package studio.baka.originiumcraft.inventory.processing;

import com.google.gson.annotations.SerializedName;

import java.util.Hashtable;
import java.util.List;

public class OCProcess {
    public static class ProcessMaterial{
        @SerializedName("registryName")
        public String RegistryName;
        @SerializedName("quantity")
        public int Quantity;
    }
    @SerializedName("materials")
    public List<ProcessMaterial> Materials;
    @SerializedName("result")
    public String Result;
    @SerializedName("byproducts")
    public List<String> Byproducts;
    public Hashtable<String, Integer> getMaterialQuantityTable(){
        Hashtable<String,Integer> hashtable = new Hashtable<>();
        for (ProcessMaterial material:
             Materials) {
            hashtable.put(material.RegistryName,material.Quantity);
        }
        return hashtable;
    }
}
