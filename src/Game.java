/**
*
* @author Mustafa Karadeniz mustafa.karadeniz1@ogr.sakarya.edu.tr
* @since 30.05.23
* <p>
* 2. Ogretim B grubu
* G211210066
* Mustafa Karadeniz
* </p>
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {

	private int size;
	private int turnNum;
	private boolean displayWar;
	private List<Colony> colonies;

	public Game(String input, boolean displayWar) {
		this.turnNum = 0;
		this.colonies = new ArrayList<>();

		String[] splitInput = input.split(" ");
		for (String num : splitInput) {
			long population = Long.parseLong(num);
			if (population <= 0) {
				throw new IllegalArgumentException("Population can't be zero or less!");
			}
			this.colonies.add(new Colony(population));
		}
		this.size = colonies.size();
		this.displayWar = displayWar;
	}

	public void loop() {
		print();
		while (check()) {
			turn();
		}
	}

	public void turn() {
		turnNum++;
		produce();
		multiply();
		eat();
		fightAll();
		print();
		System.out.println("\nSonraki tur icin enter tusuna basiniz!");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearConsole();
	}

	public void produce() {
		for (Colony colony : colonies) {
			if (colony.isAlive()) {
				colony.produce();
			}
		}
	}

	public void multiply() {
		for (Colony colony : colonies) {
			if (colony.isAlive()) {
				colony.multiply();
			}
		}
	}

	public void eat() {
		for (Colony colony : colonies) {
			if (colony.isAlive()) {
				colony.eat();
			}
		}
	}

	public void fightAll() {
		for (int i = 0; i < size; i++) {
			for (int s = i + 1; s < size; s++) {
				if (colonies.get(i).isAlive() && colonies.get(s).isAlive()) {
					fight(colonies.get(i), colonies.get(s));
				}
			}
		}
	}

	public void fight(Colony colony_a, Colony colony_b) {
		int diff = colony_a.getDamage() - colony_b.getDamage();
		
		if (this.displayWar)
			System.out.println("Koloni " + colony_a.getSymbol() + " VS Koloni " + colony_b.getSymbol() + " diff: " + diff);

		if (diff > 0) {
			colony_b.setPopulation(colony_b.getPopulation() - ((colony_b.getPopulation() * diff) / 1000));
			colony_a.setFood(colony_a.getFood() + ((colony_b.getFood() * diff) / 1000));
			colony_b.setFood(colony_b.getFood() - ((colony_b.getFood() * diff) / 1000));
			colony_a.setWin(colony_a.getWin() + 1);
			colony_b.setLose(colony_b.getLose() + 1);
			
			if (this.displayWar)
			{
				System.out.println("Koloni " + colony_a.getSymbol() + " kazandi");
				System.out.println("Koloni " + colony_b.getSymbol() + " kaybetti\n");
			}
			
		}

		else if (diff < 0) {
			diff = diff * -1;
			colony_a.setPopulation(colony_a.getPopulation() - ((colony_a.getPopulation() * diff) / 1000));
			colony_b.setFood(colony_b.getFood() + ((colony_a.getFood() * diff) / 1000));
			colony_a.setFood(colony_a.getFood() - ((colony_a.getFood() * diff) / 1000));
			colony_b.setWin(colony_b.getWin() + 1);
			colony_a.setLose(colony_a.getLose() + 1);

			if (this.displayWar) 
			{
				System.out.println("Koloni " + colony_b.getSymbol() + " kazandi");
				System.out.println("Koloni " + colony_a.getSymbol() + " kaybetti\n");
				
			}
			
		}

		else {

			if (this.displayWar)
				System.out.println("BERABERLIK!(populasyonlara gore kazanan belirlendi)\n");

			if (colony_a.getPopulation() > colony_b.getPopulation()) {
				colony_a.setWin(colony_a.getWin() + 1);
				colony_b.setLose(colony_b.getLose() + 1);
			} else {
				colony_b.setWin(colony_b.getWin() + 1);
				colony_a.setLose(colony_a.getLose() + 1);
			}

		}

		if (!(colony_a.isAlive())) {
			if (this.displayWar)
				System.out.println("Koloni " + colony_a.getSymbol() + " savasta kaybettigi icin yikildi !\n");
		}

		if (!(colony_b.isAlive())) {
			if (this.displayWar)
				System.out.println("Koloni " + colony_b.getSymbol() + " savasta kaybettigi icin yikildi !\n");
		}

	}

	public void print() {
		System.out.println("Turn: " + turnNum);
		System.out.println("Koloni\t\tPopulasyon\t\tYemek\t\t\tKazanma\t\tKaybetme");
		for (Colony colony : colonies) {
			colony.print();
			System.out.println();
		}
	}

	public boolean check() {
		int aliveColonies = 0;
		Colony lastAlive = null;
		for (Colony colony : colonies) {
			if (colony.isAlive()) {
				aliveColonies++;
				lastAlive = colony;
			}
		}
		if (aliveColonies == 0 || aliveColonies == 1) {
			if (lastAlive != null && lastAlive.isAlive()) {
				System.out.println("\n\nKazanan koloni: " + lastAlive.getSymbol() + "\n\n");
			}
			return false;
		}
		return true;
	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
