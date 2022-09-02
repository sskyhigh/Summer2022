import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        int lower = 0, upper = 0, characters = 0;
        char symbol;
        Scanner sc = new Scanner(new File("data6.txt"));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                symbol = line.charAt(j);
                if(Character.isDigit(symbol)){
                    symbol = 'X';
                }
                else if(Character.isLetter(symbol)){
                    if(Character.isLowerCase(symbol)){
                        symbol = Character.toUpperCase(symbol);
                        lower++;
                    }else{
                        upper++;
                    }
                }
                System.out.print(symbol);
                characters++;
            }
            System.out.println();
        }
        System.out.printf("%d\t%d\t%d%n", lower, upper, characters);
    }
}
