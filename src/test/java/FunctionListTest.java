import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionListTest {

    @Test
    public void getNextFunction() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Alarm a = new Alarm(v,al,b);
        RandomDirectionGenerator rdg = new RandomDirectionGenerator(v);
        RandomNumberGenerator rng = new RandomNumberGenerator(v);
        Stopwatch s = new Stopwatch(v);
        Timer t = new Timer(v,b);
        TimeKeeping tk = new TimeKeeping(v,b);
        FunctionList fl = new FunctionList(v,a,rdg,rng,s,t,tk);

        assertEquals(3, fl.getNextFunction(2));
    }
}