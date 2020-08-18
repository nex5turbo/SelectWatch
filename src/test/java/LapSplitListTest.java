import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class LapSplitListTest {

    @Test
    public void storeLapSplit() {

        LapSplitList ls = new LapSplitList();

        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.add(3);
        ls.storeLapSplit(v);

        assertEquals(1, ls.lns.elementAt(0));
        assertEquals(2, ls.lns.elementAt(1));
        assertEquals(3, ls.lns.elementAt(2)); // LAP
        assertEquals(1, ls.lns.elementAt(3));
        assertEquals(2, ls.lns.elementAt(4));
        assertEquals(3, ls.lns.elementAt(5)); // SPLIT
    }
}




