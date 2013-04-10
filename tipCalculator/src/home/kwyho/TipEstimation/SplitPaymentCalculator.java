package home.kwyho.TipEstimation;

public class SplitPaymentCalculator {
	private String state = "MD";
	private boolean smallGroup = true;
	
	public double getPrice(double subTotal) {
		double tax = getTax(subTotal);
		return (subTotal+tax);
	}
	
	public double getTax(double subTotal) {
		double foodTax = StateTaxTable.getFoodTax(state);
		return (subTotal*foodTax);
	}
	
	public double getTip(double subTotal) {
		double tipPercentage = smallGroup?0.15:0.18;
		return subTotal*tipPercentage;
	}
	
	public double getTotalPayment(double subTotal) {
		return (getPrice(subTotal)+getTip(subTotal));
	}
	
	public double getSplitPayment(double subTotal, int numPeople) {
		return (getTotalPayment(subTotal) / numPeople);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isSmallGroup() {
		return smallGroup;
	}

	public void setSmallGroup(boolean smallGroup) {
		this.smallGroup = smallGroup;
	}
	
	public SplitPaymentCalculator() {
		this("MD", false);
	}
	
	public SplitPaymentCalculator(String state, boolean smallGroup) {
		this.state = state;
		this.smallGroup = smallGroup;
	}
}
