package lab14.test;

import lab14.src.service.ItemService;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceTest {

    @Test
    void addingItemIncreasesCount() {
        ItemService service = new ItemService();
        service.addItem("Book");

        assertEquals(1, service.getCount());
    }

    @Test
    void invalidItemThrowsException() {
        ItemService service = new ItemService();

        assertThrows(IllegalArgumentException.class,
                () -> service.addItem(""));
    }

    @Test
    void saveAndReloadPreservesData() throws Exception {
        Path file = Files.createTempFile("items", ".dat");

        try {
            ItemService original = new ItemService();
            original.addItem("Book");
            original.addItem("Pen");

            original.save(file.toString());

            ItemService restored = new ItemService();
            restored.load(file.toString());

            assertEquals(original.getCount(), restored.getCount());
            assertEquals(
                    original.getItems().toString(),
                    restored.getItems().toString()
            );
        } finally {
            Files.deleteIfExists(file);
        }
    }
}