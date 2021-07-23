package assetpack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

public class AssetManager {
	
	public AssetManager() {

		
		
		
		//dirtReplace = loadImage("texture/StoneReplace.png");
	}
	
	public static Image loadImageWithScale(String path, float Scale) {
	    BufferedImage bufferedImage = null;
	    Image image = null;
	    Texture texture = null;
		try {	
			bufferedImage = ImageIO.read(new File(path));
			texture = BufferedImageUtil.getTexture("", bufferedImage);
			image = new Image(texture.getImageWidth(), texture.getImageHeight());
			//image.setFilter(Image.FILTER_NEAREST);
			//image = image.getScaledCopy(2);
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (SlickException e) {
			e.printStackTrace();
			
		}
		
	    image.setTexture(texture); 
	    image.setFilter(Image.FILTER_NEAREST);
	    image = image.getScaledCopy(Scale);
	    return image;
	}
	public static Image loadImage(String path) 
	{
	    BufferedImage bufferedImage = null;
	    Image image = null;
	    Texture texture = null;
		try {	
			bufferedImage = ImageIO.read(new File(path));
			texture = BufferedImageUtil.getTexture("", bufferedImage);
			image = new Image(texture.getImageWidth(), texture.getImageHeight());
			//image.setFilter(Image.FILTER_NEAREST);
			//image = image.getScaledCopy(2);
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (SlickException e) {
			e.printStackTrace();
			
		}
		
	    image.setTexture(texture); 
	    image.setFilter(Image.FILTER_NEAREST);
	    return image;
	}

}
