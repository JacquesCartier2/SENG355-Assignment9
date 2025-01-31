import java.util.ArrayList;
import java.util.List;

public class GreedyKnapsackSolver {
	public static List<KnapsackObject> solve(List<KnapsackObject> items, double budget){
		items.sort((a, b) -> Double.compare(b.GetValue(), a.GetValue()));
		
		List<KnapsackObject> selected = new ArrayList<>();
		double remainingBudget = budget;
		
		for (KnapsackObject item : items) {
			if (remainingBudget >= item.GetCost()) {
				selected.add(item);
				remainingBudget -= item.GetCost();
			}
		}
		return selected; 
	}

}
