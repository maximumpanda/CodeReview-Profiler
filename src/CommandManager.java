import java.lang.*;
import java.lang.Math;

public class CommandManager {
    boolean ExitRequested = false;

    public void Start() {
        Console.WriteLine("Please enter a command:");
        while(!ExitRequested) {
            ParseCommand(Console.ReadLine());
        }
    }
    private void ParseCommand(String command){
        switch(command.toLowerCase()){
            case("profile"):
                try {
                    Profile();
                }
                catch (Exception ex) {
                    Console.WriteLine(ex);
                }
                break;
            case("exit"):
                this.ExitRequested = true;
                break;
            case("help"):
                Help();
                break;
            default:
                Console.WriteLine("Command not recognized. type help to see a list of commands");
                break;
        }
    }
    private void Profile()throws Exception{
        Profiler profiler = new Profiler();
        Console.WriteLine("Enter Method call:");
        String call = Console.ReadLine();
        Console.WriteLine("Enter iterations:");
        int iterations = Integer.parseInt(Console.ReadLine());
        MethodCall testSubject = new MethodCall(call);
        profiler.Profile(testSubject.BaseClass.getConstructor(testSubject.BaseClassParameters.ParameterTypes)
                                    .newInstance(testSubject.BaseClassParameters.Parameters),
                                    testSubject.Method, testSubject.MethodParameters.Parameters , iterations);
    }
    private void Help(){
        Console.WriteLine("---Valid Commands---");
        Console.WriteLine("Profile");
        Console.WriteLine("--- valid profile commands");
        Console.WriteLine("--- Math.Divide(<int>, <int>)");
        Console.WriteLine("--- ReverseName.ReverseWithSubstring()");
        Console.WriteLine("--- ReverseName(<String>).ReverseWithSubstring()");
        Console.WriteLine("Exit");
        Console.WriteLine("Help");
    }
}