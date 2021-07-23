package enginePack;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import assetpack.AssetManager;
import assetpack.Tile;

public class TileMap {
	
	private Tile[][] tilemap;
	private Tile[][] tilemapback;
	private Tile[][] tilemapfront;
	private int width, height;
	private int tilesize;
	private String tilemapname;
	private Image image;
	private Tile voidtile;
	private Tile transparent;
	private final int basex = 384, basey = 128;
	public TileMap(int width, int height,int tilesize,String tilemapname) {
		this.width = width;
		this.height = height;
		this.tilemap = new Tile[width][height];
		this.tilemapback = new Tile[width][height];
		this.tilemapfront = new Tile[width][height];
		this.setTilemapname(tilemapname);
		this.tilesize = tilesize;
		this.image = AssetManager.loadImageWithScale("texture/backTile.png", 2);
		this.transparent = new Tile(AssetManager.loadImageWithScale("texture/transparent.png", 2));
		this.voidtile = new Tile(image); 
		for(int i = 0; i < tilemap.length; i++) {
			for(int j = 0; j < tilemap[i].length;j++) {
				tilemap[i][j] =  this.voidtile;
				tilemapback[i][j] =  this.transparent;
				tilemapfront[i][j] =  this.transparent;
			}
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < tilemap.length; i++) {
			for(int j = 0; j < tilemap[i].length;j++) {
				if(tilemap[i][j] != null) {
					g.drawImage(tilemap[i][j].getImage(),basex+ i*tilesize,basey+ j*tilesize);
					g.drawImage(tilemapback[i][j].getImage(),basex+ i*tilesize,basey+ j*tilesize);
					g.drawImage(tilemapfront[i][j].getImage(),basex+ i*tilesize,basey+ j*tilesize);
				}
			}
		}
	}
	public void setTilefront(int x, int y,Tile tile) {
		int truex =  x-(basex/tilesize);
		int truey =  y-(basey/tilesize);
		if(truex < this.width && truex >= 0 && truey < this.height && truey >= 0)
			tilemapfront[truex][truey] = tile;
	}
	public Tile getTilefront(int x, int y) {
		return tilemapfront[x][y];
	}
	public void setTileback(int x, int y,Tile tile) {
		int truex =  x-(basex/tilesize);
		int truey =  y-(basey/tilesize);
		if(truex < this.width && truex >= 0 && truey < this.height && truey >= 0)
			tilemapback[truex][truey] = tile;
	}
	public Tile getTileback(int x, int y) {
		return tilemapback[x][y];

	}

	public int getWidth() {
		return width;
	}
	public Tile getTransparentTile() {
		return this.transparent;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Tile[][] getTilemap() {
		return tilemap;
	}

	public void setTilemap(Tile[][] tilemap) {
		this.tilemap = tilemap;
	}

	public int getTilesize() {
		return tilesize;
	}

	public void setTilesize(int tilesize) {
		this.tilesize = tilesize;
	}

	public String getTilemapname() {
		return tilemapname;
	}

	public void setTilemapname(String tilemapname) {
		this.tilemapname = tilemapname;
	}

}
