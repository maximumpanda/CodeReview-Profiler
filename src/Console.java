import java.util.Scanner;

public class Console {
    public static void WriteLine(Object value){
        System.out.println(value);
    }
    public static void Write(String value){
        System.out.print(value);
    }
    public static String ReadLine(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
