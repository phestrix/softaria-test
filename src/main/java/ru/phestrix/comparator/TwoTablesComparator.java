package ru.phestrix.comparator;

import ru.phestrix.storage.TableFactory;
import ru.phestrix.storage.TableOfDay;

import java.util.List;

public class TwoTablesComparator<Url, Html> implements Comparator {

    private final TableOfDay<Url, Html> today;
    private final TableOfDay<Url, Html> yesterday;

    private List<Url> missingUrls;
    private List<Url> changedUrls;
    private List<Url> newUrls;

    public TwoTablesComparator() {
        today = TableFactory.createPrototypeTable();
        yesterday = TableFactory.createPrototypeTable();
    }

    @Override
    public void compare() {
        List<Url> missingUrls = yesterday.getKeys().stream()
                .filter(url -> !today.getKeys().contains(url))
                .toList();
        List<Url> changedUrls = yesterday.getKeys().stream()
                .filter(url -> today.getKeys().contains(url))
                .filter(url -> !today.selectData(url).equals(yesterday.selectData(url)))
                .toList();
        List<Url> newUrls = today.getKeys().stream()
                .filter(url -> !yesterday.getKeys().contains(url)).toList();

    }


    public List<Url> getMissingUrls() {
        return missingUrls;
    }

    public List<Url> getChangedUrls() {
        return changedUrls;
    }

    public List<Url> getNewUrls() {
        return newUrls;
    }
}
