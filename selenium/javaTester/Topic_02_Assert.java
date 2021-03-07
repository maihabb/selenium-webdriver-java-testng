package javaTester;
 
import org.testng.Assert;

public class Topic_02_Assert {
	public static void main(String[] args) {
		String error_mess = "This is error mess.";
		//so sanh bang
		Assert.assertEquals("This is error", error_mess);
		
		//kiem tra dieu kien dung
		boolean status = true;
		Assert.assertTrue(status);
		
		//kiem tra dieu kien sai
		status = true;
		Assert.assertFalse(status); //error
		
	}



}
