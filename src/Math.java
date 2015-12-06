public class Math {
    public void Divide(){
        Console.WriteLine("enter dividend");
        int dividend = Integer.parseInt(Console.ReadLine());
        int divisor = 0;
        while (!ValidateDivisor(divisor)) {
            Console.WriteLine("enter valid divisor");
            divisor = Integer.parseInt(Console.ReadLine());
        }
        Console.WriteLine(Double.toString(dividend / (double) divisor));
    }
    public static double Divide(int divisor, int dividend){
        return dividend/ (double)divisor;
    }
    private boolean ValidateDivisor(int divisor){
        if(divisor ==0) return false;
        return true;
    }
}
