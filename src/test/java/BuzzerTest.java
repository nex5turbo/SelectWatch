import org.junit.Test;

import static org.junit.Assert.*;

public class BuzzerTest {

    @Test
    public void reqStop() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);

        b.reqStop(1);
        assertEquals(0, b.funcType);
    }

    @Test
    public void beep() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);

        b.on = true;
        b.beep(1); // Timer beep
        assertEquals(1, b.funcType);
    }

}