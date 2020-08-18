import org.junit.Test;

import static org.junit.Assert.*;

public class TimerTest {

    @Test
    public void setTimerPart() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Timer tm = new Timer(v,b);

        tm.part = 1; // sec
        tm.saveValue = 5;

        tm.setTimerPart(0);

        assertEquals(tm.timer.sec , tm.saveValue);

    }
}


