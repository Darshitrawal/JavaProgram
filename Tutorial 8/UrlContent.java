import java.net.*;
import java.io.*;

class UrlContent {
	public static void main(String args[]) {
		try {
			Socket homepage = new Socket("www.vvpedulink.ac.in",80);
			OutputStream os = homepage.getOutputStream();
			os.write("GET / HTTP /1.1 \n\r\n\r".getBytes());
			InputStream is = homepage.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String msg = "";
			int c = 0;
			while( (c = is.read()) != -1) {
				msg += (char)c;
				System.out.println(msg);
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
