import java.util.ArrayList;
import java.util.List;

public class OptimalKnapsackSolver {
	public static List<KnapsackObject> maximizeValue(List<KnapsackObject> items, double budget) {
	    int itemCount = items.size();
	    double[] itemCosts = new double[itemCount];
	    double[] itemValues = new double[itemCount];
	    for (int i = 0; i < itemCount; i++) {
	        KnapsackObject item = items.get(i);
	        itemCosts[i] = item.GetCost();
	        itemValues[i] = item.GetValue();
	    }
	    double[][] dp = new double[itemCount + 1][(int) (budget + 1)];
	    for (int item = 1; item <= itemCount; item++) {
	        for (int capacity = 1; capacity <= budget; capacity++) {
	            double maxValWithoutCurr = dp[item - 1][capacity];
	            double maxValWithCurr = 0;
	            double weightOfCurr = itemCosts[item - 1];
	            if (capacity >= weightOfCurr) {
	                maxValWithCurr = itemValues[item - 1];
	                double remainingCapacity = capacity - weightOfCurr;
	                maxValWithCurr += dp[item - 1][(int) remainingCapacity];
	            }
	            dp[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr);
	        }
	    }
	    List<KnapsackObject> selectedItems = new ArrayList<>();
	    double remainingBudget = budget;
	    for (int item = itemCount; item > 0; item--) {
	        if (dp[item][(int) remainingBudget] != dp[item - 1][(int) remainingBudget]) {
	            KnapsackObject itemObj = items.get(item - 1);
	            if (remainingBudget - itemCosts[item - 1] >= 0) {
	                selectedItems.add(itemObj);
	                remainingBudget -= itemCosts[item - 1];
	            }
	        }
	    }
	    return selectedItems;
	}
}



