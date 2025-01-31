
public class Stock implements KnapsackObject{
	double price;
	double probability;
	double possiblePrice;
	
	public double GetValue() {
		return (possiblePrice - price) * probability;
	}
	
	public double GetCost() {
		return price;
	}
	
	public void SetPrice(double _price) {
		this.price = _price;
	}
	
	public void SetProbability(double _probability) {
		this.probability = _probability;
	}
	
	public void SetPossiblePrice(double _possiblePrice) {
		this.possiblePrice = _possiblePrice;
	}
	
	@Override
	public String toString() {
		return "price: " + price + ", prob: " + probability + ", possible: " + possiblePrice + ". ";
	}
	
	public String ToCSVEntry(){
		return price + "," + probability + "," + possiblePrice;
	}
	
	public String GetCSVTitle() {
		return "price,probability,possiblePrice";
	}
	
	public Stock(double _price, double _probability, double _possiblePrice) {
		this.price = _price;
		this.probability = _probability;
		this.possiblePrice = _possiblePrice;
	}
	
	public Stock() {
		this.price = 0;
		this.probability = 0;
		this.possiblePrice = 0;
	}
}
