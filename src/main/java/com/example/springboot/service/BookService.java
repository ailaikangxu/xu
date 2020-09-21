package com.example.springboot.service;

import com.example.springboot.entity.BookDO;

import java.util.List;
import java.util.Map;

public interface BookService {


    List<Map> selectByIdReturnMap();

    /**
     * 查询书记录
     *
     * @param name 书名
     * @return
     */
    BookDO selectByName(String name);

    /**
     * 查询书记录
     *
     * @param id 书ID
     * @return
     */
    BookDO selectById(Long id);

    /**
     * 删除书记录
     *
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * 插入书记录
     *
     * @param book 书对象
     * @return
     */
    Integer insert(BookDO book);

    /**
     * 更新书记录
     *
     * @param book 书对象
     * @return
     */
    Integer update(BookDO book);

    /**
     * 事务管理测试
     */
    void transaction() throws Exception;

}
