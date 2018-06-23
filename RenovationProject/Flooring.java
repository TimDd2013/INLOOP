/**
 * Flooring
 */
public class Flooring extends Material{
    private static double limit=0.02;
    private double widthOfFlooring;
    public Flooring(String name,double price,double width){
        super(name, price);
        if(width<=0) throw new IllegalArgumentException();
        this.widthOfFlooring=width;
    } 
    @Override
    public int getMaterialReq(Surface s) {
        if(s==null) throw new NullPointerException();
        return (int)(s.getArea()/widthOfFlooring+0.98);
    }
    public double getWidth(){
        return widthOfFlooring;
    }
}