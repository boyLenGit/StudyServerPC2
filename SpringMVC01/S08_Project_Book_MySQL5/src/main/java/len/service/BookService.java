<<<<<<< HEAD
package len.service;

import len.pojo.Books;

import java.util.List;

public interface BookService {
    // 增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更改一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBooks();

    List<Books> queryBook(String bookName);

    Books queryBookByName(String bookName);
}
=======
package len.service;

import len.pojo.Books;

import java.util.List;

public interface BookService {
    // 增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更改一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBooks();

    List<Books> queryBook(String bookName);

    Books queryBookByName(String bookName);
}
>>>>>>> 1da3f48 (first commit)
