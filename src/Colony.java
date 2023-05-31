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
import java.util.Random;

public class Colony {

    private char symbol;
    private long population;
    private long food;
    private int win;
    private int lose;

    private Production production;
    private Tactic tactic;
    
    private static String symbTable = "!\"#$%&'()*+,-./:;<=>@[\\]^_`~";
    private static char[] usedTable = new char[28];
    private static Random rand = new Random();

    public static char randSymbol() {
        char rt = '\0';
        boolean isFound = false;
        for (int i = 0; i < 28; i++) {
            int num = rand.nextInt(28);
            if (usedTable[num] == '\0') {
                rt = symbTable.charAt(num);
                usedTable[num] = rt;
                isFound = true;
                break;
            }
        }
        if (!isFound)
        	rt = 'X';
        return rt;
    }
    

    public Colony(long population) {
        this.setSymbol(randSymbol());
        this.setPopulation(population);
        this.setFood(population * population);
        this.setWin(0);
        this.setLose(0);
        switch (rand.nextInt(2))
        {
            case 0:
                this.setTactic(new TacticFast());
                break;
            case 1:
                this.setTactic(new TacticHeavy());
                break;
        }
        switch (rand.nextInt(2))
        {
            case 0:
                this.setProduction(new ProductionIndustrial());
                break;
            case 1:
                this.setProduction(new ProductionCumulative());
                break;
        }
    }

    public int getDamage() {
        return this.tactic.damage(this);
    }

    public void produce() {
    	this.food += this.production.produce(this);
    }

    public void multiply() {
    	this.population = this.population + ((this.population * 20) / 100);
    }

    public void eat() {
        this.food = this.food - (this.population * 2);
        if (this.food <= 0) {
            this.food = 0;
            this.population = 0;
            System.out.println("Koloni " + this.symbol + " yemek stogu bittigi icin yikildi!");
        }
    }

    public boolean isAlive() {
        if (this.population <= 0 || this.food <= 0)
        {
        	this.food = 0;
        	this.population = 0;
        	return false;
        }
        return true;
    }

    public void print() {
        System.out.print(this.symbol + "\t\t");;
        if (this.isAlive()) {
            System.out.print(this.population + "\t\t");
            System.out.print(this.food + "\t\t\t");
            System.out.print(this.win + "\t\t");
            System.out.print(this.lose + "\t\t");
        } else {
            System.out.print("--\t\t");
            System.out.print("--\t\t\t");
            System.out.print("--\t\t");
            System.out.print("--\t\t");
        }
    }

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public long getFood() {
		return food;
	}

	public void setFood(long food) {
		this.food = food;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public Tactic getTactic() {
		return tactic;
	}

	public void setTactic(Tactic tactic) {
		this.tactic = tactic;
	}

}