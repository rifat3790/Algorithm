import java.util.Scanner;

public class PerimeterRectangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        double length = s.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = s.nextDouble();

        double PerimeterRectangle = 2 * (length + width);

        System.out.println("Perimeter Rectangle: "+PerimeterRectangle);
    }
}
