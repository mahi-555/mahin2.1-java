import java.util.Scanner;

public class StudentCGPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Student ID: ");
        String id = sc.nextLine();

     
        System.out.print("No. of Courses: ");
        int n = sc.nextInt();

        int totalCreditTaken = 0;
        int totalCreditEarned = 0;
        double totalGradePoint = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nCourse " + i + ":");

            System.out.print("Credit (Max 3): ");
            int credit = sc.nextInt();

            System.out.print("CT (Max 30): ");
            int ct = sc.nextInt();

            System.out.print("AT (Max 10): ");
            int at = sc.nextInt();

            System.out.print("FE (Max 60): ");
            int fe = sc.nextInt();

            int totalMarks = ct + at + fe;

            double gp = 0;

       
            if (totalMarks >= 80) {
                gp = 4.0;
            } else if (totalMarks >= 75) {
                gp = 3.75;
            } else if (totalMarks >= 70) {
                gp = 3.50;
            } else if (totalMarks >= 65) {
                gp = 3.25;
            } else if (totalMarks >= 60) {
                gp = 3.00;
            } else if (totalMarks >= 55) {
                gp = 2.75;
            } else if (totalMarks >= 50) {
                gp = 2.50;
            } else if (totalMarks >= 45) {
                gp = 2.25;
            } else if (totalMarks >= 40) {
                gp = 2.00;
            } else {
                gp = 0.0;
            }

           
            totalCreditTaken += credit;

          
            if (gp > 0)
                totalCreditEarned += credit;

            totalGradePoint += gp * credit;
        }

      
        double cgpa = totalGradePoint / totalCreditTaken;

     
        String grade = "";

        if (cgpa == 4.0) grade = "A+";
        else if (cgpa >= 3.75) grade = "A";
        else if (cgpa >= 3.50) grade = "A-";
        else if (cgpa >= 3.25) grade = "B+";
        else if (cgpa >= 3.00) grade = "B";
        else if (cgpa >= 2.75) grade = "B-";
        else if (cgpa >= 2.50) grade = "C+";
        else if (cgpa >= 2.25) grade = "C";
        else if (cgpa >= 2.00) grade = "D";
        else grade = "F";

     
        System.out.println("\n------------------------------");
        System.out.println("Student ID: " + id);
        System.out.println("Credit Taken: " + totalCreditTaken);
        System.out.println("Credit Earned: " + totalCreditEarned);
        System.out.printf("CGPA: %.2f\n", cgpa);
        System.out.println("Grade: " + grade);
    }
}
