import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Number of cases you want to try: ");
        int cases = scanner.nextInt();

        for (int i = 1; i <= cases; i++) {
          
            System.out.print("Case " + i + ": Enter n" + i + ": ");
            int n = scanner.nextInt();

          
            StringBuilder series = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                series.append(j);
                if (j < n) {
                    series.append("+");
                }
            }

          
            int sum = n * (n + 1) / 2;

        
            System.out.println(series + " = " + sum);
        }

        scanner.close();
    }
}
