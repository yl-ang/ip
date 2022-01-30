import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import duke.storage.Storage;

public class StorageTest {

    @Test
    public void loadTest() {
        assertEquals("[T][ ] sleep", new Storage("data/tasks.txt").load().get(0).toString());
    }

}
