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
public class TacticHeavy extends Tactic {

	@Override
	protected int damage(Colony colony) {
		if (colony.getPopulation() < 3)
		{
			if (rand.nextInt(5) == 0)
				return (1000);
			return (rand.nextInt(3));
		}
		return (rand.nextInt(1001));
	}

}
