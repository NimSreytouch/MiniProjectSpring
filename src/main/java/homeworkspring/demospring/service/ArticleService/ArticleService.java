package homeworkspring.demospring.service.ArticleService;

import homeworkspring.demospring.repository.model.Article;

import java.util.List;

public interface ArticleService {
    void add(Article article);
    void deleted(int id);
    void update(int id,Article article);
    Article getOneRecord(int id);
    List<Article> findAll();
    List<Article> showPagination(int page, int limitpage);

}
