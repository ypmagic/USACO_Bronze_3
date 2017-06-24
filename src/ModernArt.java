import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Young on 6/24/2017.
 */
public class ModernArt {
    public static void main(String[] args) {
        File input = new File("art.in");
        try {
            Scanner sc = new Scanner(input);
            int c = sc.nextInt();
            int[][] art = new int[c][c];
            for (int i = 0; i < c; i++) {
                String s = sc.next();
                for (int j = 0; j < s.length(); j++) {
                    art[i][j] = Integer.parseInt(s.substring(j, j+1));
                }
            }
        } catch (FileNotFoundException a) {
            System.out.println("File not found.");
        }
    }
}
