
public class MetPasswordTest {
	
	public static String[] chars2 = new String[] {"z","y",
												  "x","w","v","u","t","s",
												  "r","q","p","o","n","m",
												  "l","k","j","i","h","g",
												  "f","e","d","c","b","a"};
				 

	public static void main(String[] args) {
		
			MetPassword mPassword = new MetPassword(chars2);	
			mPassword.start();

	}

}
