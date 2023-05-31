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

public abstract class Production {
	protected static Random rand = new Random();
	
	protected abstract long produce(Colony colony);
}
