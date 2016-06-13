import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class RunPrograms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Process p1 = new ProcessBuilder("cmd.exe").start();
			String line = "";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			OutputStream out = p1.getOutputStream();
			while((line = br.readLine()) != null){
				System.out.println("line: " + line);
			}
			
			
			
			p1.destroy();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("starting second cmd");
		
		try {
			String line = "";
			Process p = Runtime.getRuntime().exec("cmd");
			System.out.println("running program");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			OutputStream out = p.getOutputStream();
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			p.destroy();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
