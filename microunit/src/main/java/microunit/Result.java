package microunit;

/**
 * Represents a test result
 *
 */
public class Result {
    /**
     * Stores the number of successful method invocations
     */
    private int numberOfSuccess;
    private int numberOfFailures;
    private int numberOfErrors;
    public void onError(){
        numberOfErrors++;
    }
    public void onFailures(){
        numberOfFailures++;
    }
    public void onSuccess(){
        numberOfSuccess++;
    }

    @Override
    public String toString() {
        return "Result{" +
                "numberOfSuccess=" + numberOfSuccess +
                ", numberOfFailures=" + numberOfFailures +
                ", numberOfErrors=" + numberOfErrors +
                '}';
    }
}
