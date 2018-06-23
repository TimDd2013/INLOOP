import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test ISalePricingTest = new JUnit4TestAdapter(ISalePricingTest.class);
   System.out.println("ISalePricingTest");
   TestRunner.run(ISalePricingTest);
   Test PercentageDiscountPricingTest = new JUnit4TestAdapter(PercentageDiscountPricingTest.class);
   System.out.println("PercentageDiscountPricingTest");
   TestRunner.run(PercentageDiscountPricingTest);
   Test AbsoluteDiscountPricingTest = new JUnit4TestAdapter(AbsoluteDiscountPricingTest.class);
   System.out.println("AbsoluteDiscountPricingTest");
   TestRunner.run(AbsoluteDiscountPricingTest);
   Test ComplexPricingTest = new JUnit4TestAdapter(ComplexPricingTest.class);
   System.out.println("ComplexPricingTest");
   TestRunner.run(ComplexPricingTest);
   Test SaleTest = new JUnit4TestAdapter(SaleTest.class);
   System.out.println("SaleTest");
   TestRunner.run(SaleTest);
 }
}