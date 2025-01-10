import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeFactorsTest {
    @Test
    public void factors() throws Exception {
        assertEquals(List.of(2), factorsOf(2));
    }

    @Test
    public void factors3() {
        assertEquals(List.of(3), factorsOf(3));
    }

    @Test
    public void 素数分析4の場合() {
        assertEquals(List.of(2,2), factorsOf(4));
    }

    private List<Integer> factorsOf(int n) {
        var factors = new ArrayList<Integer>();
        if (n > 1)
            factors.add(n);
        return factors;
    }
}
