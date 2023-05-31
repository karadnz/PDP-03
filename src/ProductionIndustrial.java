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
public class ProductionIndustrial extends Production {

	@Override
	protected long produce(Colony colony) {
		if (colony.getWin() > colony.getLose())
			return (10);
		return (rand.nextLong(10));
	}

}
