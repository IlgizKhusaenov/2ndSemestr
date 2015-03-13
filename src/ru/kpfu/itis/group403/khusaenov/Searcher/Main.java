package ru.kpfu.itis.group403.khusaenov.Searcher;

public class Main {

    public static void main(String[] args) {
        try {
            Searcher search = new Searcher(args);
            search.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
