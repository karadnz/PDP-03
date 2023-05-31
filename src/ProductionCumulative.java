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
public class ProductionCumulative extends Production {

	@Override
	protected long produce(Colony colony) {
		if (colony.getFood() > 500)
			return (10);
		return (rand.nextLong(11));
	}

}
