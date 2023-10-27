package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        try {
            throw new Exception();
        } catch (Throwable throwable) {
            StackTraceElement previous = throwable.getStackTrace()[1];
            return new CallingInfo(previous.getClassName(), previous.getMethodName());
        }
    }
}
