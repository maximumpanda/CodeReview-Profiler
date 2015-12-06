import Models.Parameters;
import Models.RefinedCall;

import java.lang.reflect.Method;

public class MethodCall {
    Class<?> BaseClass = null;
    Parameters BaseClassParameters;
    java.lang.reflect.Method Method = null;
    Parameters MethodParameters;

    public MethodCall(String call) {
        this.ParseMethodCall(call);
    }
    public void ParseMethodCall(String call) {
        try {
            RefinedCall refinedCall = new RefinedCall(call);
            this.BaseClass = this.ParseBaseClass(refinedCall.BaseClassName);
            this.BaseClassParameters = this.ParseParameters(refinedCall.BaseClassParameters);
            this.MethodParameters = this.ParseParameters(refinedCall.MethodParameters);
            this.Method = this.ParseMethod(refinedCall.MethodName);
        } catch (Exception ex) {
            Console.WriteLine("invalid call");
        }
    }
    private Class<?> ParseBaseClass(String className) throws Exception {
        return Class.forName(className);
    }
    private Parameters ParseParameters(String rawParameters) {
        return this.ParseValues(rawParameters);
    }
    private Method ParseMethod(String methodName) throws Exception {
        return this.BaseClass.getMethod(methodName, this.MethodParameters.ParameterTypes);
    }
    private Class ParseType(String rawParameters) {
        return this.TryParseInt(rawParameters) ? Integer.TYPE : (this.TryParseDouble(rawParameters) ? Double.TYPE : String.class);
    }
    private boolean TryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException var3) {
            return false;
        }
    }
    private boolean TryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException var3) {
            return false;
        }
    }
    private Parameters ParseValues(String rawParameters) {
        Parameters tempParameters = new Parameters();
        if (rawParameters != null) {
            String[] refinedParameters = rawParameters.split(", ");
            tempParameters.ParameterTypes = new Class[refinedParameters.length];
            tempParameters.Parameters = new Object[refinedParameters.length];
            for (int i = 0; i <= refinedParameters.length - 1; ++i) {
                tempParameters.ParameterTypes[i] = this.ParseType(refinedParameters[i]);
                if (tempParameters.ParameterTypes[i] == Integer.TYPE) {
                    tempParameters.Parameters[i] = Integer.parseInt(refinedParameters[i]);
                }
                if (tempParameters.ParameterTypes[i] == Double.TYPE) {
                    tempParameters.Parameters[i] = Double.parseDouble(refinedParameters[i]);
                }
                if (tempParameters.ParameterTypes[i] == String.class) {
                    tempParameters.Parameters[i] = refinedParameters[i];
                }
            }
        }
        return tempParameters;
    }
}