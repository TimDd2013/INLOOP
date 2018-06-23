/**
 * Paint
 */
public class Paint extends Material{
    private static double limit=0.02;
    private int noOfCoats;
    private double noOfSqMPerLiter;
    public Paint(String name,double price,int noOfCoats,double noOfSqMPerLiter){
        super(name, price);
        if (noOfCoats<=0||noOfSqMPerLiter<=0) throw new IllegalArgumentException();
        this.noOfCoats=noOfCoats;
        this.noOfSqMPerLiter=noOfSqMPerLiter;
    }
    @Override
    public int getMaterialReq(Surface s) {
        if(s==null) throw new NullPointerException();
        return (int)((s.getArea()*noOfCoats/noOfSqMPerLiter+0.48)/0.5);
    }
    /**
     * @return the noOfCoats
     */
    public int getNoOfCoats() {
        return noOfCoats;
    }
    /**
     * @return the noOfSqMPerLiter
     */
    public double getNoOfSqMPerLiter() {
        return noOfSqMPerLiter;
    }
}