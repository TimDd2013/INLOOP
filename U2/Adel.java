public class Adel extends Einwohner{
    @Override
    public int steuer() {
        if (super.steuer()<20){
            return 20;
        }
        return super.steuer();
    }
}