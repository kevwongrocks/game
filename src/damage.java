public class damage {
	
	public static void doDamage(int[] attackResult, Avatar p1, Avatar p2) {
	
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
				
				// Check Streak length
				if(lastValue == attackResult[i]){
					currentLength++;
				} else {
					currentLength = 1;
				}
				
				// Set the last attack
				lastValue = attackResult[i];
				
				// Calculate streak bonus damage
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
				System.out.println("No Damage");
				
			}
		
		}
		
	}
	
}
