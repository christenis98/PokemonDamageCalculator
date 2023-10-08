package ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Movement[] charizardMovements = {new Movement("Dragon claw", 80), new Movement("Ember", 40), new Movement("Heat wave", 95), new Movement("Flare Blitz", 120)};
		Movement[] blastoiseMovements = {new Movement("Ice Beam", 90), new Movement("Hydro Pump", 130), new Movement("Skull Bash", 130), new Movement("Hydor Cannon", 90)};
		
		
		//(int level, String name, Type type, int totalHp, int baseAtk, int baseSpAtk, int baseSpDef, int baseDef, int baseSpeed, int nMovements, Movement[] movements)
		Pokemon charizard = new Pokemon(1, "Charizard", Type.FUEGO, 78, 84, 109, 85, 78, 100, 4, charizardMovements);
		Pokemon blastoise = new Pokemon(1,"Blastoise", Type.AGUA, 79, 83, 85, 105, 100, 78, 4, blastoiseMovements);
		//Vamos a usar este pokemon de rival
		Pokemon bulbasaur = new Pokemon(1,"Bulbasaur", Type.PLANTA, 45, 49, 65, 65, 49, 45, 4, new Movement[] {new Movement("Látigo Cepa", 55),
                new Movement("Placaje", 40),
                new Movement("Gruñido", 0),
                new Movement("Toxina", 0)});
		
		List<Pokemon> pokemonsDisponibles = new ArrayList<>();
		pokemonsDisponibles.add(charizard);
		pokemonsDisponibles.add(blastoise);

		//Aqui empieza la pequeña IU por consola
		while(bulbasaur.getActualHP() > 0) {
			System.out.println("Pokémon disponibles:");
	        for (int i = 0; i < pokemonsDisponibles.size(); i++) {
	            Pokemon pokemon = pokemonsDisponibles.get(i);
	            System.out.println((i + 1) + ". " + pokemon.getName());
	        }
	        
	        System.out.print("Selecciona un Pokémon (1-" + pokemonsDisponibles.size() + "): ");
	        int seleccionPokemon = scanner.nextInt();
	        
	        // Validar la selección del usuario
	        if (seleccionPokemon < 1 || seleccionPokemon > pokemonsDisponibles.size()) {
	            System.out.println("Selección no válida. Saliendo del programa.");
	            System.exit(0);
	        }
	        
	        Pokemon pokemonElegido = pokemonsDisponibles.get(seleccionPokemon - 1);
	        
	        // Mostrar estadísticas y movimientos del Pokémon elegido
	        System.out.println("\nEstadísticas de " + pokemonElegido.getName() + ":");
	        System.out.println("Tipo: " + pokemonElegido.getType().getName());
	        System.out.println("Vida: " + pokemonElegido.getTotalHp());
	        System.out.println("Ataque: " + pokemonElegido.getBaseAtk());
	        System.out.println("Defensa: " + pokemonElegido.getBaseDef());
	        System.out.println("Nivel: " + pokemonElegido.getLevel());
	        
	        // Mostrar estadísticas del Pokémon rival (Bulbasaur)
	        
	        System.out.println("\nEstadísticas del rival " + bulbasaur.getName() + ":");
	        System.out.println("Tipo: " + bulbasaur.getType().getName());
	        System.out.println("Vida: " + bulbasaur.getActualHP());
	        System.out.println("Ataque: " + bulbasaur.getBaseAtk());
	        System.out.println("Defensa: " + bulbasaur.getBaseDef());
	        System.out.println("Nivel: " + bulbasaur.getLevel());
	        
	        System.out.println("\nMovimientos de " + pokemonElegido.getName() + ":");
	        Movement[] movimientos = pokemonElegido.getMovements();
	        for (int i = 0; i < movimientos.length; i++) {
	            System.out.println((i + 1) + ". " + movimientos[i].getName()+ " (Poder: " + movimientos[i].getPower() + ")");
	        }
	        
	
	        
	        // Elegir un movimiento
	        System.out.print("\nSelecciona un movimiento (1-" + movimientos.length + "): ");
	        int seleccionMovimiento = scanner.nextInt();
	
	        // Validar la selección del movimiento
	        if (seleccionMovimiento < 1 || seleccionMovimiento > movimientos.length) {
	            System.out.println("Selección no válida. Saliendo del programa.");
	            System.exit(0);
	        }
	        
	        
	        Movement movimientoElegido = movimientos[seleccionMovimiento - 1];
	
	        // Simular el cálculo de daño
	        
	        double damage = calcularDamage(pokemonElegido, bulbasaur ,movimientoElegido.getPower());
	
	        System.out.println("\n" + pokemonElegido.getName() + " usó " + movimientoElegido.getName() + " y causó " + damage + " puntos de daño al rival.");
	
	        // Actualizar la vida del rival según el daño
	        
	        bulbasaur.setActualHP(bulbasaur.getActualHP() - damage);
	
	        // Mostrar estadísticas del Pokémon rival (Bulbasaur)
	        
	        System.out.println("\nEstadísticas del rival " + bulbasaur.getName() + ":");
	        System.out.println("Tipo: " + bulbasaur.getType().getName());
	        System.out.println("Vida: " + bulbasaur.getActualHP());
	        System.out.println("Ataque: " + bulbasaur.getBaseAtk());
	        System.out.println("Defensa: " + bulbasaur.getBaseDef());
	        System.out.println("Nivel: " + bulbasaur.getLevel());
		}
		
		System.out.println("\nHas matado al rival " );
        
	}

	
	
    public static double calcularDamage(Pokemon atacante, Pokemon rival, int poderMovimiento) {
        // Obtener valores necesarios para la fórmula
        int nivelAtacante = atacante.getLevel();
        int ataqueAtacante = atacante.getBaseAtk();  /*Cuando hay que usar ataque especial??*/
        int defensaRival = rival.getBaseDef();
        double efectividadMovimiento = atacante.getType().getEfectividad(rival.getType());
        int randomFactor = obtenerRandomFactor();

        // Calcular el daño según la fórmula dada
        double damage = (((2.0 * nivelAtacante / 5.0 + 2) * ataqueAtacante * poderMovimiento / defensaRival) / 50.0) * efectividadMovimiento * randomFactor / 100.0;

        return damage;
    }
    
    public static int obtenerRandomFactor() {
        // Generar un número entero aleatorio entre 85 y 100
        Random random = new Random();
        return random.nextInt(16) + 85;
    }
}
