import java.util.*;

public class Driver2
{
	public static void main(String[]args)
	{
		Random rand  = new Random();
		int xPosition = 500;
		int yPosition = 700;
		
		GameArena GameArena1 = new GameArena(1000, 750);
		
		Ball Ball1 = new Ball (xPosition, yPosition, 30, "purple");
		Rectangle rectangles[] = new Rectangle[20];
		GameArena1.addBall (Ball1);
		
		for(int i = 0; i < 20; i++)
		{
			Rectangle R = new Rectangle (rand.nextInt(800), rand.nextInt(500), 50, 50, "red");
			rectangles[i] = R;
			GameArena1.addRectangle (rectangles[i]);
		}
		
		while (true)
		{
				GameArena1.pause();
				
				if(GameArena1.rightPressed()==true)
				{
					xPosition++;
					Ball1.setXPosition(xPosition);
				}
				
				if(GameArena1.downPressed()==true)
				{
					yPosition++;
					Ball1.setYPosition(yPosition);
				}
				if(GameArena1.leftPressed()==true)
				{
					xPosition--;
					Ball1.setXPosition(xPosition);
				}
				
				if(GameArena1.upPressed()==true)
				{
					yPosition--;
					Ball1.setYPosition(yPosition);
				}
				for(int i = 0; i < 20; i++)
				{
					rectangles[i].move();
					if((rectangles[i].getXPosition()<= Ball1.getXPosition() && Ball1.getXPosition()<=rectangles[i].getXPosition()+rectangles[i].getWidth())&& (rectangles[i].getYPosition() <= Ball1.getYPosition() && Ball1.getYPosition()<=rectangles[i].getYPosition()+rectangles[i].getHeight()))
					{
						System.out.println("GAME OVER!");
					}
				}
		}
	}	
	
}