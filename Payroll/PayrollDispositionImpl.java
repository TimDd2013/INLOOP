/**
 * PayrollDispositionImpl
 */
import java.util.*;
public class PayrollDispositionImpl implements PayrollDisposition{
    private Map<Employee,Double> payments;
    public PayrollDispositionImpl(){
        payments=new HashMap<Employee,Double>();
    }
    public double getTotal(){
        double re=0;
        for(Double pa:payments.values()){
            re+=pa;
        }
        return re;
    }
    public double getAverage(){
        if (getTotal()==0) return 0;
        return getTotal()/payments.size();
    }
    public Map<Employee,Double> getPayments(){
        return payments;
    }
    @Override
    public void sendPayment(Employee empl, double payment) {
        if(payment<=0) throw new IllegalArgumentException();
        if(empl==null) throw new NullPointerException();
        payments.put(empl,payment);
    }
}