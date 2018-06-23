/**
 * Serf
 */
public class Serf extends Peasant{
    @Override
    public int taxableIncome() {
        if (super.taxableIncome()<12)
        {
            return 0;}
        return super.taxableIncome()-12;
    }
    
}