import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Random;

public class StockFileManager implements FileManager{
	private double maxPrice;
	private double minPrice;
	private double maxPossible;
	private double minPossible;
	
	public ArrayList<KnapsackObject> GenerateData(int _dataPoints){
		ArrayList<KnapsackObject> data = new ArrayList<KnapsackObject>();
		int dataPointsRemaining = _dataPoints;
		Random random = new Random();
		//random.doubles(origin, bound) returns a stream of random doubles, and the .iterator() function returns an iterator to go through that stream one by one. 
		PrimitiveIterator.OfDouble randomPrice = random.doubles(minPrice, maxPrice).iterator();
		PrimitiveIterator.OfDouble randomPossible = random.doubles(minPossible, maxPossible).iterator();
		
		while(dataPointsRemaining > 0) {
			Stock newStock = new Stock(RoundDouble(randomPrice.next().doubleValue()), RoundDouble(random.nextDouble()), RoundDouble(randomPossible.next().doubleValue()));
			
			data.add(newStock);
			
			dataPointsRemaining--;
		}
		
		return data;
	}
	
	public void WriteDataToFile(ArrayList<KnapsackObject> _data, String _filePath) {
		//create the file in the destination. 
		File file = new File(_filePath);
		try {
			if(file.createNewFile() == false) {
				System.out.println(_filePath + " has been overwritten. "); 
			}
		}
		catch(IOException e) {
			System.out.println(e.toString());
			return;
		}
		
		//write the data to file.
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(_data.get(0).GetCSVTitle());
			
			for(KnapsackObject obj : _data) {
				writer.write("\n" + obj.ToCSVEntry());
			}
			
			writer.close();
		}
		catch(IOException e) {
			System.out.println(e.toString());
			return;
		}
	}
	
	public ArrayList<KnapsackObject> ReadDataFromFile(String _filePath, int _linesToRead){
		File loadedFile = null;
		
		
		try {
			loadedFile = new File(_filePath);
		}
		catch(Exception E) {
			System.out.println("file not found. ");
		}
		
		try {
			ArrayList<KnapsackObject> data = new ArrayList<KnapsackObject>(); //data read from the file will be stored here and added to userAtHand if no problems occur. 
			
			BufferedReader br = new BufferedReader(new FileReader(loadedFile));
			String line = "";
			int linesToRead = _linesToRead;
			double price;
			double probability;
			double possiblePrice;
			int lineNumber = 1; //used to keep track of which line is being read. 
			
			br.readLine(); //first line contains data field names and should be skipped. 
			
			while ((line = br.readLine()) != null && linesToRead > 0) {   //go through each line in the file
				lineNumber++;
				
				//if a line is completely empty, ignore it.
				if(line.equals("")) {
					continue;
				}
				
				String[] splitLine = line.split(",");   // use comma as separator to split the line into parts.
				
				if(splitLine.length < 3) {
					System.out.println("invalid data on line " + lineNumber + ", 3 data points are required for each line. ");
					br.close();
					return null;
				}
				
				//first data point is price, must be parse-able as double.
				try {
					price = Double.parseDouble(splitLine[0]);
				}
				catch(Exception E) {
					System.out.println("invalid data on line " + lineNumber + ", first data point must be a number. ");
					br.close();
					return null;
				}
				
				//second data point is probability, must be parse-able as double. 
				try {
					probability = Double.parseDouble(splitLine[1]);
				}
				catch(Exception E) {
					System.out.println("invalid data on line " + lineNumber + ", second data point must be a number. ");
					br.close();
					return null;
				}
				
				//third data point is possiblePrice, must be parse-able as double. 
				try {
					possiblePrice = Double.parseDouble(splitLine[2]);
				}
				catch(Exception E) {
					System.out.println("invalid data on line " + lineNumber + ", third data point must be a number. ");
					br.close();
					return null;
				}
				
				//if all three data points work, add a new expense.
				data.add(new Stock(price, probability, possiblePrice));
				
				linesToRead--;
			}
			
			br.close();
			
			return data;
		}
		catch(Exception E){
			System.out.println(E.toString());
			return null;
		}
	}
	
	//round double to 2 decimal points. 
	private double RoundDouble(double _number) {
		return Math.round(_number * Math.pow(10, 2)) / Math.pow(10, 2);
	}
	
	public StockFileManager(double _minPrice, double _maxPrice, double _minPossible, double _maxPossible) {
		this.minPrice = _minPrice;
		this.maxPrice = _maxPrice;
		this.minPossible = _minPossible;
		this.maxPossible = _maxPossible;
	}
}
