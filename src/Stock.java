
public class Stock implements KnapsackObject{
	double price;
	double probability;
	double possiblePrice;
	
	public double GetValue() {
		return 0;
	}
	
	public double GetCost() {
		return price;
	}
	
	public Stock(double _price, double _probability, double _possiblePrice) {
		this.price = _price;
		this.probability = _probability;
		this.possiblePrice = _possiblePrice;
	}
}
