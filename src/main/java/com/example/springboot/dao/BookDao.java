package com.example.springboot.dao;


import com.example.springboot.entity.BookDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookDao {

    /**
     * 查询书记录
     *
     * @param name 书名
     * @return
     */
    BookDO selectByName(@Param("bookName") String name);

    /**
     * 查询书记录
     * 以map形式返回
     *
     * @return
     */
    List<Map> selectByIdReturnMap();

    /**
     * 查询书记录
     *
     * @param id 书ID
     * @return
     */
    BookDO selectById(@Param("bookId") Long id);

    /**
     * 删除书记录
     *
     * @param id
     * @return
     */
    Integer deleteById(@Param("bookId") Long id);

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
}
