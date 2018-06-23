import java.util.*;

/**
 * VehicleQueue
 */
public class VehicleQueue implements Observer{
    private VehicleGenerator generator;
    private List<Vehicle> queue;
    private double entryDelay;
    private double exitDelay;
    private int trafficLightRate;
    private boolean greenLight=false;

    private int oldin=0;
    private int oldout=0;
    public VehicleQueue(double entryDelay,double exitDelay,int trafficLightRate,VehicleGenerator generator){
        if(entryDelay<=0||exitDelay<=0||trafficLightRate<=0) throw new IllegalArgumentException();
        if(generator==null) throw new NullPointerException();
        this.entryDelay=entryDelay;
        this.exitDelay=exitDelay;
        this.trafficLightRate=trafficLightRate;
        this.generator=generator;
        queue=new ArrayList<Vehicle>();
    }
    public void enter(){
        queue.add(generator.createVehicle());
    }
    public void leave(){
        if(queue.size()==0){
            return;
        }
        queue.remove(0);
    }
    public double getLength(){
        double result=0;
        for (Vehicle ve: queue){
            result+=ve.getLength();
        }
        return result;
    }
    public int getSize(){
        return queue.size();
    }
    @Override
    public void update(Observable o, Object arg) {
        //o.notifyObservers(arg);
        if(arg==null) throw new IllegalArgumentException();
        int time=0;
        if (arg instanceof Integer) {
            time = (Integer) arg;
        }
        int many =time/trafficLightRate;
        int in=0;
        int out=0;
        if(many%2==0){
            out=many/2*(int)(trafficLightRate/exitDelay);
            in=(int)(((many)*(trafficLightRate)+(time%trafficLightRate))/entryDelay);
        }else{
            in=(int)(((many)*(trafficLightRate)+(time%trafficLightRate))/entryDelay);
            out=many/2*(int)(trafficLightRate/exitDelay)+(int)(time%trafficLightRate/exitDelay);
        };
        for(int i=oldin;i<in;i++){
            enter();
        }
        for(int i=oldout;i<out;i++){
            leave();
        }
        oldin=in;
        oldout=out;
        /*
        if(exitDelay<entryDelay/2){
            time=time%(2*trafficLightRate);
        }
        int many =time/trafficLightRate;
        int in=0;
        int out=0;
        if(many%2==0){
            out=many/2*(int)(trafficLightRate/exitDelay);
            in=(int)(((many)*(trafficLightRate)+(time%trafficLightRate))/entryDelay);
        }else{
            in=(int)(((many)*(trafficLightRate)+(time%trafficLightRate))/entryDelay);
            out=many/2*(int)(trafficLightRate/exitDelay)+(int)(time%trafficLightRate/exitDelay);
        };
        
        System.out.println("many"+many+"time"+time+"in"+in+"out"+out);
        System.out.println("size"+getSize());
        int size=getSize();
        int def=in-out-size;
        if(((def)>0)){
            for(int i=0;i<def;i++){
                enter();
                int a=in-out-getSize();
                //System.out.println("次数"+getSize()+"in-out"+a);
            };
        }
        else if((size==0)){
            enter();
            leave();
        }
        else if(in-out-getSize()<0){
            int b=out+getSize()-in;
            for(int i=0;i<b;i++){
                //int b=out+getSize()-in;
                System.out.println("mal"+getSize()+"out-in"+b);
                leave();
            };
        }
        */
    }
}