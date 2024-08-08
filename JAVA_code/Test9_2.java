import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test9_2 {
    public static void main(String[] args) {
        String fileName = "d.txt";
        try {
            int whiteSpacesCount = 0;
            int wordsCount = 0;
            int punctuationsCount = 0;

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                whiteSpacesCount += line.length() - line.replaceAll(" ", "").length();

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.matches(".*[.,!?]")) {
                        punctuationsCount++;
                    }
                }
                wordsCount += words.length;
            }

            bufferedReader.close();

            System.out.println("Number of embedded white spaces: " + whiteSpacesCount);
            System.out.println("Number of words: " + wordsCount);
            System.out.println("Number of punctuations: " + punctuationsCount);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
