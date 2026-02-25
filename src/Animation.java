
public class Animation {
	private LinearNode<AnimationFrame> firstFrame;
	private int numFrames;

	public Animation(AnimationFrame frame)
	{
		firstFrame = new LinearNode(frame);
		numFrames = 1;
	}	
	public int getNumFrames()
	{
		return numFrames;
	}
	public String toString()
	{
		String  i = "";
		LinearNode<AnimationFrame> curr = firstFrame;
		int frames = 1;
		while(curr != null)
		{
			i = "<"+frames+","+curr.getData().getFilename()+">";
			frames++;
			curr = curr.getNext();
		}
		return i;
	}
	public AnimationFrame getFrameAt(int index)
	{
		int node = 1;
		LinearNode<AnimationFrame> curr = firstFrame;
		if(index >= 1 && index <= numFrames)
		{
			while(curr.getNext() != null)
			{
				if(node == index)
				{
					return curr.getData();
				}
				else
				{
					node++;
					curr = curr.getNext();
				}
			}
		}
		throw new AnimationException("Unable to load image");	
	}
	public void addFrameAtEnd(AnimationFrame frame)
	{
		LinearNode<AnimationFrame> curr;
		LinearNode<AnimationFrame> endFrame = new LinearNode(frame);

		if(firstFrame.getData().getHeight() == frame.getHeight() && 
				firstFrame.getData().getWidth() == frame.getWidth())
		{
			curr = firstFrame;
			while(curr.getNext() != null)
			{
				curr = curr.getNext();
			} 
			curr.setNext(endFrame);
			numFrames++;
		}
		else throw new AnimationException("");
	}
	public void addFrameAt(int index,AnimationFrame frame)
	{
		LinearNode<AnimationFrame> curr,pred;
		LinearNode<AnimationFrame> atFrame = new LinearNode(frame);

		if(firstFrame.getData().getHeight() == frame.getHeight() &&
				firstFrame.getData().getWidth() == frame.getWidth() && 
				1 < index && index < numFrames)
		{
			curr = firstFrame;
			pred = null;
			for(int i = 1; i < index; i++)
			{
				pred = curr;
				curr = curr.getNext();
			}
			curr.setNext(atFrame);
			numFrames++;
		}
		else throw new AnimationException("");
	}
	public boolean tryAddFrameAtEnd(AnimationFrame frame)
	{
		try
		{
			addFrameAtEnd(frame);
			return true;
		}
		catch(AnimationException e)
		{
			System.out.print(e.getMessage());
			return false;
		}
	}
	public boolean tryAddFrameAt(int index, AnimationFrame frame)
	{
		try
		{
			addFrameAt(index,frame);
			return true;
		}
		catch(AnimationException e)
		{
			System.out.print(e.getMessage());
			return false;
		}
	}

	public AnimationFrame removeFrameAt(int index)
	{
		LinearNode<AnimationFrame> curr,pred;
		if(1 < index && index <= numFrames && numFrames >= 2)
		{
			curr = firstFrame;
			pred = null;
			for(int i = 1; i < index; i++)
			{
				pred = curr;
				curr = curr.getNext();
			}
			if(pred != null)
			{
				pred.setNext(curr.getNext());
			}
			else firstFrame = firstFrame.getNext();
			return curr.getData();
		}
		else throw new AnimationException("Cannot remove the only frame");

	}
	public boolean tryRemoveFrameAt(int index)
	{
		try
		{
			removeFrameAt(index);
			return true;
		}
		catch(AnimationException e)
		{
			System.out.print(e.getMessage());
			return false;
		}
	}
	public void removeHalfFrames()
	{
		LinearNode<AnimationFrame> curr = firstFrame;
		int countNode = numFrames;
		System.out.println(numFrames);
		while(countNode != numFrames % 2)
		{
			if(countNode % 2 == 0)
			{
				removeFrameAt(countNode);
				numFrames--;
			}
			countNode--;
		}
	}
	public void removeDuplicateFrames()
	{
		LinearNode<AnimationFrame> curr = firstFrame;
		int countNode = 1;
		while(curr.getNext() != null)
		{
			if(curr.getNext().getData().getFilename() == curr.getData().getFilename())
			{
				tryRemoveFrameAt(countNode);
			}
			countNode++;
		}
	}
}
