public class Human{
    private String forename;
    private String name;
    public static void main(String[] args){
        System.out.println(new Human("Udo", "G"));
        Human aHuman = new Human("Maximilian", "Huber");
        System.out.println("This is " + aHuman + ".");
    }

    public Human(String forename,String name){
        this.forename=forename;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public String getForename(){
        return forename;
    }
    public String toString(){
        return forename+" "+name;
    }

}