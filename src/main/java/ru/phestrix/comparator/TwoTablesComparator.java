package ru.phestrix.comparator;

import ru.phestrix.storage.TableOfDay;

import java.util.List;

public class TwoTablesComparator<Url, Html> implements Comparator {

    private final TableOfDay<Url, Html> today;
    private final TableOfDay<Url, Html> yesterday;

    private List<Url> missingUrls;
    private List<Url> changedUrls;
    private List<Url> newUrls;

    public TwoTablesComparator(TableOfDay<Url, Html> today, TableOfDay<Url, Html> yesterday) {
        this.today = today;
        this.yesterday = yesterday;
    }

    @Override
    public void compare() {
        missingUrls = yesterday.getKeys().stream()
                .filter(url -> !today.getKeys().contains(url))
                .toList();
        changedUrls = yesterday.getKeys().stream()
                .filter(url -> today.getKeys().contains(url))
                .filter(url -> !today.selectData(url).equals(yesterday.selectData(url)))
                .toList();
        newUrls = today.getKeys().stream()
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
