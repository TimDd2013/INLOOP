import java.util.Random;

/**
 * VehicleGenerator
 */
public class VehicleGenerator {
    private Random randomGenerator;
    public VehicleGenerator(){
        randomGenerator=new Random();
    }
    public Vehicle createVehicle(){
        int r=randomGenerator.nextInt(3);
        if(r==0) return new Car();
        if(r==1) return new Bus();
        if(r==2) return new Bicycle();
        throw new NullPointerException();
    }
}