package ru.phestrix.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableFactory {
    public static <Url, Html> TableOfDay createPrototypeTable() {
        return new TableOfDay<Url, Html>() {
            @Override
            public void insertData(Url key, Html value) {
                table.put(key, value);
            }

            @Override
            public Html selectData(Url key) {
                return table.get(key);
            }

            @Override
            public void updateData(Url key, Html value) {
                table.put(key, value);
            }

            @Override
            public List<Url> getKeys() {
                return new ArrayList<>(table.keySet());
            }

            @Override
            public List<Html> selectDataSet(List<Url> keys) {
                return keys.stream().map(table::get).collect(Collectors.toList());
            }

            @Override
            public void deleteData(Url key) {
                table.remove(key);
            }
        };
    }
}

