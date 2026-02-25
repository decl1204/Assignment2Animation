
public class TestCarAnim {

	public static void main(String[] args) {

		AnimationFrame firstFrame = new AnimationFrame("drive/Slide1.png");
		Animation driveAnim = new Animation(firstFrame);
		
		// Add all the driving car frames to the animation.
		for (int i = 2; i <= 84; i++) {
			AnimationFrame f = new AnimationFrame("drive/Slide" + i + ".png");
			driveAnim.addFrameAtEnd(f);
		}
		
		System.out.println("Frames added to the animation");
		
		AnimationFrame frame, frame2;
		frame = driveAnim.getFrameAt(2);
		frame2 = driveAnim.getFrameAt(3);
		System.out.println("<2,"+frame.getFilename()+">");
		System.out.println("<2,"+frame2.getFilename()+">");// Expected "<2,drive/Slide2.png>"
		// Try to add a frame of a different size to the driving car animation.
		try {
			AnimationFrame badFrame = new AnimationFrame("letters/A.png");
			driveAnim.addFrameAtEnd(badFrame);
		} catch (AnimationException e) {
			System.out.println("Correct exception type!");
		} catch (Exception e) {
			System.out.println("Incorrect exception type. It has to be an AnimationException.");
		}
		
		// Try removing half the frames. Comment/un-comment as needed.
		driveAnim.removeHalfFrames();
		System.out.println("Number of frames: "+driveAnim.getNumFrames()); // Expected 42
		
		// Remove frame 10.
		driveAnim.removeFrameAt(10);
		
		frame = driveAnim.getFrameAt(10); 
		System.out.println("<10,"+frame.getFilename()+">"); // Expected "<10,drive/Slide21.png>" 
		
		// Add a plane image into the car animation.
		driveAnim.addFrameAt(22, new AnimationFrame("flight/Slide30.png"));
		frame = driveAnim.getFrameAt(22); 
		System.out.println("<22,"+frame.getFilename()+">"); // Expected "<10,drive/Slide30.png>" 

		// Display the animation in the viewer.
		AnimationViewer viewer = new AnimationViewer(driveAnim);
		viewer.play(); // Play once.
		//viewer.playLooped(); // Play on loop.
		
		firstFrame = new AnimationFrame("flight/Slide1.png");
		Animation anim = new Animation(firstFrame);
		
		// Add frames to the animation.
		for (int i = 2; i <= 100; i++) {
			AnimationFrame f = new AnimationFrame("flight/Slide" + i + ".png");
			anim.addFrameAtEnd(f);
		}	
		
		System.out.println("Frames for second animation were added");
		viewer = new AnimationViewer(anim);
		viewer.play(); // Play once.
		
		firstFrame = new AnimationFrame("letters/A.png");
		anim = new Animation(firstFrame);
		
		// Add frames to the animation.
		for (int i = 1; i <= 6; i++) {
			AnimationFrame f = new AnimationFrame("letters/" + (char)(65+i) + ".png");
			anim.addFrameAtEnd(f);
		}	
		
		System.out.println("Frames for third animation were added");		
		viewer = new AnimationViewer(anim);
		viewer.play(); // Play once.		
	}

}
