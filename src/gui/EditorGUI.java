package gui;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

import assetpack.AssetManager;
import assetpack.Tile;
import enginePack.Save;
import lesson1.WindowGame;

public class EditorGUI implements ComponentListener{
	private Tile[][] allTiles;
	private Tile[][] allBackTiles;
	private MouseOverArea[][] allArea;
	private MouseOverArea[][] allAreaBack;
	private int widht = 5, height;
	private boolean back =  false;
	private int tilesize;
	private final int startY = 128;
	private MouseOverArea layer1;
	private MouseOverArea save;
	public EditorGUI(ArrayList<Tile> allTiles,ArrayList<Tile> backtile,GameContainer gc) {
		this.tilesize = allTiles.get(0).getImage().getWidth();
		this.height = allTiles.size()/widht;
		this.allTiles = new Tile[widht][height];
		this.allArea = new MouseOverArea[widht][height];
		this.allBackTiles = new Tile[widht][height];
		this.allAreaBack = new MouseOverArea[widht][height];
		Image buttonimg = AssetManager.loadImageWithScale("texture/button.png", 2);
		this.layer1 = new MouseOverArea(gc,buttonimg ,0,startY + this.height*tilesize + 20,this);
		this.save = new MouseOverArea(gc,buttonimg ,0,startY + this.height*tilesize + 30 + buttonimg.getHeight() ,this);
		int index = 0;
		
			for(int j = 0; j < height; j++) {
				for(int i = 0; i < widht;i++) {
					this.allTiles[i][j] = allTiles.get(index);
					this.allBackTiles[i][j] = backtile.get(index); 
					this.allArea[i][j] = new MouseOverArea(gc, allTiles.get(index).getImage(),i*tilesize, startY + j*tilesize,this);
					this.allAreaBack[i][j] = new MouseOverArea(gc, backtile.get(index).getImage(),i*tilesize, startY + j*tilesize,this);
					index++;
				}
			}
		
		
	}
	public void render(Graphics g,GameContainer gc) {
		if(!this.isBack()) {
			for(int i = 0; i < allTiles.length;i++) {
				for(int j = 0; j < allTiles[i].length; j++) {
					allArea[i][j].render(gc, g);
					//g.drawImage(allTiles[i][j].getImage(), i*tilesize, startY + j*tilesize);
					
				}
			}
		}else {
			for(int i = 0; i < allTiles.length;i++) {
				for(int j = 0; j < allTiles[i].length; j++) {
					allAreaBack[i][j].render(gc, g);
					//g.drawImage(allTiles[i][j].getImage(), i*tilesize, startY + j*tilesize);
					
				}
			}
		}
		this.layer1.render(gc, g);
		g.drawString("Switch layer", this.layer1.getX()+32, this.layer1.getY()+10);
		this.save.render(gc, g);
		g.drawString("Save map", this.save.getX()+32, this.save.getY()+10);
	}
	@Override
	public void componentActivated(AbstractComponent source) {
		if(source == layer1) {
			this.setBack(!this.isBack());
			WindowGame.cursor.setTile(null);
		}
		if(source == save) {
			Save.saveGame(WindowGame.tilemap.getTilemapname());
		}
		if(!this.back) {
			for(int i = 0; i < allTiles.length;i++) {
				for(int j = 0; j < allTiles[i].length; j++) {
					if(source == allArea[i][j]) {
						WindowGame.cursor.setTile(allTiles[i][j]);
					}
					
					
					
				}
			}
		}
		else {
			for(int i = 0; i < allTiles.length;i++) {
				for(int j = 0; j < allTiles[i].length; j++) {
					if(source == allAreaBack[i][j]) {
						WindowGame.cursor.setTile(allBackTiles[i][j]);
					}
				}
			}
		}
		
	}
	public boolean isBack() {
		return back;
	}
	public void setBack(boolean back) {
		this.back = back;
	}


}
