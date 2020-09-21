package com.example.springboot.controller;

import com.example.springboot.aop.DemoAnnotationService;
import com.example.springboot.entity.BookDO;
import com.example.springboot.service.BookService;
import com.example.springboot.utils.CODE;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private DemoAnnotationService demoAnnotationService;

    @RequestMapping(value = "/selectByIdReturnMap", method = RequestMethod.POST)
    private Result selectByIdReturnMap() {
        List<Map> list = bookService.selectByIdReturnMap();
        System.out.println(list.toString());
        return new Result(CODE.SUCCESS, list, "success");
    }

    /**
     * 查询书记录
     *
     * @param name 书名
     * @return
     */
    @RequestMapping(value = "/selectByName", method = RequestMethod.POST)
    private Result selectByName(String name) {
        try {
            BookDO book = bookService.selectByName(name);
            demoAnnotationService.add();
            return new Result(CODE.SUCCESS, book, "查询成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Result(CODE.ERROR, null, "查询失败！");
        }
    }

    /**
     * 查询书记录
     *
     * @param id 书ID
     * @return
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    private Result selectById(long id) {
        try {
            BookDO book = bookService.selectById(id);
            return new Result(CODE.SUCCESS, book, "查询成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Result(CODE.ERROR, null, "查询失败！");
        }
    }

    /**
     * 删除书记录
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    private Result deleteById(long id) {
        try {
            Integer num = bookService.deleteById(id);
            return Result.success(num);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Result(CODE.ERROR, null, "查询失败！");
        }
    }

    /**
     * 插入书记录
     *
     * @param bookDO 书对象
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    private Result insert(BookDO bookDO) {
        try {
            Integer num = bookService.insert(bookDO);
            return new Result(CODE.SUCCESS, num, "查询成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Result(CODE.ERROR, null, "查询失败！");
        }
    }

    /**
     * 更新书记录
     *
     * @param bookDO 书对象
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private Result update(BookDO bookDO) {
        try {
            System.out.println("客户端上传--->" + bookDO.toString());
            Integer num = bookService.update(bookDO);
            return new Result(CODE.SUCCESS, num, "查询成功！");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Result(CODE.ERROR, null, "查询失败！");
        }
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    private Result transaction() {
        try {
            bookService.transaction();
            return new Result(CODE.SUCCESS, null, "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(CODE.SUCCESS, null, "查询失败！");
        }
    }

}

