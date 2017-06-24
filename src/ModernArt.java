import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Young on 6/24/2017.
 */
public class ModernArt {

    private int[][] art;
    // tracking numbers 1-9
    private int[] numbers;
    // final count
    int count;

    public ModernArt(int[][] art) {
        this.art = art;
        this.numbers = new int[9]; // must subtract one index to track a specific number
        Arrays.fill(this.numbers, 0);
        this.count = 0;
        trackNumbers();
        determineCount();
    }

    /*
    Counts how many of each number there is on the artpiece
     */
    private void trackNumbers() {
        for (int i = 0; i < this.art.length; i++) {
            for (int j = 0; j < this.art[i].length; j++) {
                if (art[i][j] == 1) {
                    this.numbers[0]++;
                } else if (art[i][j] == 2) {
                    this.numbers[1]++;
                } else if (art[i][j] == 3) {
                    this.numbers[2]++;
                } else if (art[i][j] == 4) {
                    this.numbers[3]++;
                } else if (art[i][j] == 5) {
                    this.numbers[4]++;
                } else if (art[i][j] == 6) {
                    this.numbers[5]++;
                } else if (art[i][j] == 7) {
                    this.numbers[6]++;
                } else if (art[i][j] == 8) {
                    this.numbers[7]++;
                } else if (art[i][j] == 9) {
                    this.numbers[8]++;
                }
            }
        }
    }

    /*
    Determines the number that has the least amount on the artpiece.
     */
    private int leastAmountNumber() {
        int min = this.numbers[0];
        int number = 1;
        for (int i = 0; i < this.numbers.length; i++) {
            if (this.numbers[i] < min) {
                min = this.numbers[i];
                number = i;
            }
        }
        return number;
    }

    /*
    Sees if there are any other numbers that have the same frequency as number.
     */
    private void determineCount() {
        int number = leastAmountNumber();
        count++;
        for (int i = 0; i < this.numbers.length; i++) {
            if (i != number) {
                if (this.numbers[i] == this.numbers[number]) {
                    this.count++;
                }
            }
        }
    }

    public int getCount() {
        return this.count;
    }

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
