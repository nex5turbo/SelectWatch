import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNumberGeneratorTest {

    @Test
    public void reqRandomNumber() {

        View v = new View();
        RandomNumberGenerator rng = new RandomNumberGenerator(v);
        int result = rng.reqRandomNumber(100);
        int flag;

        if(result>=0 && result<100)
            flag = 1;
        else
            flag =0;

        assertEquals(flag,1);
    }

    @Test
    public void reqBackToSetScope()
    {
        View v = new View();
        RandomNumberGenerator rng = new RandomNumberGenerator(v);

        rng.reqBackToSetScope();
        assertEquals(1,rng.part);
    }

    @Test
    public void saveScope()
    {
        View v = new View();
        RandomNumberGenerator rng = new RandomNumberGenerator(v);

        rng.part = 2;
        rng.saveScope();
        assertEquals(0, rng.saveValue);
    }

    @Test
    public void setScopePart()
    {
        View v = new View();
        RandomNumberGenerator rng = new RandomNumberGenerator(v);

        rng.setScopePart(0);
        rng.part = 2; // sec10
        rng.saveValue = 8;

        assertEquals(8,rng.saveValue);
    }
}

