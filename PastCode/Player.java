import java.util.Scanner;

public class Player 
{
	private int health;
	private int strength;
	private int mana;
	private int level;
	private boolean isFighting;

	public Player()
	{
		this.health = 100;
		this.mana = 9;
		this.strength = 10;
		this.level = 1;
		this.isFighting = false;
	}

	public int getHealth() { return this.health; }
	public int getStrength() { return this.strength; }
	public int getMana() { return this.mana; }
	public int getLevel() { return this.level; }
	public boolean isFighting() { return this.isFighting; }
	public void isFighting(boolean isFighting) {this.isFighting = isFighting;}

	public void attack(Monster monster)
	{
		this.isFighting = true;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("1) melee attack;");
		System.out.println("2) magic attack;");
		System.out.println("3) mana charge");
		System.out.println("4) flee battle");
		System.out.println();
		String choice = input.next();
		switch(choice)
		{
			case "1": this.melee(monster); break;
			case "2": this.magic(monster); break;
			case "3": this.manaup(); 	  break;
			case "4": this.flee(); 		  break;
			default: this.attack(monster); break;
		} 

	}

	public void melee(Monster monster)
	{
		int damage = (int)(Math.random() * this.strength) + 1;
		monster.takeDamage(damage);
		System.out.printf("You attack the %s for %d damage\n",monster.getName(), damage);
	}

	public void magic(Monster monster)
	{
		if (this.mana >= 3)
		{
			int damage = monster.getHealth() / 2;
			monster.takeDamage(damage);
			System.out.printf("You cast weaken on the %s for %d damage\n",monster.getName(), damage);
			this.mana -= 3;
		}
		else
		{
			System.out.println("You need at least 3 mana to used magic");
		}
	}

	public void manaup()
	{
		this.mana += 1;
		System.out.println("You charge up a mana point.");
	}

	public void flee()
	{
		this.isFighting = false;
	}


	public void takeDamage(int damage)
	{
		if (damage < this.health)
		{
			this.health -= damage;
		}
		else
		{
			this.health = 0;
		}
	}

	public String toString()
	{
		return String.format("[Player] HP:%d, STR:%d, MANA:%d, LVL:%d",health,strength,mana,level);
	}

	public void levelup(int xp)
	{
		this.level += xp;
		this.strength += (int)(Math.random() * xp) + 1;
		this.mana += (int)(Math.random() * xp)+3;
		this.health += (int)(Math.random() * xp) * 10 + 50;
		System.out.println("You leveled up!"); 
	}
}