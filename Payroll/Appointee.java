/**
 * Appointee
 */
public class Appointee extends Employee{
    private int dayOfMonth;
    private int hoursPerMonth;
    private double payPerHour;
    public Appointee(String id,int dayOfMonth,int hoursPerMonth,double payPerHour){
        super(id);
        if (dayOfMonth>31||dayOfMonth<=0||payPerHour<=0||hoursPerMonth<=0) throw new IllegalArgumentException();
        this.dayOfMonth=dayOfMonth;
        this.hoursPerMonth=hoursPerMonth;
        this.payPerHour=payPerHour;
    }
    @Override
    public double calculateDeductions() {
        return 0.4*hoursPerMonth*payPerHour;
    }
    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        return hoursPerMonth*payPerHour;
    }
    @Override
    public boolean isPayday(int dayOfMonth) {
        if (this.dayOfMonth==dayOfMonth) return true;
        return false;
    }
}