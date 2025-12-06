import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();

       
        Circle circle = new Circle(r);

        
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area of Circle = " + circle.computeArea());

        sc.close();
    }
}
