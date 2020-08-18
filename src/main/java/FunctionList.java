import java.util.*;

public class FunctionList {

    public FunctionList(View view, Alarm alarm, RandomDirectionGenerator rdg, RandomNumberGenerator rng, Stopwatch stopwatch
            ,Timer timer ,TimeKeeping timekeeping) {
        this.alarm = alarm;
        this.rdg = rdg;
        this.rng = rng;
        this.timekeeping = timekeeping;
        this.timer = timer;
        this.stopwatch = stopwatch;
    }
    public Alarm alarm;
    public RandomDirectionGenerator rdg;
    public RandomNumberGenerator rng;
    public TimeKeeping timekeeping;
    public Timer timer;
    public Stopwatch stopwatch;

    public int [] functionon = {1,2,3,4};




    public int getNextFunction(int currFunc) {
        // TODO implement here
        for(int i = 0; i < 4; i++) {
            System.out.println("Now funcs = "+functionon[i]);
        }
        for(int i = 0; i < 3; i++) {
            if(functionon[i] == currFunc) {
                return functionon[i+1];
            }
        }
        return functionon[0];
    }

    public void update(int array, int func) {

        functionon[array] = func;

    }

}