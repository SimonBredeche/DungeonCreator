package lesson1;

import javax.swing.JFrame;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

import assetpack.AnimationManager;
import enginePack.Cursor;
import enginePack.TileMap;
import gui.EditorGUI;



public class WindowGame extends BasicGame {
	
	private GameContainer container;
	Image stone, grass, steve;
	Texture text;
	Input input;
	public static EditorGUI editGUI;
	public static Cursor cursor;
	public static TileMap tilemap;
	private static final int movespeed = 8;
	private static final int widht = 64, height = 64;
	private int tilesize;
	private int x = 960,y = 540;
    public WindowGame() {
        super("Lesson 1 :: WindowGame");
    }
    
    public void loadText(GameContainer container) throws SlickException {
    	input = container.getInput();

    	
    	
    }

    
    @Override
    public void init(GameContainer container) throws SlickException {
    	this.tilesize = widht;
    	this.container = container;
    	tilemap = new TileMap(48,48,tilesize,"tree1");
    	cursor = new Cursor(tilesize);
    	editGUI = new EditorGUI(AnimationManager.loadTileFromSpriteSheet("texture/SpriteSheet1.png", widht, height, 1),
    							AnimationManager.loadTileFromSpriteSheet("texture/SpriteSheetBack.jpg", widht, height, 1),
    							container);
    	

    }
    
    


	@Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
    	g.clear();
		g.translate(container.getWidth() / 2 - (int) this.x, 
                container.getHeight() / 2 - (int) this.y);
    	tilemap.render(g);
    	cursor.render(g, gc, this.x,this.y);
    	g.resetTransform();
    	editGUI.render(g,gc);
    	

    	
    	
    	

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	Input input = container.getInput();
    	if(cursor.isPlacing() && cursor.getTile() != null) {
    		if(!editGUI.isBack())
    			tilemap.setTilefront(cursor.getTilex(), cursor.getTiley(), cursor.getTile());
    		else
    			tilemap.setTileback(cursor.getTilex(), cursor.getTiley(), cursor.getTile());
    	}
    	if(cursor.isBreaking()) {
    		if(!editGUI.isBack())
    			tilemap.setTilefront(cursor.getTilex(), cursor.getTiley(), tilemap.getTransparentTile());
    		else
    			tilemap.setTileback(cursor.getTilex(), cursor.getTiley(), tilemap.getTransparentTile());
    	}
		if(input.isKeyDown(Input.KEY_D)) {
			this.x += movespeed;
		}
		if(input.isKeyDown(Input.KEY_Q)) {
			this.x -= movespeed; 
		}
		if(input.isKeyDown(Input.KEY_S)) {
			this.y += movespeed;
		}
		if(input.isKeyDown(Input.KEY_Z)){
			this.y -= movespeed;
		}

    }
    
    public static void main(String[] args) throws SlickException {
    	JFrame frame = new JFrame();
 	    CanvasGameContainer app = new CanvasGameContainer(new WindowGame());
 	    frame.setUndecorated(true);
 	    frame.setVisible(true);
 	    frame.add(app);
 	    frame.setSize(1920, 1080);
 	    app.start();
       
        

        
    }
	@Override
	public void mousePressed(int button, int x, int y) {
		switch (button) {
			case Input.MOUSE_RIGHT_BUTTON:
				cursor.setPlacing(true);
				break;
			case Input.MOUSE_LEFT_BUTTON:
				cursor.setBreaking(true);
				break;
		}
	}
	@Override
	public void mouseReleased(int button, int x, int y){
		cursor.setBreaking(false);
		cursor.setPlacing(false);

		
		
	}
    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }
}