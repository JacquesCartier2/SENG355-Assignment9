import java.io.File;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.DoubleStream;

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
		return;
	}
	
	public ArrayList<KnapsackObject> ReadDataFromFile(File _file){
		return null;
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
