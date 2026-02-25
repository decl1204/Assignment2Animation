import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class AnimationViewer extends JFrame {

	private Animation animation;
	private JLabel framePanel;
	private JLabel animPanel;
	private int scaledWidth;
	private int scaledHeight;
	private final int ANIMATION_SPEED = 100; // Adjust this speed as needed.
	
	public AnimationViewer (Animation anim) {
		animation = anim;
		
		// Scale image.
		AnimationFrame frame = animation.getFrameAt(1);
		scaledWidth = 900;
		scaledHeight = (int)((double)frame.getHeight() / ((double)frame.getWidth() / scaledWidth));
		
		// Set up GUI.
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(930, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Frame number at top.
		framePanel = new JLabel("Frame - of -");
		framePanel.setFont(new Font("Arial", Font.PLAIN, 24));
		add(framePanel);
		
		// Animation panel in the middle.
		animPanel = new JLabel();
		animPanel.setSize(900, 400);
		animPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		add(animPanel);
		showFrame(1);

	}
	public void play () {
		try {
			for (int frameNum = 1; frameNum <= animation.getNumFrames(); frameNum++) {
				showFrame(frameNum);
				Thread.sleep(ANIMATION_SPEED);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void playLooped () {
		try {
			int frameNum = 1;
			int frameCount = animation.getNumFrames();
			while (frameNum <= frameCount) {
				showFrame(frameNum);
				Thread.sleep(ANIMATION_SPEED);
				frameNum++;
				if (frameNum > frameCount) frameNum = 1; // Reset to start of animation.
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public void showFrame (int frameNum) {
		framePanel.setText("Frame " + frameNum + " of " + animation.getNumFrames());
		
		Image scaledImg = animation.getFrameAt(frameNum).getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImg);
		animPanel.setIcon(icon);
	}
	
}
