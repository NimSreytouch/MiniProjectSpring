package homeworkspring.demospring.service;

import homeworkspring.demospring.repository.ArticleRepo.ArticleRepository;
import homeworkspring.demospring.repository.model.Article;
import homeworkspring.demospring.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void add(Article article) {
        articleRepository.add(article);
    }

    @Override
    public void deleted(int id) {
        articleRepository.deleted(id);
    }

    @Override
    public void update(int id, Article article) {
        articleRepository.update(article);
    }

    @Override
    public Article getOneRecord(int id) {
        return articleRepository.getOneRecord(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> showPagination(int page, int limitpage) {
        return articleRepository.showPagination(page, limitpage);
    }
}
