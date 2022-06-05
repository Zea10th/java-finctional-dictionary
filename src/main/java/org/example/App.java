package org.example;

public class App {
    public static void main(String[] args) {
        var manuscript = new NativeManuscript();
        var dictionary = new Dictionary(manuscript);
        dictionary.getDictionary()
                .forEach(word -> System.out.println(word));
    }
}
