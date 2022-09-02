import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class homework6 {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream("Story.txt");
        final int size = 20;

        String[] arrayArticle = new String[size];
        String[] arrayNoun = new String[size];
        String[] arrayVerb = new String[size];
        String[] arrayPreposition = new String[size];

        // this can also determine the number of elements.
        int article = Article(arrayArticle);
        int noun = Noun(arrayNoun);
        int verb = Verb(arrayVerb);
        int preposition = Prep(arrayPreposition);

        String[] arrayCap = capitalizeFirst(arrayArticle, article);
        print(arrayCap, arrayNoun, arrayVerb, arrayArticle,
                arrayPreposition, article, noun, verb, preposition, ps);
    }

    public static int Article(String[] Article) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("updatedArticles.txt"));
        int i = 0;
        while (sc.hasNextLine()) {
            Article[i++] = sc.nextLine();
        }
        return i;
    }

    public static int Noun(String[] Noun) throws FileNotFoundException {
        Scanner noun = new Scanner(new File("updatedNouns.txt"));
        int i = 0;
        while (noun.hasNextLine()) {
            Noun[i++] = noun.nextLine();
        }
        return i;
    }

    public static int Verb(String[] Verb) throws FileNotFoundException {
        Scanner verb = new Scanner(new File("updatedVerbs.txt"));
        int i = 0;
        while (verb.hasNextLine()) {
            Verb[i++] = verb.nextLine();
        }
        return i;
    }

    public static int Prep(String[] Prep) throws FileNotFoundException {
        Scanner Preposition = new Scanner(new File("updatedPrep.txt"));
        int i = 0;
        while (Preposition.hasNextLine()) {
            Prep[i++] = Preposition.nextLine();
        }
        return i;
    }

    public static void print(String[] arrayCap, String[] arrayNoun,
                             String[] arrayVerb, String[] arrayArticle,
                             String[] arrayPreposition, int article,
                             int noun, int verb, int preposition,
                             PrintStream ps) {
        System.out.print("\t");
        ps.print("\t");
        for (int i = 1; i <= 10; i++) {
            System.out.print(randomGenerator(arrayCap, article) + " ");
            System.out.print(randomGenerator(arrayNoun, noun) + " ");
            System.out.print(randomGenerator(arrayVerb, verb) + " ");
            System.out.print(randomGenerator(arrayPreposition, preposition) + " ");
            System.out.print(randomGenerator(arrayArticle, article) + " ");
            System.out.print(randomGenerator(arrayNoun, noun) + ".");
            ps.print(randomGenerator(arrayCap, article) + " ");
            ps.print(randomGenerator(arrayNoun, noun) + " ");
            ps.print(randomGenerator(arrayVerb, verb) + " ");
            ps.print(randomGenerator(arrayPreposition, preposition) + " ");
            ps.print(randomGenerator(arrayArticle, article) + " ");
            ps.print(randomGenerator(arrayNoun, noun) + ".");
            if (i == 1) {
                System.out.print(" ");
                ps.print(" ");
            }
            if (i == 3) {
                System.out.print(" ");
                ps.print(" ");
            }
            if (i == 5) {
                System.out.println("\n");
                System.out.print("\t");
                ps.println("\n");
                ps.print("\t");
            }
            if (i == 7) {
                System.out.println("\n");
                ps.println("\n");
            }
            if (i == 9) {
                System.out.println("\n ");
                ps.println("\n");
            }
            if (i == 2) {
                System.out.println("\n");
                ps.println("\n");
            }
            if (i == 4) {
                System.out.println("\n");
                ps.println("\n");
            }
            if (i == 6) {
                System.out.print(" ");
                ps.print(" ");
            }
            if (i == 8) {
                System.out.print(" ");
                ps.print(" ");
            }
            if (i == 10) {
                System.out.println("\n");
                ps.println("\n");
            }
        }
    }

    public static String[] capitalizeFirst(String[] arr, int size) {
        String[] caps = new String[size];
        for (int i = 0; i < size; i++) {
            caps[i] = arr[i].substring(0, 1).toUpperCase()
                    + arr[i].substring(1);
        }
        return caps;
    }

    public static String randomGenerator(String[] arr, int number) {
        Random random = new Random();
        return arr[random.nextInt(number)];
    }
}
