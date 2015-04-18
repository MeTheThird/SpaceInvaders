package SpaceInvaders;

import java.util.ArrayList;

import zen.core.Zen;

public class MainGame {

	public static void main(String[] args) {
		Zen.create(300, 600);
		
		boolean dead = false;
		Player p = new Player(150, 500, 5, 20, 10);
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		
		for (int i = 0; i < 10; i++)
		{
			Enemy e = new Enemy(i * 50 + 40 + 50, 100, 2, 20, 20);
			Enemy e1 = new Enemy(i * 50 + 50, 160, 2, 20, 20);
			enemies.add(e);
			enemies.add(e1);
		}
		
		while (true)
		{
			Zen.setBackground("black");
			if (dead == false)
			{
				p.draw();
				p.move();
				p.fire();
			}
			else
			{
				Zen.setFont("arial", 40);
				Zen.setColor("white");
				Zen.drawText("GET", 100, 260);
				Zen.drawText("REKT", 100, 300);
				Zen.drawText("SON!", 100, 340);
			}
			yoself :for (int i = 0; i < enemies.size(); i++)
			{
				enemies.get(i).draw();
				enemies.get(i).fire();
				for (int j = 0; j < p.pbs.size(); j++)
				{
					if (p.pbs.get(j).isTouching(enemies.get(i)))
					{
						enemies.remove(i);
						p.pbs.remove(j);
//						i--;
//						j--;
					}
				}
				for (int k = 0; k < enemies.get(i).ebs.size(); k++)
				{
					if (enemies.get(i).ebs.get(k).isTouching(p))
					{
						dead = true;
						enemies.get(i).ebs.remove(k);
						break yoself;
//						k--;
					}
				}
			}
			
			Zen.buffer(33);
		}
	}

}
