import java.io.*;
import java.util.*;

public class MathPuzzleApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter difficulty level (Easy/Medium/Hard): ");
        String difficulty = sc.nextLine().trim();

        int score = 0;

        File questionFile = new File("questions.txt");

       
        if (!questionFile.exists()) {
            try {
                FileWriter writer = new FileWriter(questionFile);
                writer.write("3 + 4 = ?,7,Easy\n");
                writer.write("5 - 2 = ?,3,Easy\n");
                writer.write("7 + 8 = ?,15,Easy\n");
                writer.write("9 + 6 = ?,15,Medium\n");
                writer.write("12 / 4 = ?,3,Medium\n");
                writer.write("8 * 3 = ?,24,Hard\n");
                writer.write("6 * 7 = ?,42,Hard\n");
                writer.close();
                System.out.println("questions.txt file created automatically.\n");
            } catch (IOException e) {
                System.out.println("Error creating questions file: " + e.getMessage());
                return;
            }
        }

      
        try {
            Scanner fileReader = new Scanner(questionFile);
            boolean anyQuestionAsked = false;

            System.out.println("\n=== Let's Start the Quiz ===\n");

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 3) continue;

                String question = parts[0].trim();
                String answerStr = parts[1].trim();
                String qDifficulty = parts[2].trim();

                
                if (!qDifficulty.equalsIgnoreCase(difficulty)) continue;

                anyQuestionAsked = true;

                System.out.print(question + " ");
                String input = sc.nextLine().trim();
                int userAnswer;
                int correctAnswer;

                try {
                    userAnswer = Integer.parseInt(input);
                    correctAnswer = Integer.parseInt(answerStr);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Skipping question.\n");
                    continue;
                }

                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer: " + correctAnswer + "\n");
                }
            }

            fileReader.close();

            if (!anyQuestionAsked) {
                System.out.println("No questions available for difficulty: " + difficulty);
            }

            
            try {
                FileWriter writer = new FileWriter("scores.txt", true); // append mode
                writer.write(name + " - Difficulty: " + difficulty + " - Score: " + score + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error saving score: " + e.getMessage());
            }

            System.out.println("Quiz Finished!");
            System.out.println("Your final score: " + score);
            System.out.println("Score saved to scores.txt");

        } catch (IOException e) {
            System.out.println("Error reading questions: " + e.getMessage());
        }

        sc.close();
    }
}