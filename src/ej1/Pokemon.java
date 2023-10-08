package ej1;

public class Pokemon {

	private final int level;
	private final String name;
	private final Type type;
	private final double totalHp;
	private double actualHP;
	private final int baseAtk;
	private final int baseSpAtk;
	private final int baseSpDef;
	private final int baseDef;
	private final int baseSpeed;
	private int nMovements;
	private Movement movements[]= new Movement[4];
	
	
	public Pokemon(int level, String name, Type type, int totalHp, int baseAtk, int baseSpAtk,
			int baseSpDef, int baseDef, int baseSpeed, int nMovements, Movement[] movements) {
		super();
		this.level = level;
		this.name = name;
		this.type = type;
		this.totalHp = totalHp;
		this.actualHP = totalHp;
		this.baseAtk = baseAtk;
		this.baseSpAtk = baseSpAtk;
		this.baseSpDef = baseSpDef;
		this.baseDef = baseDef;
		this.baseSpeed = baseSpeed;
		this.nMovements = nMovements;
		this.movements = movements;
	}


	
	public int getLevel() {
		return level;
	}



	public String getName() {
		return name;
	}



	public Type getType() {
		return type;
	}


	public double getActualHP() {
		return actualHP;
	}


	public void setActualHP(double d) {
		this.actualHP = d;
	}


	public int getnMovements() {
		return nMovements;
	}


	public void setnMovements(int nMovements) {
		this.nMovements = nMovements;
	}


	public Movement[] getMovements() {
		return movements;
	}


	public void setMovements(Movement[] movements) {
		this.movements = movements;
	}


	public double getTotalHp() {
		return totalHp;
	}


	public int getBaseAtk() {
		return baseAtk;
	}


	public int getBaseSpAtk() {
		return baseSpAtk;
	}


	public int getBaseSpDef() {
		return baseSpDef;
	}


	public int getBaseDef() {
		return baseDef;
	}


	public int getBaseSpeed() {
		return baseSpeed;
	}

}
