package lab14.src.service;

import lab14.src.model.Item;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid item name");
        }
        items.add(new Item(name));
    }

    public int getCount() {
        return items.size();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void save(String filename) throws IOException {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(items);
        }
    }

    @SuppressWarnings("unchecked")
    public void load(String filename)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(filename))) {
            items = (ArrayList<Item>) in.readObject();
        }
    }
}