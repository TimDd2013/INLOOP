/**
 * Surface
 */

import java.util.*;
public class Surface extends RenovationObject{
    private double length;
    private double width;
    private Material selectedMaterial;
    public Surface(double length,double width){
        if(length<=0||width<=0) throw new IllegalArgumentException();
        this.length=length;
        this.width=width;
    }
    public void setMaterial(Material m){
        if(m==null) throw new NullPointerException();
        this.selectedMaterial=m;
    }
    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }
    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }
    public double getArea(){
        return length*width;
    }
    public double getPrice(){
        return selectedMaterial.getPriceOfASurface(this);
    }
    public Map<String,Integer> addMaterialReq(Map<String,Integer> materials){
        if(materials==null) throw new NullPointerException();
        if (materials.equals(new HashMap<String,Integer>())){
            materials.put(selectedMaterial.getName(), selectedMaterial.getMaterialReq(this));
        }else{
            for(String s:materials.keySet()){
                if (s==null) throw new NullPointerException();
            }
            for(Integer i:materials.values()){
                if (i==null) throw new NullPointerException();
            }
            if(materials.containsKey(selectedMaterial.getName())){
                materials.replace(selectedMaterial.getName(), materials.get(selectedMaterial.getName())+selectedMaterial.getMaterialReq(this));
            }else{
                materials.put(selectedMaterial.getName(), selectedMaterial.getMaterialReq(this));
            }
        }
        return materials;
    }
}