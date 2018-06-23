/**
 * Payroll
 */

import java.util.*;
public class Payroll {
    private PayrollDisposition disposition;
    private int payday;
    public Payroll(PayrollDisposition disposition,int payday){
        if(disposition==null) throw new NullPointerException();
        if (payday<=0||payday>31) throw new IllegalArgumentException();
        this.payday=payday;
        this.disposition=disposition;
    }
    public void doPayroll(PayrollDB db){
        if(db==null) throw new NullPointerException();
        for(Employee i:db.getEmployeeList()){
            //System.out.println("id"+i.getId()+"value"+i.calculateDeductions());     
            if (i.isPayday(payday)){
                double pay=0;
                try {
                    pay=i.calculatePay();        
                } catch (UnpayableEmployeeException e) {
                    //TODO: handle exception
                }
                double de=i.calculateDeductions();
            disposition.sendPayment(i,pay-de);   
            }
        }
    }
}