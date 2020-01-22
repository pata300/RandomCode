
public class Monster{

	private String name;
	private int health;
	private int strength;
	private int xp;

	public Monster(String name, int health, int strength, int xp){

		this.name = name;
		this.health = health;
		this.strength = strength;
		this.xp = xp;

	}

	public void attack(Hero hero){

		hero.takeDamage(strength);

		System.out.printf("%s attacks player for %d damage", name, strength);

	}

	public int getHealth(){

		return health;

	}

	public String getName(){

		return name;

	}

	public int getStrength(){

		return strength;

	}

	public int getXP(){

		return xp;

	}

	static Monster spawn(String type){

		Monster newMonster = null;

		if(type == "goblin"){

			newMonster = new Monster("goblin", 60, 8, 1);

		} else if(type == "orc"){

			newMonster = new Monster("orc", 100, 12, 3);

		} else if(type == "troll"){

			newMonster = new Monster("troll", 150, 15, 5);

		} else System.out.println("Invalid Monster");
		
		return newMonster;

	}

	public void takeDamage(int damage){

		if(health - damage > 0){

			health -= damage;

		} else if (health - damage <= 0){

			health = 0;

		}

	}

	public String toString(){

		String monsterState = String.format("[%s] HP: %d, STR: %d", name, health, strength);

		return monsterState;

	}

}