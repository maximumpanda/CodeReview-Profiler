public class ReverseName {
    private String OriginalName = "steven hirschmann";
    private String ReversedName = "";

    public ReverseName(){}
    public ReverseName(String originalName){
        this.OriginalName = originalName;
    }
    public void SetOriginalName(String name){
        this.OriginalName = name;
    }
    public void PrintReversedName(){
        Console.WriteLine(ReversedName);
    }
    public void PrintName(){
        Console.WriteLine(OriginalName);
    }
    public void ReverseWithSplit() {
        String[] splitName = OriginalName.split(" ");
        String reversedName = "";
        for(int x = 1; x <= splitName.length; x++)
        {
            if (x!=1)reversedName = reversedName + " " + splitName[splitName.length - x];
            else reversedName = splitName[splitName.length-x];
        }
        this.ReversedName = reversedName;
    }
    public void ReverseWithSubstring() {
        int spacePosition = OriginalName.indexOf(" ");
        String firstName = OriginalName.substring(0, spacePosition);
        String lastName = OriginalName.substring(spacePosition + 1);
        this.ReversedName = lastName + " " + firstName;
        Console.WriteLine(this.ReversedName);
    }
}
