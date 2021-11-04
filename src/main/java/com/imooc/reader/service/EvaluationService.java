package com.imooc.reader.service;

import java.util.List;
import java.util.Map;

public interface EvaluationService {
    public default List<Map> selectByBookId(Long bookId) {
        return null;
    }
}
