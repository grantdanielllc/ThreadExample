import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

public class MetPassword extends Thread {	
	
	private PrintStream stdOut;
	private PipedInputStream pipeIn = null;

	private String[] chars;
	
	public MetPassword(String[] chars) {
		this.chars = chars;
	}

	@Override
	public void run() {
		
		System.out.println("start thread for chars: " + this.chars[0]);
		
		//change standard out
		stdOut = System.out;
		
		//System.out
		PipedOutputStream pipeOut = new PipedOutputStream();
		try {
			pipeIn = new PipedInputStream(pipeOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setOut(new PrintStream(pipeOut));
		// now read from pipeIn
		
		for (String pos1 : chars) {	
			for (String pos2 : chars) {				
				for (String pos3 : chars) {					
					for (String pos4 : chars) {						
						for (String pos5 : chars) {							
							for (String pos6 : chars) {
								
								String password = pos1 + pos2 + pos3 + pos4 + pos5 + pos6;
																
								testPassword(password);
								
							}
						}
					}
				}	
			}
		}	
		
		
	}
	
	private void testPassword(String password) {
		String[] pw = new String[] {password};

		Main.main(pw);
		
		try {
			byte b[]=new byte[pipeIn.read()];
			pipeIn.read(b,0,b.length);
			String answer = new String(b);
			
			if (answer.contains("@")) {
				System.setOut(stdOut);
				System.out.println("pw: " + password);
				System.out.println(answer);
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
