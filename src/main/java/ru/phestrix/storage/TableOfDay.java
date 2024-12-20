package ru.phestrix.storage;

import java.util.HashMap;
import java.util.List;

public abstract class TableOfDay<Url, Html> {
    protected HashMap<Url, Html> table;

    public void createTable() {
        table = new HashMap<>();
    }

    public void deleteTable() {
        table.clear();
        table = null;
    }

    public abstract void insertData(Url key, Html value);

    public abstract Html selectData(Url key);

    public abstract void updateData(Url key, Html value);

    public abstract List<Html> selectDataSet(List<Url> keys);

    public abstract void deleteData(Url key);

    public abstract List<Url> getKeys();
}
