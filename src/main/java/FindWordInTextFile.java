import java.io.*;
import java.util.Scanner;

public class FindWordInTextFile {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        File file = new File("sample.txt");
//        System.out.println("Please enter the filename: ");
//        String filename = scan.nextLine();
        System.out.println("Please enter a word: "); // Hint: try to find "lorem"
        String wordName = scan.nextLine();

        int count = 0;
        try (LineNumberReader r = new LineNumberReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null) {
                for (String element : line.split(" ")) {
                    if (element.equalsIgnoreCase(wordName)) {
                        count++;
                    }
                }
            }
        }
        System.out.println("The word " + wordName + " appears " + count + " times.");
    }
}
