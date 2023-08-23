import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Word Counting Program");

        
        System.out.print("Enter 'text' to enter your own text or 'file' to provide a file: ");
        String inputType = sc.nextLine();

        String inputText = "";

        if (inputType.equalsIgnoreCase("text")) {
           
            System.out.print("Enter your text: ");
            inputText = sc.nextLine();
        } else if (inputType.equalsIgnoreCase("file")) {
            
            System.out.print("Enter the file path: ");
            String filePath = sc.nextLine();
            try {
                Scanner fileScanner = new Scanner(new File(filePath));
                while (fileScanner.hasNextLine()) {
                    inputText += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            System.out.println("Invalid input type.");
            return;
        }

        
        String[] words = inputText.split("[\\s\\p{Punct}]+");

        
        int wordCount = 0;

        
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }

        
        System.out.println("Total words: " + wordCount);

        
        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
