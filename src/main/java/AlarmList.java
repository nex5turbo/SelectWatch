import java.util.*;

public class AlarmList {

    public AlarmList(View view) {
    }

    public Vector alarm = new Vector(10);
    public int index = 0;

    public Vector getAlarmList(int indexNum) {
        // TODO implement here
        Vector rtVector = new Vector();
        rtVector.add((String)alarm.elementAt(indexNum));

        return rtVector;
    }

    public void updateList(Vector recvData) {
        // TODO implement here
        alarm.add((String) recvData.elementAt(0));
    }

}

