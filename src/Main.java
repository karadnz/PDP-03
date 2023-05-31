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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Koloni populasyonlarini giriniz:");
        String input = scanner.nextLine();
        
        System.out.println("Savas bilgilerini detayli olarak gormek ister misiniz?(y/n) : ");
        String userInput = scanner.nextLine().trim().toLowerCase();

        boolean displayWar = false;
        if (userInput.equals("y")) {
            System.out.println("OK");
            displayWar = true;
        }
          
        Game game = new Game(input, displayWar);
        game.loop();
        scanner.close();
    }
}
