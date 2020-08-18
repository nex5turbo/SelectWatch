import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Alarm {

    public Alarm(View view, AlarmList alist, Buzzer buzzer) {
        this.view = view;
        this.alist = alist;
        this.buzzer = buzzer;
    }


    public Buzzer buzzer;
    private View view;
    public Vector alarm = new Vector();
    //Delete eLCD[]
    //Added from here
    AlarmList alist;
    public int sec = 0;
    public int sec10 = 0;
    public int min = 0;
    public int min10 = 0;
    public int hour = 0;
    public int hour10 = 0;
    public int part = -1;
    public int ison = 0;
    public int sun = 0;
    public int mon = 0;
    public int tue = 0;
    public int wed = 0;
    public int thu = 0;
    public int fri = 0;
    public int sat = 0;
    public int alarmIndex = 0;
    //to here

    public void reqSetAlarm() {
        // TODO implement here
        alarmIndex = 0;
        //System.out.println("req daetail set");
        reqDetailSet();
    }

    public void reqNextAlarm() {
        // TODO implement here
        view.ampm.setText(String.valueOf(alarmIndex+1));
        getNextNode();
        String showString = (String)alarm.elementAt(0);
        alarm.clear();
        int vison = Integer.parseInt(showString.substring(0, 1));
        String vsec = showString.substring(1, 2);
        String vsec10 = showString.substring(2, 3);
        String vmin = showString.substring(3, 4);
        String vmin10 = showString.substring(4, 5);
        String vhour = showString.substring(5, 6);
        String vhour10 = showString.substring(6, 7);
        int vsun = Integer.parseInt(showString.substring(7, 8));
        int vmon = Integer.parseInt(showString.substring(8, 9));
        int vtue = Integer.parseInt(showString.substring(9, 10));
        int vwed = Integer.parseInt(showString.substring(10, 11));
        int vthu = Integer.parseInt(showString.substring(11, 12));
        int vfri = Integer.parseInt(showString.substring(12, 13));
        int vsat = Integer.parseInt(showString.substring(13));

        view.sec.setText(vsec);
        view.sec10.setText(vsec10);
        view.min.setText(vmin);
        view.min10.setText(vmin10);
        view.hour.setText(vhour);
        view.hour10.setText(vhour10);
        if(vison == 1)
            view.setDot(30);
        else
            view.removeDot(30);
        if(vsun == 1)
            view.setDot(0);
        else
            view.removeDot(0);
        if(vmon == 1)
            view.setDot(1);
        else
            view.removeDot(1);
        if(vtue == 1)
            view.setDot(2);
        else
            view.removeDot(2);
        if(vwed == 1)
            view.setDot(3);
        else
            view.removeDot(3);
        if(vthu == 1)
            view.setDot(4);
        else
            view.removeDot(4);
        if(vfri == 1)
            view.setDot(5);
        else
            view.removeDot(5);
        if(vsat == 1)
            view.setDot(6);
        else
            view.removeDot(6);

        alarmIndex++;
        if(alarmIndex > alist.alarm.size()-1) {
            alarmIndex = 0;
        }

    }

    public void getNextNode() {
        alarm = alist.getAlarmList(alarmIndex);
    }

    public void reqDetailSet() {
        // TODO implement here
        //System.out.println("set now");
        sec = 0;
        sec10 = 0;
        min = 0;
        min10 = 0;
        hour = 0;
        hour10 = 0;
        part = 0;
        ison = 0;
        sun = 0;
        mon = 0;
        tue = 0;
        wed = 0;
        thu = 0;
        fri = 0;
        sat = 0;
    }

    public void setAlarmPart(int button) {
        //System.out.println("setAlarmPart");
        if(part == -1)
            return;
        //System.out.println("part != -1");

        if(button == 0) {
            switch(part) {
                case 0://ison
                    ison = 1;
                    break;
                case 1://sec
                    sec++;
                    if(sec == 10)
                        sec = 9;

                    break;
                case 2://sec10
                    sec10++;
                    if(sec10 == 6)
                        sec10 = 5;

                    break;
                case 3://min
                    min++;
                    if(min == 10)
                        min = 9;

                    break;
                case 4://min10
                    min10++;
                    if(min10 == 6)
                        min10 = 5;

                    break;
                case 5://hour
                    hour++;

                    if(hour == 10)
                        hour = 9;

                    break;
                case 6://hour10
                    hour10++;
                    if(hour10 > 1) {
                        if(hour > 3)
                            hour10 = 0;
                    }
                    if(hour10 > 2)
                        hour10 = 0;
                    break;
                case 7://sun
                    sun = 1;
                    break;
                case 8://mon
                    mon = 1;
                    break;
                case 9://tue
                    tue = 1;
                    break;
                case 10://wed
                    wed = 1;
                    break;
                case 11://thu
                    thu = 1;
                    break;
                case 12://fri
                    fri = 1;
                    break;
                case 13://sat
                    sat = 1;
                    break;
                default:
                    break;
            }
        }
        if(button == 1) {
            switch(part) {
                case 0://ison
                    ison = 0;
                    break;
                case 1:
                    sec--;
                    if(sec == -1)
                        sec = 2;
                    break;
                case 2:
                    sec10--;
                    if(sec10 == -1)
                        sec10 = 0;
                    break;
                case 3:
                    min--;
                    if(min == -1)
                        min = 0;
                    break;
                case 4:
                    min10--;
                    if(min10 == -1)
                        min10 = 0;
                    break;
                case 5:
                    hour--;
                    if(hour == -1)
                        hour = 0;
                    break;
                case 6:
                    hour10--;
                    if(hour10 == -1)
                        hour10 = 0;
                    break;
                case 7://sun
                    sun = 0;
                    break;
                case 8://mon
                    mon = 0;
                    break;
                case 9://tue
                    tue = 0;
                    break;
                case 10://wed
                    wed = 0;
                    break;
                case 11://thu
                    thu = 0;
                    break;
                case 12://fri
                    fri = 0;
                    break;
                case 13://sat
                    sat = 0;
                    break;
                default:
                    break;
            }
        }

    }

    public void reqSaveAlarm() {
        // TODO implement here
        String saveData = String.valueOf(ison) + "" +String.valueOf(sec) + "" +String.valueOf(sec10) + "" +String.valueOf(min) + "" +
                String.valueOf(min10) + "" +String.valueOf(hour) + "" +String.valueOf(hour10) + "" +String.valueOf(sun) + "" +
                String.valueOf(mon) + "" +String.valueOf(tue) + "" +String.valueOf(wed) + "" +String.valueOf(thu) + "" +
                String.valueOf(fri) + "" +String.valueOf(sat);
        ison = 0;
        sec = 0;
        sec10 = 0;
        min = 0;
        min10 = 0;
        hour = 0;
        hour10 = 0;
        sun = 0;
        mon = 0;
        tue = 0;
        wed = 0;
        thu = 0;
        fri = 0;
        sat = 0;
        part = -1;

        alarm.add(saveData);
        alist.updateList(alarm);
        alarm.clear();
    }

    public void reqDeleteAlarm() {
        // TODO implement here
        if(alarmIndex == 0)
            deleteAlarm(0);
        else
            deleteAlarm(alarmIndex-1);
    }

    public void deleteAlarm(int indexNum) {
        // TODO implement here
        alist.alarm.remove(indexNum);
        alarmIndex = 0;
        if(alist.alarm.size() == 0) {
            view.initDot();
            view.initLabel();
            return;
        }
        displayAlarmList();
    }

    public void displayAlarmList() {
        // TODO implement here
        if(alist.alarm.size() == 0) {
            reqSetAlarm();
            //System.out.println(part);
            return;
        }
        reqNextAlarm();
    }

    public void reqStopAlarmBuzzer() {
        // TODO implement here
        buzzer.reqStop(2);

    }

    public void reqSetSnooze() {
        // TODO implement here
        createSnooze();
        reqStopAlarmBuzzer();
    }

    public void createSnooze() {
        // TODO implement here
        buzzer.activateSnooze();
    }

}