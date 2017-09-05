package com.key.dao;


import com.key.entity.Book;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Created by key, learn from hisenyuan on 5/Sep/2017 at 21:37.
 */
public interface BookDao {
    Book queryById(long id);

    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(long id);
}