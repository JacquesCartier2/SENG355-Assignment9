import java.util.ArrayList;
import java.util.List;

public class OptimalKnapsackSolver {

    public static List<KnapsackObject> maximizeValue(List<KnapsackObject> items, double budget) {
        int itemCount = items.size();
        double maxValue = 0;
        List<KnapsackObject> selectedItems = new ArrayList<>();

        for (int i = 0; i < (1 << itemCount); i++) {
            double totalCost = 0;
            double totalValue = 0;
            List<KnapsackObject> currentSelection = new ArrayList<>();

            for (int j = 0; j < itemCount; j++) {
                if ((i & (1 << j)) != 0) {
                    KnapsackObject item = items.get(j);
                    totalCost += item.GetCost();
                    totalValue += item.GetValue();
                    currentSelection.add(item);
                }
            }

            if (totalCost <= budget && totalValue > maxValue) {
                maxValue = totalValue;
                selectedItems = currentSelection;  
            }
        }

        return selectedItems;
    }
}


