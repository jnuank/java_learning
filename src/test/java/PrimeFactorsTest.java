import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeFactorsTest {
    @Test
    public void factors() throws Exception {
        assertEquals(Optional.empty(), factorsOf(1));
    }

    private Optional<Object> factorsOf(int i) {
        return empty();
    }
}
