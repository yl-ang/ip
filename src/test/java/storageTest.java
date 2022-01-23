import org.junit.jupiter.api.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class storageTest {

    @Test
    public void loadTest() {
        assertEquals("[T][ ] coding", new Storage("data/tasks.txt").load().get(0).toString());
    }

}
