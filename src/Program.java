import java.util.ArrayList;

public class Program {
	String directory = "C:\\School\\Assignments\\SENG355-Ass9\\";
	String[] files = {"100.csv", "350.csv","500.csv","750.csv","1000.csv","2000.csv","3000.csv","4000.csv","5000.csv","6000.csv"};

	public static void main(String[] args) {
		StockFileManager tester = new StockFileManager(1, 100, 1, 200);
		ArrayList<KnapsackObject> testList = tester.GenerateData(20);
		tester.WriteDataToFile(testList, "C:\\School\\Assignments\\SENG355-Ass9\\test.csv");
		testList = tester.ReadDataFromFile("C:\\School\\Assignments\\SENG355-Ass9\\test.csv");
		
		for(KnapsackObject obj : testList) {
			System.out.println(obj);
		}
	}

}
