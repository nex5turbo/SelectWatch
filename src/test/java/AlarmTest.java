import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void reqSetAlarm() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Alarm alm = new Alarm(v,al,b);

        alm.alarmIndex = 1;
        alm.reqSetAlarm();
        assertEquals(0, alm.alarmIndex);

    }

    @Test
    public void reqDetailSet() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Alarm alm = new Alarm(v,al,b);

        alm.reqDetailSet();
        assertEquals(0, alm.sec);
        assertEquals(0, alm.sec10);
        assertEquals(0, alm.min);
        assertEquals(0, alm.min10);
        assertEquals(0, alm.hour);
        assertEquals(0, alm.hour10);

    }

    @Test
    public void setAlarmPart() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Alarm alm = new Alarm(v,al,b);

        alm.part=1;
        alm.sec = 8;
        alm.setAlarmPart(0);
        assertEquals(9, alm.sec);

        alm.sec = 9;
        alm.setAlarmPart(0);
        assertEquals(9,alm.sec);
    }

    @Test
    public void reqSaveAlarm() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Alarm alm = new Alarm(v,al,b);

        alm.reqSaveAlarm();
        assertEquals(0,alm.sec);
        assertEquals(0,alm.sec10);
        assertEquals(0,alm.min);
        assertEquals(0,alm.min10);
        assertEquals(0,alm.hour);
        assertEquals(0,alm.hour10);

    }

    @Test
    public void reqStopAlarmBuzzer() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Alarm alm = new Alarm(v,al,b);

        alm.reqStopAlarmBuzzer();
        assertEquals(0, b.funcType);
    }

    @Test
    public void reqSetSnooze() {
        View v = new View();
        AlarmList al = new AlarmList(v);
        Buzzer b = new Buzzer(v,al);
        Alarm alm = new Alarm(v,al,b);

        alm.reqSetSnooze();
        assertEquals(0, b.funcType);
    }

}