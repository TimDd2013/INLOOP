/**
 * RenovatiionObject
 */
import java.util.*;
public abstract class RenovationObject {
    public abstract double getPrice();
    public abstract Map<String,Integer> addMaterialReq(Map<String,Integer> materials);
}