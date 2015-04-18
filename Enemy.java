package SpaceInvaders;

import java.util.ArrayList;

import zen.core.Zen;

public class Enemy {
	int x, y, speed, sizeX, sizeY;
	ArrayList<EnemyBullet> ebs = new ArrayList<EnemyBullet>();
	int coolDown = 0;
	int delay = Zen.dice(10) + 1;
	
	public Enemy(int x, int y, int speed, int sizeX, int sizeY)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void draw()
	{
		Zen.setColor("red");
		Zen.fillRect(x, y, sizeX, sizeY);
		for (int i = 0; i < ebs.size(); i++)
		{
			ebs.get(i).draw();
			ebs.get(i).move();
			if (ebs.get(i).y > 600)
			{
				ebs.remove(i);
				i--;	
			}
		}
		coolDown++;
	}
	
	public void move()
	{
		
	}
	
	public void fire()
	{
		if (coolDown >= delay)
		{
			EnemyBullet eb = new EnemyBullet(x + sizeX/2, y + sizeY, 5, 5, 15);
			ebs.add(eb);
			coolDown = 0;
			delay = Zen.dice(50) + 50;
		}
	}
}
