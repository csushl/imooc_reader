package com.imooc.reader.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.reader.entity.TestTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMapperTestor {

    @Resource
    private TestMapper testMapper;

    @Test
    public void insertSample() {
        testMapper.insertSample();
    }


    @Test
    public void testInsert() {
        TestTable test = new TestTable();
        test.setContent("XXXXX");
        int count = testMapper.insert(test);
        System.out.println("本次新增" + count + "数据");
    }

    @Test
    public void testUpdate(){
        TestTable test = new TestTable();
        test.setId(20);
        test.setContent("XXXX1");
        testMapper.updateById(test);
    }

    @Test
    public void testDelete(){
        testMapper.deleteById(20);
    }

    @Test
    public void testSelectById(){
        TestTable test = testMapper.selectById(21);
        System.out.println(test.getContent());
    }
    @Test
    public void testSelectList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("id", 21);
        wrapper.eq("content", "测试内容");
        List<TestTable> list = testMapper.selectList(wrapper);
        System.out.println(list.size());
    }

    @Test
    public void testPagination(){
        IPage page = new Page(2, 2);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("id", 21);
        wrapper.eq("content", "测试内容");
        page = testMapper.selectPage(page, wrapper);
        System.out.println("总页数：" + page.getPages());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("当前页数据：" + page.getRecords());
    }


}