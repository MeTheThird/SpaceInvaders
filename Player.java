package SpaceInvaders;

import java.util.ArrayList;

import zen.core.Zen;

public class Player {
	
	int x, y, speed, sizeX, sizeY;
	ArrayList<PlayerBullet> pbs = new ArrayList<PlayerBullet>();
	int coolDown = 10;
	
	public Player(int x, int y, int speed, int sizeX, int sizeY)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void draw()
	{
		Zen.setColor("blue");
		Zen.fillRect(x, y, sizeX, sizeY);
		for (int i = 0; i < pbs.size(); i++)
		{
			pbs.get(i).draw();
			pbs.get(i).move();
			if (pbs.get(i).y < -10)
			{
				pbs.remove(i);
				i--;
			}
		}
		coolDown++;
	}
	
	public void move()
	{
		if (x >= 0 && Zen.isKeyPressed("left"))
		{
			x -= speed;
		}
		else if(x <= 275 && Zen.isKeyPressed("right"))
		{
			x += speed;
		}
	}
	
	public void fire()
	{
		if (coolDown >= 10 && Zen.isKeyPressed("space"))
		{
			PlayerBullet pb = new PlayerBullet(x + sizeX/2, y - sizeY, 5, 5, 15);
			pbs.add(pb);
			coolDown = 0;
		}
	}
	
}
