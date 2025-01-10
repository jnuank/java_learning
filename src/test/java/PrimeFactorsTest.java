import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeFactorsTest {
    @Test
    public void factors() throws Exception {
        assertTrue(factorsOf(1).contains(2));
    }

    private List<Integer> factorsOf(int i) {
        var factors = new ArrayList<Integer>();
        factors.add(2);
        return factors;
    }
}
