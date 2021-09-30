package com.encora;

import org.apache.commons.csv.CSVRecord;

public interface Mapper<T> {

    T fromRecord(CSVRecord csvRecord);
    CSVRecord toRecord(T data);
}
