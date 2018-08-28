import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class HotlineLoginPageTestCase {

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new String[][]{{"", ""}},
                new String[][]{{"", ""}},
                new String[][]{{"", ""}});
    }

    @Parameterized.Parameter
    public String[] itemsToAdd;
}
