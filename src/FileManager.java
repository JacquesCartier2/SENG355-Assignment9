import java.io.File;
import java.util.ArrayList;

public interface FileManager {
	public ArrayList<KnapsackObject> ReadDataFromFile(String _filePath, int _linesToRead);
	public void WriteDataToFile(ArrayList<KnapsackObject> _data, String _filePath);
	public ArrayList<KnapsackObject> GenerateData(int _dataPoints);
}
