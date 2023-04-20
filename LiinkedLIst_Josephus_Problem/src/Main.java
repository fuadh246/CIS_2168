import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Alamin");

//        System.out.println("enter the num");
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
        int num = 12345;
        int sum =0;
        while (num!=0){
            sum += (num%10);
            num =num/10;
        }
        System.out.println(sum);

    }
}