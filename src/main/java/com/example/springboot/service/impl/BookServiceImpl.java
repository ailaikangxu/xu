package com.example.springboot.service.impl;


import com.example.springboot.dao.BookDao;
import com.example.springboot.entity.BookDO;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Map> selectByIdReturnMap() {
        return bookDao.selectByIdReturnMap();
    }

    /**
     * 查询书记录
     *
     * @param name 书名
     * @return
     */

    @Override
    public BookDO selectByName(String name) {
        return bookDao.selectByName(name);
    }

    /**
     * 查询书记录
     *
     * @param id 书ID
     * @return
     */

    @Override
    public BookDO selectById(Long id) {
        return bookDao.selectById(id);
    }

    /**
     * 删除书记录
     *
     * @param id
     * @return
     */

    @Override
    public Integer deleteById(Long id) {
        return bookDao.deleteById(id);
    }

    /**
     * 插入书记录
     *
     * @param book 书对象
     * @return
     */

    @Override
    public Integer insert(BookDO book) {
        return bookDao.insert(book);
    }

    /**
     * 更新书记录
     *
     * @param book 书对象
     * @return
     */

    @Override
    public Integer update(BookDO book) {
        return bookDao.update(book);
    }

    /**
     * 事务管理测试
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void transaction() throws Exception {
        BookDO book = new BookDO();
        book.setName("yang");
        insert(book);

        Integer.parseInt("hh");
    }
}
