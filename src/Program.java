import java.util.ArrayList;
import java.util.List;

public class Program {
    static String filePath = "C:\\School\\Assignments\\SENG355-Ass9\\data.csv";

    private static void PrintResults(List<KnapsackObject> _list) {
        double totalValue = 0;
        double totalCost = 0;

        for (KnapsackObject obj : _list) {
            totalValue += obj.GetValue();
            totalCost += obj.GetCost();
        }

        System.out.println("Total value: " + totalValue);
        System.out.println("Total cost: " + totalCost);
        System.out.println("Number of objects: " + _list.size());
        PrintList(_list);
    }

    private static void PrintList(List<KnapsackObject> _list) {
        for (KnapsackObject obj : _list) {
            System.out.println(obj);
        }
    }
    
    private static void RunTestCase(ArrayList<KnapsackObject> _data, double _budget) {
    	long startTimeGreedy = System.nanoTime();
        List<KnapsackObject> greedySelectedItems = GreedyKnapsackSolver.solve(_data, _budget);
        long endTimeGreedy = System.nanoTime();
        long greedyDuration = endTimeGreedy - startTimeGreedy;

        System.out.println("Greedy Algorithm - Selected Items: " + greedySelectedItems.size());
        System.out.println("Greedy Algorithm Time: " + greedyDuration + " nanoseconds");
        
        System.out.println("");

        PrintResults(greedySelectedItems);
        
        System.out.println("");

        long startTimeOptimal = System.nanoTime();
        List<KnapsackObject> optimalSelectedItems = OptimalKnapsackSolver.maximizeValue(_data, _budget); 
        long endTimeOptimal = System.nanoTime();
        long optimalDuration = endTimeOptimal - startTimeOptimal;
        
        System.out.println(""); 

        System.out.println("Optimal Algorithm - Selected Items: " + optimalSelectedItems.size());
        System.out.println("Optimal Algorithm Time: " + optimalDuration + " nanoseconds");
        
        System.out.println("");

        PrintResults(optimalSelectedItems);
    }

    public static void main(String[] args) {
        StockFileManager fileManager = new StockFileManager(1, 100, 1, 200);

        ArrayList<KnapsackObject> stockData = fileManager.ReadDataFromFile(filePath, 100);

        if (stockData == null || stockData.isEmpty()) {
            System.out.println("No data available to process.");
            return;
        }

        double budget = 500;
        
        RunTestCase(stockData, budget);

          
    }
}



