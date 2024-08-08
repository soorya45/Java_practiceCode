package el;
import el.add.Addition;
import el.sub.Subtraction;
import el.mul.Multiplication;
import el.div.Division;
public class Test_add_sub_mul_div {
    public static void main(String[] args) {
        double num1 = 80.9;
        double num2 = 67.1; 
        double a = Addition.add(num1, num2);
        System.out.println("Addition result: " + a);

        double b = Subtraction.subtract(num1, num2);
        System.out.println("Subtraction result: " + b);

        double c = Multiplication.multiply(num1, num2);
        System.out.println("Multiplication result: " + c);

        double d = Division.divide(num1, num2);
        System.out.println("Division result: " + d);
        
        
        System.out.println("Sam");
    }
}
