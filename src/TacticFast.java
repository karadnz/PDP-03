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
public class TacticFast extends Tactic {

	@Override
	protected int damage(Colony colony) {
		if (colony.getPopulation() == 1)
		{
			if (rand.nextInt(4) == 0)
				return (1000);
			return (rand.nextInt(5));
		}
		return (rand.nextInt(1001));
	}

}
