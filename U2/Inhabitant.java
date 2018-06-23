/**
 * Inhabitant
 */
public class Inhabitant {
  protected int income;
  public int taxableIncome() { return income; }
  public int tax() {
    if (taxableIncome() < 10) {
      return 1;
    }
    return taxableIncome() / 10;
  }
  /**
   * @param income the income to set
   */
  public void setIncome(int income) { this.income = income; }
  /**
   * @return the income
   */
  public int getIncome() { return income; }
}
