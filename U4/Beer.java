/**
 * Beer
 */
public class Beer extends Drink{
    
    private String brewery;

    public Beer(String brewery) {
        this.brewery=brewery;
    };

    /**
     * @return the brewery
     */
    public String getBrewery() {
        return brewery;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}