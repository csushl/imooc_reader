package com.imooc.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.reader.entity.TestTable;

public interface TestMapper extends BaseMapper<TestTable> {
    public void insertSample();
}
