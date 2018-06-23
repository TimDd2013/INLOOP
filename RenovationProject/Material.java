/**
 * Material
 */
public abstract class Material {
    private String name;
    private double price;
    public Material(String name,double price){
        if (name==null) throw new NullPointerException();
        if (price<=0 ||name=="") throw new IllegalArgumentException();
        this.name=name;
        this.price=price;
    }    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the price
     */
    public double getPricePerUnit() {
        return price;
    }
    public abstract int getMaterialReq(Surface s);
    public double getPriceOfASurface(Surface s){
        if(s==null) throw new NullPointerException();
        return getMaterialReq(s)*this.price;
    };
}