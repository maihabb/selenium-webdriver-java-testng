package javaTester;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Topic_01_DataType {
	//Unique character (nháy đơn)
	char a = 'c';
	
	//Số nguyên (k dấu)
	//byte
	byte byteNum = 50; //-127 to 127
	//short
	short shortNum = 50; //
	//Int
	int intNum = 50; //
	//long
	long longNum = 50; //
			
	//Chứa số thực (có dấu)
	//float
	float floatNum = 59.653F; //thêm F để biết dc là kiểu float
	//double
	double doubleNum = 638.6347D;
	
	//Luận lý (True/False)
	boolean status = true;
	
	// Chứa chuỗi kí tự (nháy đôi)
	//String
	String name = "Mai Thị Thu Hà";
	String address = "Số 5 đường 2C KDC Nam Hùng Vương";
	
	//Kiểu Class
	//Class
	Topic_01_DataType topic01;
	
	//Kiếu đối tượng
	//Object
	
	//Kiểu mảng
	//Array
	String[] student = {"BaekHuyn", "Sehun", "D.O."};
	int[] studentSalary = {100, 200, 1, 23};
	
	//Kiểu interface
	//Interface
	WebDriver driver;
	RemoteWebDriver remoteDriver;
	
	//Kiểu tập hợp (List/Set/Queue...)
	//List: ArrayList/ LinkedList
	//Collection
	
	List<String> studentName = new ArrayList<String>();
	
	
}
