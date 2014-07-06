import java.util.*;

public class Game {
	
	private String name;
	public static String winner;
	
	public static void main(String[] args) {
		
		Avatar p1 = new Avatar();
		Avatar p2 = new Avatar();
		
		p1.setHealth(100);
		p1.setElement("Water");
		
		p2.setHealth(100);
		p2.setElement("Water");
		
		for(int k = 0; k <= 10; k++) {
			
			// If any players health goes below Zero stop the game
			if((p1.getHealth() > 0) && (p2.getHealth() > 0)) {
			
				System.out.println("");
				System.out.println("=== GAME #" + (k+1) + " ==========================");
				System.out.println("");
			
				// Players Random Attack Sequence
				p1.setAttack(RandomSequence.attackSequence());
				p2.setAttack(RandomSequence.attackSequence());
				
				// Check Attack Sequence match Winner
				int[] attackResult =  CompareAttacks.checkWinner(p1.getAttack(), p2.getAttack());
				
				System.out.println("======== ATTACKS ==========");
				System.out.println(Arrays.toString(p1.getAttack()) + ": p1");
				System.out.println(Arrays.toString(p2.getAttack()) + ": p2");
				
				System.out.println("======== WINNERS ==========");
				System.out.println(Arrays.toString(attackResult));
				
				System.out.println("======== DAMAGE ===========");
				
				int basicDamage = 8;
				int streakDamage = 3;
				int tieDamage = 4;
				int lastValue = attackResult[0];
				int currentLength = 1;
				
				for(int i = 0; i <= 8; i++) {
					
					int p1BonusDamage = 0;
					int p2BonusDamage = 0;
					
					// Skip the first win
					if(i != 0) {
						
						// Calculate streak bonus damage
						if(lastValue == attackResult[i]){
							currentLength++;
						} else {
							currentLength = 1;
						}
						
						lastValue = attackResult[i];
						
						if((currentLength >= 2) && (attackResult[i] != 0)){
							if(attackResult[i] == 1) {
								p1BonusDamage = (currentLength-1) * streakDamage;
							} else if(attackResult[i] == 2) {
								p2BonusDamage = (currentLength-1) * streakDamage;
							}
						}
						
					}
					
					if(attackResult[i] == 1) {
						
						// Player 1 streak win do damage to Player 2
						int finalDamage = basicDamage + p1BonusDamage;
						
						p2.setHealth(p2.getHealth() - finalDamage);
						
						System.out.println("p1 does " + finalDamage + " Damage :: p2 Health = " + Integer.toString(p2.getHealth()));
						
						// check health
						if(p2.getHealth() <= 0) {
							System.out.println("Player 2 DEAD");
							break;
						}
						
					} else if(attackResult[i] == 2) {
						
						// Player 2 streak win do damage to Player 1
						int finalDamage = basicDamage + p2BonusDamage;
						
						p1.setHealth(p1.getHealth() - finalDamage);
						
						System.out.println("p2 does " + finalDamage + " Damage :: p1 Health = " + Integer.toString(p1.getHealth()));
						
						// check health
						if(p1.getHealth() <= 0) {
							System.out.println("Player 1 DEAD");
							break;
						}
						
					} else {
						
						// Tie - Do damage based on Avatar Element
						if((p1.getElement() == "Water") && (p2.getElement() == "Earth") ||
							(p1.getElement() == "Fire") && (p2.getElement() == "Water") || 
							(p1.getElement() == "Earth") && (p2.getElement() == "Fire")) {
							
							p1.setHealth(p1.getHealth() - tieDamage);
							System.out.println("p2 does " + tieDamage + " Damage :: p1 Health = " + Integer.toString(p1.getHealth()));
							
							// check health
							if(p1.getHealth() <= 0) {
								System.out.println("Player 1 DEAD");
								break;
							}
							
						} else if((p2.getElement() == "Water") && (p1.getElement() == "Earth") ||
							(p2.getElement() == "Fire") && (p1.getElement() == "Water") || 
							(p2.getElement() == "Earth") && (p1.getElement() == "Fire")) {
							
							p2.setHealth(p2.getHealth() - tieDamage);
							System.out.println("p1 does " + tieDamage + " Damage :: p2 Health = " + Integer.toString(p2.getHealth()));
							
							// check health
							if(p2.getHealth() <= 0) {
								System.out.println("Player 2 DEAD");
								break;
							}
							
						} else if(p1.getElement() == p2.getElement()){
							
							System.out.println("No Damage");
							
						}
						
					}
					
				}
			
			} 
		
		}
		
		System.out.println("======== RESULT ===========");
		System.out.println("p1 Health = " + p1.getHealth());
		System.out.println("p2 Health = " + p2.getHealth());
			
	}
	
}








