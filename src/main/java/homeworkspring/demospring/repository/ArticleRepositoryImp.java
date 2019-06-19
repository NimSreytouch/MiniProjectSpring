//package homeworkspring.demospring.repository;
//
//import homeworkspring.demospring.repository.ArticleRepo.ArticleRepository;
//import homeworkspring.demospring.repository.model.Article;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
////@Repository
//public class ArticleRepositoryImp implements ArticleRepository{
//    List<Article> articleList=new ArrayList<>();
//
//    @Override
//    public void add(Article article) {
//        articleList.add(article);
//    }
//
//    @Override
//    public void deleted(int id) {
//        if(articleList.size() == -1) return ;
//        else
//            for (int i = 0; i < articleList.size(); i++) {
//                if (articleList.get(i).getId() == id) {
//                    articleList.remove(i);
//
//                }
//            }
//    }
//
//    @Override
//    public List<Article> findAll() {
//        return articleList;
//    }
//
//    @Override
//    public List<Article> showPagination(int page, int limitpage) {
//        if(limitpage<=0) limitpage=1;
//        List<Article> limitpagination;
//        int size=articleList.size();
//        int totalRecords=(size%limitpage != 0 ?size / limitpage+1 : size/page);
//        if(limitpage>totalRecords) limitpage=totalRecords;
//        int fromIndex=limitpage*page-page;
//        int toIndex=(limitpage==totalRecords)? (fromIndex+(size%page == 0?page:size%page)):limitpage*page;
//        limitpagination=articleList.subList(fromIndex,toIndex);
//        return limitpagination;
//    }
//
//    @Override
//    public Article getOneRecord(int id) {
//        if(articleList.size()==-1) {
//            System.out.println("hello");
//            return null;}
//        else
//            for(int i=0; i< articleList.size(); i++){
//                System.out.println("print data in loop : "+id);
//                if(articleList.get(i).getId() == id){
//                    System.out.println("article list");
//                    System.out.println("THIS IS ARTI : " + articleList.get(i));
//                    return articleList.get(i);
//                }
//            }
//        System.out.println("no all");
//        return null;
//    }
//
//    @Override
//    public void update(int id, Article article) {
//        Article obj;
//        if(articleList.size() != -1)
//        {
//            for(int i = 0; i < articleList.size(); i++) {
//                obj = articleList.get(i);
//                if (obj.getId() == article.getId()) {
//                    obj.setAuthor(article.getAuthor());
//                    obj.setDescription(article.getDescription());
//                    obj.setTitle(article.getTitle());
//                    obj.setPictureURL(article.getPictureURL());
//
//                }
//            }
//        }
//
//    }
//
//}
