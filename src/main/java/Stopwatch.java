import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Vector;

public class Stopwatch{

    public Stopwatch(View view) {
        this.view = view;
    }

    private View view;
    public int funcNum = 3;
    public LapSplitList lslist;
    public Vector lns = new Vector(3);
    public int milsec = 0;
    public int sec = 0;
    public int min = 0;
    public Thread runstop;
    public int paused = 1;//�ʱ⿣ 1
    public void reqStartStopwatch() {
        start();
    }

    public void start() {
        paused = 0;
        lslist = new LapSplitList();
        lns.add(0);
        lns.add(0);
        lns.add(0);
        runstop = new Thread(new Runnable() {
            public void run() {

                while(true) {
                    if(paused == 2) {
                        while(paused != 0) {
                            if(paused == 1) {
                                runstop.interrupt();
                                return;
                            }
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    milsec++;
                    if(milsec == 100) {
                        sec++;
                        milsec = 0;
                    }
                    if(sec == 60) {
                        min++;
                        sec = 0;
                    }

                    lns.add(min);
                    lns.add(sec);
                    lns.add(milsec);
                    displayLapSplit(lns);
                    lns.clear();
                }
            }
        });
        runstop.start();
    }

    public void reqStoreLapSplit() {
        System.out.println("store");
        Vector storeVec = new Vector(3);
        storeVec.add(min);
        storeVec.add(sec);
        storeVec.add(milsec);
        lslist.storeLapSplit(storeVec);

    }

    public void reqPause() {//������ ���������� 2
        paused = 2;
    }

    public void reqResume() {//�������϶��� 0
        paused = 0;
    }

    public void reqCheckList() {
        Vector getList = lslist.getList();
        displayLapSplit(getList);
    }

    public void reqNextLapSplit() {
        getNextNode();
    }

    public void getNextNode() {
        Vector getList = lslist.getList();
        displayLapSplit(getList);
    }

    public void reqBackToStopwatch() {
        paused = 2;
        lslist.nodeNum = 0;

    }

    public void displayLapSplit(Vector getList) {
        if(view.currfunc != 3) {
            return;
        }
        Vector rtVec = getList;
        int dmin = 0, dsec = 0, dmilsec = 0;
        int sequence = 0;
        String [] digit = {"0","0","0","0","0","0"};
        dmin = (int)getList.elementAt(0);
        dsec = (int)getList.elementAt(1);
        dmilsec = (int)getList.elementAt(2);
        if(getList.size() == 5) {
            sequence = (int)getList.elementAt(3);
        }
        if(paused == 3) {
            switch((int)getList.elementAt(4)) {//0�̸� LAP 1�̸� SPLIT
                case 0:
                    view.ampm.setText(String.valueOf(sequence));
                    view.daylb.setText("Lap");
                    break;
                case 1:
                    view.ampm.setText(String.valueOf(sequence));
                    view.daylb.setText("Split");
                    break;
                default:
                    break;
            }
        }
        String dmins = String.valueOf(dmin);
        String dsecs = String.valueOf(dsec);
        String dmilsecs = String.valueOf(dmilsec);

        digit[0] = dmins.substring(0, 1);
        if(dmins.length() == 1) {
            digit[0] = "0";
            digit[1] = dmins;
        }
        if(dmins.length() == 2)
            digit[1] = dmins.substring(1);

        digit[2] = dsecs.substring(0, 1);
        if(dsecs.length() == 1) {
            digit[2] = "0";
            digit[3] = dsecs;
        }
        if(dsecs.length() == 2)
            digit[3] = dsecs.substring(1);

        digit[4] = dmilsecs.substring(0, 1);
        if(dmilsecs.length() == 1) {
            digit[4] = "0";
            digit[5] = dmilsecs;
        }
        if(dmilsecs.length() == 2)
            digit[5] = dmilsecs.substring(1);


        view.sec.setText(digit[5]);
        view.sec10.setText(digit[4]);
        view.min.setText(digit[3]);
        view.min10.setText(digit[2]);
        view.hour.setText(digit[1]);
        view.hour10.setText(digit[0]);
    }

    public void reqReset() {
        resetStopwatch();
    }

    public void resetStopwatch() {
        if(paused == 0)
            return;
        paused = 1;
        lns.clear();
        lns.add(0);
        lns.add(0);
        lns.add(0);
        sec = 0;
        milsec = 0;
        min = 0;
        lslist = null;
    }

}