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
			System.out.print(e.getMessage());
		}
		width = image.getWidth();
		height = image.getHeight();
		filename = imageFilename;
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
		if(this.getWidth() == other.getWidth() && this.getHeight() == other.getHeight()
				&& this.getFilename() == other.getFilename())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
