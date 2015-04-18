package SpaceInvaders;

import zen.core.Zen;

public class EnemyBullet {

int x, y, speed, sizeX, sizeY;
	
	public EnemyBullet(int x, int y, int speed, int sizeX, int sizeY)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void draw()
	{
		Zen.setColor("yellow");
		Zen.fillRect(x, y, sizeX, sizeY);
	}
	
	public void move()
	{
		y += speed;
	}
	
	public boolean isTouching(Player e)
	{
		if (Math.abs(x - e.x) < 20 && Math.abs(y - e.y) < 20)
		{
			return true;
		}
		else
			return false;
	}
}
