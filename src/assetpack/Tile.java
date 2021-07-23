package assetpack;

import org.newdawn.slick.Image;

public class Tile {
	public static int ID = 0;
	private Image image;
	private int Tile_ID;
	public Tile(Image image) {
		this.image = image;
		this.Tile_ID = ID;
		ID++;

	}
	
	
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getTile_ID() {
		return Tile_ID;
	}
	public void setTile_ID(int tile_ID) {
		Tile_ID = tile_ID;
	}

}
