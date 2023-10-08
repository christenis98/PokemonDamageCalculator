package ej1;

public class Type {
	private String name;
	private int index;
	
	//Constructor
	private Type(String n, int i){
		name = n;
		index = i;
	}
	
	
	//Tabla de efectividad
	
	private static final double[][] efectividad = { 
		//          	Acero    Agua   Bicho    Dragón  Eléctrico  Fantasma   Fuego    Hada    Hielo  Lucha  Normal  Planta  Psíquico 	Roca  Siniestro		Tierra  	Veneno  Volador
		 /* Acero */      {0.5,    0.5,    1.0,    1.0,     0.5,     1.0,     0.5,     2.0,		2.0,  	1.0,    1.0,    1.0,      1.0,  2.0,       1.0,   	1.0,		0.0,     1.0},
		 /* Agua */       {1.0,    0.5,    1.0,    0.5,     1.0,     1.0,     2.0,     1.0,    	1.0,  	1.0,    1.0,    0.5,      1.0,  2.0,       1.0,   	2.0,		1.0,     1.0},
		 /* Bicho */      {0.5,    1.0,    1.0,    1.0,     1.0,     0.5,     0.5,     0.5,    	1.0,  	0.5,    1.0,    2.0,      2.0,  1.0,       2.0,   	1.0,		0.5,     0.5},
		 /* Dragón */     {0.5,    1.0,    1.0,    2.0,     1.0,     1.0,     1.0,     0.0,    	1.0,  	1.0,    1.0,    1.0,      1.0,  1.0,       1.0,   	1.0,		1.0,     1.0},
		 /* Eléctrico */  {1.0,    2.0,    1.0,    0.5,     0.5,     1.0,     1.0,     1.0,    	1.0,  	1.0,    1.0,    0.5,      1.0,  1.0,       1.0,   	0.0,		1.0,     2.0},
		 /* Fantasma */   {1.0,    1.0,    1.0,    1.0,     1.0,     2.0,     1.0,     1.0,    	1.0,  	1.0,    0.0,    1.0,      2.0,  1.0,       0.5,   	1.0,		1.0,     1.0},
		 /* Fuego */      {2.0,    0.5,    2.0,    0.5,     1.0,     1.0,     0.5,     1.0,    	2.0,  	1.0,    1.0,    2.0,      1.0,  0.5,       1.0,   	1.0,		1.0,     1.0},
		 /* Hada */       {0.5,    1.0,    1.0,    2.0,     1.0,     1.0,     0.5,     1.0,    	1.0,  	2.0,    1.0,    1.0,      1.0,  1.0,       2.0,   	1.0,		0.5,     1.0},
		 /* Hielo */      {0.5,    0.5,    1.0,    2.0,     1.0,     1.0,     0.5,     1.0,    	0.5,  	1.0,    1.0,    2.0,      1.0,  1.0,       1.0,   	2.0,		1.0,     2.0},
		 /* Lucha */      {2.0,    1.0,    0.5,    1.0,     1.0,     0.0,     1.0,     0.5,    	2.0,  	1.0,    2.0,    1.0,      0.5,  2.0,       2.0,   	1.0,		0.5,     0.5},
		 /* Normal */     {0.5,    1.0,    1.0,    1.0,     1.0,     0.0,     1.0,     1.0,    	1.0,  	1.0,    1.0,    1.0,      1.0,  0.5,       1.0,   	1.0,		1.0,     1.0},
		 /* Planta */     {0.5,    2.0,    0.5,    0.5,     1.0,     1.0,     0.5,     1.0,    	1.0,  	1.0,    1.0,    0.5,      1.0,  2.0,       1.0,   	2.0,		0.5,     0.5},
		 /* Psíquico */   {0.5,    1.0,	   1.0,    1.0,     1.0,     1.0,     1.0,     1.0,    	1.0,  	2.0,    1.0,    1.0,      0.5,	1.0,	   0.0,		1.0,		2.0,	 1.0},
		 /* Roca */		  {0.5,	   1.0,	   2.0,    1.0,		1.0,	 1.0,	  2.0,	   1.0,		2.0,  	0.5,    1.0,	1.0,	  1.0,	1.0,	   1.0,		0.5,		1.0,     2.0},
		 /* Siniestro */  {1.0,    1.0,	   1.0,	   1.0,		1.0,	 2.0,	  1.0,	   0.5,		1.0,	0.5,	1.0,	1.0,	  2.0,	1.0,	   0.5,		1.0,		1.0,	 1.0},
		 /* Tierra */     {2.0,	   1.0,	   0.5,	   1.0,		2.0,	 1.0,	  2.0,	   1.0,		1.0,	1.0,	1.0,	0.5,	  1.0,	2.0,	   1.0,		1.0,		2.0,	 0.0},
		 /* Veneno */     {0.0,	   1.0,	   1.0,	   1.0,		1.0,	 0.5,	  1.0,	   2.0,		1.0,	1.0,	1.0,	2.0,	  1.0,	0.5,	   1.0,		0.5,		0.5,	 1.0},
		 /* Volador */    {0.5,	   1.0,	   2.0,	   1.0,		0.5,	 1.0,	  1.0,	   1.0,		1.0,	2.0,	1.0,	2.0,	  1.0,	0.5,	   1.0,		1.0,		1.0,	 1.0}
		 };
	
	
	public static final Type ACERO = new Type("Acero", 0);
	public static final Type AGUA = new Type("Agua", 1);
	public static final Type BICHO = new Type("Bicho", 2);
	public static final Type DRAGON = new Type("Dragón", 3);
	public static final Type ELECTRICO = new Type("Eléctrico", 4);
	public static final Type FANTASMA = new Type("Fantasma", 5);
	public static final Type FUEGO = new Type("Fuego", 6);
	public static final Type HADA = new Type("Hada", 7);
	public static final Type HIELO = new Type("Hielo", 8);
	public static final Type LUCHA = new Type("Lucha", 9);
	public static final Type NORMAL = new Type("Normal", 10);
	public static final Type PLANTA = new Type("Planta", 11);
	public static final Type PSIQUICO = new Type("Psíquico", 12);
	public static final Type ROCA = new Type("Roca", 13);
	public static final Type SINIESTRO = new Type("Siniestro", 14);
	public static final Type TIERRA = new Type("Tierra", 15);
	public static final Type VENENO = new Type("Veneno", 16);
	public static final Type VOLADOR = new Type("Volador", 17);
	
	
	public String getName(){
		return name;
	}
	
	public int getIndex(){
		return index;
	}
	
	//Efectividad de nuestro pokemon contra un tipo dado por parametro
	public double getEfectividad(Type t2){
		return efectividad[this.index][t2.getIndex()];
	}
	
	//Resistencia de nuestro pokemon contra un tipo dado por parametro
	public double getResistencia(Type t2){
		return efectividad[t2.getIndex()][this.index];
	}
	
	
	
	
}
