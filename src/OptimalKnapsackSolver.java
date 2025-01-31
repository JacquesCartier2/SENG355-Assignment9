import java.util.List;

public class OptimalKnapsackSolver {

    public static double maximizeInvestmentValue(List<KnapsackObject> items, double budget) {
        int itemCount = items.size();
        double maxValue = 0;

        for (int i = 0; i < (1 << itemCount); i++) {
            double totalCost = 0;
            double totalValue = 0;

            for (int j = 0; j < itemCount; j++) {
                if ((i & (1 << j)) != 0) {  
                    totalCost += items.get(j).GetCost();
                    totalValue += items.get(j).GetValue();
                }
            }

            if (totalCost <= budget) {
            	maxValue = Math.max(maxValue, totalValue);
            }
        }

        return maxValue;
    }
}

