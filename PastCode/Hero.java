public class Hero{

	private String name;
	private int health;
	private int originalHealth;
	private int strength;
	private int defense;
	private int xp;
	private int currentXP;
	private int level;

	public Hero(String name, int health, int strength, int defense, int xp){

		this.name = name;
		this.health = health;
		originalHealth = health;
		this.strength = strength;
		this.defense = defense;
		this.xp = xp;
		currentXP = 4;
		level = 1;

	}

	public void attack(Monster monster){

		monster.takeDamage(strength);

		System.out.printf("%s attacks player for %d damage", name, strength);

	}

	public int getHealth(){

		return health;

	}

	public void getHealed(){

		this.health = originalHealth;

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

	public int getCurrentXP(){

		return currentXP;

	}

	public int getLevel(){

		return level;
	}

	public void setXP(int xp){

		this.xp += xp;
		checkIfLvlUp();

	}

	public void takeDamage(int damage){

		if(health - damage > 0){

			health -= damage;

		} else if (health - damage <= 0){

			health = 0;

		}

	}

	public int getDefense(){

		return defense;

	}

	public void checkIfLvlUp(){

		if(xp >= currentXP)
			setStats(10, 2, 2);
	}

	public void setStats(int health, int str, int xp){

		originalHealth += health;
		//System.out.println("new health" + originalHealth);
		this.health = originalHealth;
		this.strength += str;
		this.currentXP *= xp;
		level++;

		System.out.println("You leveled up!");
		System.out.println("New Stats: " + this);

	}

	public String toString(){

		String heroState = String.format("[%s LVL %d] HP: %d, STR: %d, XP: %d [next lvl @ %d]", name, level, health, strength, xp, currentXP);

		return heroState;

	}

}