package enginePack;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.lwjgl.input.Mouse;
import assetpack.AssetManager;
import assetpack.Tile;


public class Cursor {
	private Tile tile;
	private Image img;
	private int x,y;
	private int tilex, tiley;
	private int tilesize;
	private boolean placing;
	private boolean breaking;
	public Cursor(int tilesize) {
		this.img = AssetManager.loadImageWithScale("texture/Cursor.png", 2);
		this.tilesize = tilesize;
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g,GameContainer gc,int x,int y) {
		this.x = (Mouse.getX()-(gc.getWidth() / 2 - x))-this.tilesize/2;
		this.y = ((gc.getHeight() - (int)Mouse.getY())-(gc.getHeight() / 2 - y))-tilesize/2;
		int drawx = Math.round(this.x/tilesize)*tilesize;
		int drawy = Math.round(this.y/tilesize)*tilesize;
		this.setTilex(this.x/tilesize);
		this.setTiley(this.y/tilesize);
		if(this.tile != null) {
			g.drawImage(tile.getImage(), drawx, drawy);
		}
		g.drawImage(img, drawx, drawy);

		
	}
	public Tile getTile() {
		return tile;
	}
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTilex() {
		return tilex;
	}

	public void setTilex(int tilex) {
		this.tilex = tilex;
	}

	public int getTiley() {
		return tiley;
	}

	public void setTiley(int tiley) {
		this.tiley = tiley;
	}

	public boolean isPlacing() {
		return placing;
	}

	public void setPlacing(boolean placing) {
		this.placing = placing;
	}

	public boolean isBreaking() {
		return breaking;
	}

	public void setBreaking(boolean breaking) {
		this.breaking = breaking;
	}

}
