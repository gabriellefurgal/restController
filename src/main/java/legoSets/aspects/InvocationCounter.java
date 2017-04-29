package legoSets.aspects;

/**
 * Created by Siekacz on 08.04.2017.
 */
public class InvocationCounter {

    private static InvocationCounter instance = null;
    private static int counter = 0;

    protected InvocationCounter(){}
    public static InvocationCounter getInstance(){
        if(instance == null)
            instance = new InvocationCounter();
        return instance;
    }

    public static int getCounter() {
        return counter;
    }

//    public static void setCounter(int counter) {
//        InvocationCounter.counter = counter;
//    }

    public void increment(){
        counter++;
    }
}
