public class Taxi{
    private Human driver;
    private Human [] passengers;
    private int number;

    public Taxi(Human driver){
        this.driver =driver;
        passengers =new Human[4];
        number=0;
    }

    public String getDriverName(){
        return driver.toString();
    }

    public void add(Human x){
        if (number<4){
            passengers[number]=x;
            number++;
            System.out.println(x.toString()+" gets in.");
        }else{
            System.out.println("We are sorry, "+x.toString()+". The taxi is full.");
        }
    }
    public String toString(){
        String message="";
        if (number==0){
            message="nobody";
        }else if(number==1){
            message=message+passengers[0].toString();
        }else{
            for(int i=0;i<number-2;i++){
                message=message+passengers[i].toString()+", ";
            }
            message=message+passengers[number-2].toString()+" and "+passengers[number-1].toString();
        }
        return "This is the taxi of "+driver.toString()+". He takes "+message+" along.";
    }
    public Human[] allGetOut(){
        Human[] oldpassengers=passengers;
        if (number==0){
            oldpassengers=new Human[0];
            return oldpassengers;
        }
        passengers =new Human[4];
        number=0;
        return oldpassengers;
    }

}