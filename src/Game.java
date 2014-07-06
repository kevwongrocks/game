import java.util.*;

public class Game {
	
	public static void main(String[] args) {
		
		Avatar p1 = new Avatar();
		Avatar p2 = new Avatar();
		
		p1.setHealth(100);
		p2.setHealth(100);
		
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
				
				// Do Attack Damage and Bonus Streak Damage
				damage.doDamage(attackResult, p1, p2);
				
			} 
		
		}
		
		System.out.println("======== RESULT ===========");
		System.out.println("p1 Health = " + p1.getHealth());
		System.out.println("p2 Health = " + p2.getHealth());
			
	}
	
}








