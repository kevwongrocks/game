import java.util.*;

public class Game {
	
	// Set object parameters 
	private String name;
	public static String winner;
	
	public Game() {
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static int[] compareArrays(int[] array1, int[] array2) {
		
		int p1 = 0;
		int p2 = 0;
		int tie = 0;
		int[] attackCheck = new int[9];
		
		for(int i = 0; i <= 8; i++) {
			
			if(array1[i] == array2[i]){
				tie++;
				attackCheck[i] = 0;
			} else if ((array1[i] == 0) && (array2[i] == 1)) {
				p1++;
				attackCheck[i] = 1;
			} else if ((array1[i] == 1) && (array2[i] == 2)) {
				p1++;
				attackCheck[i] = 1;
			} else if  ((array1[i] == 2) && (array2[i] == 0)) {
				p1++;
				attackCheck[i] = 1;
			} else if ((array1[i] == 0) && (array2[i] == 2)) {
				p2++;
				attackCheck[i] = 2;
			} else if ((array1[i] == 1) && (array2[i] == 0)) {
				p2++;
				attackCheck[i] = 2;
			} else if  ((array1[i] == 2) && (array2[i] == 1)) {
				p2++;
				attackCheck[i] = 2;
			}
		}
		
		return attackCheck;

	}
	
	public static void main(String[] args) {
		
		Avatar p1 = new Avatar();
		Avatar p2 = new Avatar();
		
		p1.setHealth(100);
		p1.setElement("Water");
		
		p2.setHealth(100);
		p2.setElement("Water");
		
		for(int k = 0; k <= 2; k++) {
			
			System.out.println("================== GAME #" + (k+1) + "========================");
		
			p1.setAttack(RandomSequence.attackSequence());
			p2.setAttack(RandomSequence.attackSequence());
			
			int[] attackResult =  compareArrays(p1.getAttack(), p2.getAttack());
			
			System.out.println("======== ATTACKS ========");
			System.out.println(Arrays.toString(p1.getAttack()) + ": p1");
			System.out.println(Arrays.toString(p2.getAttack()) + ": p2");
			
			System.out.println("======== COMPARE ========");
			System.out.println(Arrays.toString(attackResult));
			
			System.out.println("======== DAMAGE =========");
			
			int basicDamage = 8;
			int tieDamage = 4;
			int lastValue = attackResult[0];
			int currentLength = 1;
			
			for(int i = 0; i <= 8; i++) {
				
				int p1BonusDamage = 0;
				int p2BonusDamage = 0;
				
				if(i != 0) {
					
					if(lastValue == attackResult[i]){
						currentLength++;
					} else {
						currentLength = 1;
					}
					
					lastValue = attackResult[i];
					
					if((currentLength >= 2) && (attackResult[i] != 0)){
						if(attackResult[i] == 1) {
							p1BonusDamage = (currentLength-1) * 2;
						} else if(attackResult[i] == 2) {
							p2BonusDamage = (currentLength-1) * 2;
						}
					}
					
				}
				
				if(attackResult[i] == 1) {
					
					int finalDamage = basicDamage + p1BonusDamage;
					
					p2.setHealth(p2.getHealth() - finalDamage);
					System.out.println("p1 does " + finalDamage + " Damage:: p2 Health = " + Integer.toString(p2.getHealth()));
					
				} else if(attackResult[i] == 2) {
					
					int finalDamage = basicDamage + p2BonusDamage;
					
					p1.setHealth(p1.getHealth() - finalDamage);
					System.out.println("p2 does " + finalDamage + " Damage:: p1 Health = " + Integer.toString(p1.getHealth()));
					
				} else {
					
					if((p1.getElement() == "Water") && (p2.getElement() == "Earth") ||
						(p1.getElement() == "Fire") && (p2.getElement() == "Water") || 
						(p1.getElement() == "Earth") && (p2.getElement() == "Fire")) {
						
						p1.setHealth(p1.getHealth() - tieDamage);
						System.out.println("p2 does " + tieDamage + " Damage:: p1 Health = " + Integer.toString(p1.getHealth()));
						
					} else if((p2.getElement() == "Water") && (p1.getElement() == "Earth") ||
						(p2.getElement() == "Fire") && (p1.getElement() == "Water") || 
						(p2.getElement() == "Earth") && (p1.getElement() == "Fire")) {
						
						p2.setHealth(p2.getHealth() - tieDamage);
						System.out.println("p1 does " + tieDamage + " Damage:: p2 Health = " + Integer.toString(p2.getHealth()));
						
					} else if(p1.getElement() == p2.getElement()){
						System.out.println("No Damage");
					}
					
				}
				
			}
		
		}
		
		System.out.println("======== RESULT =========");
		System.out.println("p1 Health = " + p1.getHealth());
		System.out.println("p2 Health = " + p2.getHealth());
	}
	
}








