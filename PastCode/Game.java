public class Game
{
	public static void main(String[] args)
	{
		System.out.println("Get to level 100 to win.");
		Player player = new Player();
		while(player.getLevel() < 100 && player.getHealth() > 0)
		{
			player.isFighting(true);
			Monster monster = spawn();
			while(monster.getHealth() > 0 && player.getHealth() > 0 && player.isFighting()) 
			{
				System.out.println(player);
				System.out.println(monster);
				player.attack(monster);
				if (monster.getHealth() >= 0)
				{
					monster.attack(player);
				}
			}
			if (monster.getHealth() <= 0)
			{
				int xp = monster.getXP();
				player.levelup(xp);
			}
		}
		if (player.getLevel() >= 100)
		{
			System.out.println("\nYou won!");
		}
		else 
		{
			System.out.println("\nYou Lost!");
		}
	}

	public static Monster spawn()
	{
		String[] monsters = {"goblin","orc","troll"};
		int type = (int)(Math.random() * 3);
		Monster monster = Monster.spawn(monsters[type]);
		System.out.printf("\na %s appears\n\n", monster.getName() );
		return monster;
	}

}