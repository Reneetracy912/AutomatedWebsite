package ReneeDishData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.datablind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;





import org.apache.commons.io.FileUtils;

public class DataReader {
public List<HashMap<String, String>> jasonDataToMap(String filePath) throws IOException {
	//read json content to string
	String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"C:\\Users\\reneetracy.vr\\eclipse-workspace\\SeleniumPractice\\src\\test\\java\\ReneeDishData\\PurchaseOrder.json"),StandardCharsets.UTF_8);
//convert string to hash map 
	ObjectMapper mapper = new ObjectMapper();
	List <HashMap<String,String>> data = mapper.readValue(JsonContent,new TypeReference<List<HashMap<String,String>>>(){});
	
	return data;
	
}

}
