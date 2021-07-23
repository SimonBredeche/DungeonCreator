package enginePack;

import java.io.FileWriter;
import java.io.IOException;

import lesson1.WindowGame;



public class Save {
	private static String currentPathFront = "savedmap/";
	private static String currentPathBack = "savedmap/";
	public Save() {
		// TODO Auto-generated constructor stub
	}
	public static  void saveGame(String mapname) {
		try {
			currentPathFront += mapname + "front.tme";
			currentPathBack += mapname + "back.tme";
			FileWriter myWriter = new FileWriter(currentPathFront);
			FileWriter myWriter2 = new FileWriter(currentPathBack);
			for(int y = 0; y < WindowGame.tilemap.getHeight();y++) {
				for(int x= 0; x < WindowGame.tilemap.getWidth(); x++) {
					
					myWriter.write(Integer.toString(WindowGame.tilemap.getTilefront(x, y).getTile_ID())+',');
					myWriter2.write(Integer.toString(WindowGame.tilemap.getTileback(x, y).getTile_ID())+',');
				}
				myWriter.write("\n");
				myWriter2.write("\n");
				
			}		
			myWriter.close();
			myWriter2.close();



			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
