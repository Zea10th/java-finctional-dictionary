package org.example;

import java.util.TreeSet;
import java.util.function.Function;

public class Dictionary {
    private TreeSet<String> dictionary;
    private IReadable readable;
    private final Function<String, TreeSet<String>> dictionaryUpdater;

    public Dictionary(IReadable readable) {
        this.dictionary = new TreeSet<>();
        this.readable = readable;
        this.dictionaryUpdater = line -> getUpdate(line);
    }

    public TreeSet<String> getDictionary() {
        update();
        return dictionary;
    }

    public void update() {
        dictionary.addAll(dictionaryUpdater.apply(readable.read()));
    }

    public TreeSet<String> getUpdate(String line) {
        var temp = line.split(" ");
        var result = new TreeSet<String>();

        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].toLowerCase();
            temp[i] = temp[i].replaceAll("[^A-Za-zА-Яа-я]", "");
            result.add(temp[i]);
        }

        return result;
    }
}
