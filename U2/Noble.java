/**
 * Noble
 */
public class Noble extends Inhabitant{
    @Override
    public int tax() {
        if (super.tax()<20)
        {return 20;}
        return super.tax();
    }
}