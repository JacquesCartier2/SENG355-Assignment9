import java.io.File;
import java.util.ArrayList;

public interface FileManager {
	public ArrayList<KnapsackObject> ReadDataFromFile(File _file);
	public void WriteDataToFile(ArrayList<KnapsackObject> _data);
	public ArrayList<KnapsackObject> GenerateData(int _dataPoints, String _filePath);
}
