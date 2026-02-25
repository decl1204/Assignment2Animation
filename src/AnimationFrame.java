import java.awt.image.BufferedImage;	
import java.io.File;
import javax.imageio.ImageIO;

public class AnimationFrame {
	private String filename;
	private BufferedImage image;
	private int height;
	private int width;
	
	public AnimationFrame(String imageFilename)
	{
		try {
			image = ImageIO.read(new File(imageFilename));
		}
		catch(Exception e){
			System.out.println("Unable to load image");
		}
		if(image != null)
		{
			width = image.getWidth();
			height = image.getHeight();
			filename = imageFilename;	
		}
		else
		{
			System.out.println("Unable to load image");
		}
	}
	public String getFilename()
	{
		return filename;
	}
	public BufferedImage getImage()
	{
		return image;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public boolean equals(AnimationFrame other)
	{
		if(getWidth() == other.getWidth() && getHeight() == other.getHeight()
				&& getFilename() == other.getFilename())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
