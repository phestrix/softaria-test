package ru.phestrix.controller;

import ru.phestrix.comparator.TwoTablesComparator;
import ru.phestrix.letter.LetterCreator;
import ru.phestrix.storage.TableFactory;
import ru.phestrix.storage.TableOfDay;

public class StringController {
    private final TableOfDay<String, String> today;
    private final TableOfDay<String, String> yesterday;
    private final TwoTablesComparator<String, String> comparator;
    private LetterCreator letterCreator;

    public StringController() {
        this.today = TableFactory.createPrototypeTable();
        this.yesterday = TableFactory.createPrototypeTable();
        this.comparator = new TwoTablesComparator<>(today, yesterday);
    }

    public void addToToday(String key, String value) {
        today.insertData(key, value);
    }

    public void addToYesterday(String key, String value) {
        yesterday.insertData(key, value);
    }

    public void compare() {
        comparator.compare();
    }

    public void updateLetter() {
        letterCreator = null;
        letterCreator = new LetterCreator(comparator.getMissingUrls(), comparator.getChangedUrls(), comparator.getNewUrls());
    }

    public void printLetter() {
        letterCreator.printLetter();
    }

}
