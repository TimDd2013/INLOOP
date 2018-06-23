/**
 * Volunteer
 */
public class Volunteer extends Employee{
    public Volunteer(String id){
        super(id);
    }
    @Override
    public double calculateDeductions() {
        return 0;
    }
    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        throw new UnpayableEmployeeException("");
    }
    @Override
    public boolean isPayday(int dayOfMonth) {
        return false;
    }
}