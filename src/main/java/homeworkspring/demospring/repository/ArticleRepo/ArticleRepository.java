package homeworkspring.demospring.repository.ArticleRepo;
import homeworkspring.demospring.repository.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ArticleRepository {
   @Select("Select * from tb_articles")
   @Results({
           @Result(property = "id",column = "id"),
           @Result(property = "title", column = "title"),
           @Result(property = "author",column = "author"),
           @Result(property = "description", column = "description"),
           @Result(property = "pictureURL", column = "image")
   })
   ArrayList<Article> findAll();
   @Insert("Insert into tb_articles(title,author,description,image) values(#{title},#{author},#{description},#{pictureURL})")
   void add(Article article);
   @Delete("Delete from tb_articles where id = #{id}")
   void deleted(int id);

   @Update("update tb_articles set title = #{title}, author = #{author}, description = #{description}, image =#{pictureURL} where id=#{id}")
   void update(Article article);

   @Select("select * from tb_articles where id = #{id}")
   @Results({
           @Result(property = "id",column = "id"),
           @Result(property = "title", column = "title"),
           @Result(property = "author",column = "author"),
           @Result(property = "description", column = "description"),
           @Result(property = "pictureURL", column = "image")
   })
   Article getOneRecord(int id);

  List<Article> showPagination(int page, int limitpage);
}
