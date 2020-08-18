import org.junit.Test;

        import static org.junit.Assert.*;

public class TimeDataTest {

    @Test
    public void saveTimePart() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        TimeData td = new TimeData(b);

        //part = 5 (hour), value = 2
        td.saveTimePart(5,2);
        assertEquals(2, td.hour);
    }

}