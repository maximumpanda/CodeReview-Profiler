package Models;

/**
 * Created by Steven Hirschmann on 12/6/2015.
 */
public class RefinedCall {
    public String BaseClassName = null;
    public String BaseClassParameters = null;
    public String MethodName = null;
    public String MethodParameters = null;
    private int PositionOfClassPeriod = 0;

    public RefinedCall(String call){
        this.PositionOfClassPeriod = FindClassPeriod(call);
        this.BaseClassName = FindBaseClassName(call);
        this.BaseClassParameters = FindParameters(call, 0, this.PositionOfClassPeriod);
        this.MethodName = FindMethodName(call);
        this.MethodParameters = FindParameters(call, this.PositionOfClassPeriod, call.length());
    }
    private int FindClassPeriod(String call){
        int classPeriod = call.indexOf(").") + 1;
        if (classPeriod == 0){
            classPeriod = call.indexOf(".");
        }
        return classPeriod;
    }
    private String FindBaseClassName(String call){
        String className = call.substring(0, this.PositionOfClassPeriod);
        if (className.contains("(")) {
            className = className.substring(0, className.indexOf("("));
        }
        return className;
    }
    private String FindParameters(String call, int startPosition, int stopPosition){
        String section = call.substring(startPosition, stopPosition);
        int posOfOpenParentheses = section.indexOf("(");
        int posOfCloseParentheses = section.indexOf(")");
        if (posOfCloseParentheses - posOfOpenParentheses <= 1) return null;
        return section.substring(posOfOpenParentheses + 1, posOfCloseParentheses);
    }
    private String FindMethodName(String call){
        int posOfClassPeriod = call.indexOf(".", this.PositionOfClassPeriod);
        int posOfParentheses = call.indexOf("(", this.PositionOfClassPeriod);
        return call.substring(posOfClassPeriod + 1, posOfParentheses);
    }
}
