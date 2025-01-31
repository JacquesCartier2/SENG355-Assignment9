import java.util.ArrayList;

public class Program {
	String filePath = "C:\\School\\Assignments\\SENG355-Ass9\\data.csv";
	
	private void PrintResults(ArrayList<KnapsackObject> _list) {
		double totalValue = 0;
		double totalCost = 0;
		
		for(KnapsackObject obj : _list) {
			totalValue += obj.GetValue();
			totalCost += obj.GetCost();
		}
		
		System.out.println("Total value: " + totalValue);
		System.out.println("Total cost: " + totalCost);
		System.out.println("Number of objects: " + _list.size());
		PrintList(_list);
	}
	
	private void PrintList(ArrayList<KnapsackObject> _list) {
		for(KnapsackObject obj : _list) {
			System.out.println(obj);
		}
	}

	public static void main(String[] args) {
		
	}

}
