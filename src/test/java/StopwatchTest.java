import org.junit.Test;

import static org.junit.Assert.*;

public class StopwatchTest {

    @Test
    public void reqSelectFunction() {
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
        SelectFunction sf = new SelectFunction(v,fl);

        sf.reqSelectFunction();
        assertEquals(1, sf.setting);
    }

    @Test
    public void setFunction() {
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
        SelectFunction sf = new SelectFunction(v,fl);

        sf.part = 3;
        sf.setFunction(1);
        assertEquals(0, sf.showArray[1]);
    }

}