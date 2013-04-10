package home.kwyho.TipEstimation;

import java.util.HashMap;
import java.util.Map;

public class StateTaxTable {
	private static Map<String, Double> foodTaxes;
	
	static {
		foodTaxes = new HashMap<String, Double>();
		foodTaxes.put("MD", 0.06);
		foodTaxes.put("DC", 0.10);
		foodTaxes.put("VA", 0.05);
	}
	
	public static double getFoodTax(String state) {
		Double foodTax = foodTaxes.get(state);
		if (foodTax == null) {
			return 0.0;
		} else {
			return foodTax.doubleValue();
		}
	}
}
