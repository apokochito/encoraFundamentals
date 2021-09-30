package com.encora;

import org.apache.commons.csv.CSVRecord;

public class WineMapper implements Mapper<Wine> {

    @Override
    public Wine fromRecord(CSVRecord record) {
        String name = record.get(0);
        String kind = record.get(1);
        Double pH = Double.valueOf(record.get(2));
        Double alcohol = Double.valueOf(record.get(3));
        int quality = Integer.parseInt(record.get(4));
        return new Wine(name, kind, pH, alcohol, quality);
    }

    @Override
    public CSVRecord toRecord(Wine data) {
        return null;
    }
}
