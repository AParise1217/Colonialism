import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;


public class GameRunner {

	public static void main(String[] args) throws IOException {
		Game g = new Game();
		
		Thread musicThread = new Thread(new Runnable() {

		    public void run() {
		    	InputStream in = null;
		    	AudioStream as = null;
				try {
					in = new FileInputStream("df.wav");
					as = new AudioStream(in);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				AudioPlayer.player.start(as);
				long start = System.currentTimeMillis();
				while(true){
					if(System.currentTimeMillis() - start >= 492000){
						run();
						break;
					}
				}
				
		    }
		            
		});
		        
		musicThread.start();
		
		
		g.run();
	}

}
