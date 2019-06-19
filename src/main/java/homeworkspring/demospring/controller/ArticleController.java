package homeworkspring.demospring.controller;

import homeworkspring.demospring.repository.model.Article;
import homeworkspring.demospring.service.ArticleService.ArticleService;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class ArticleController {


    private ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService){
        this.articleService=articleService;
    }
    private static String curImage;
    @GetMapping("/form")
    public String form(ModelMap modelMap){
        modelMap.addAttribute("article", new Article());
        return "form";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file){
        System.out.println(file.getOriginalFilename());
        return "index";
    }

    @GetMapping({"/","/index"})
    public String index(ModelMap modelMap){
//        Article article =new Article();
//        if(articleService.findAll().size()<1)
//        for(int i = 1; i< 100; i++){
//            Article article =new Article();
//            article.setId(i + 1);
//            article.setPictureURL("kkkk");
//            article.setPictureObject(null);
//            articleService.add(article);
//            System.out.println(article);
//        }
        //System.out.println("WORK");
        System.out.println(articleService.findAll());

        //System.out.println(i);
        modelMap.addAttribute("articles",  articleService.findAll());
        return "index";
    }
    @GetMapping("/pagination")
    public String paginator(@RequestParam int page, @RequestParam int limit, ModelMap modelMap){
        modelMap.addAttribute("articles",  articleService.showPagination(limit,page));
        return "index";
    }

//    private static String curImage;
    @GetMapping("/edit/{id}")
    public String Edit(@PathVariable int id, ModelMap modelMap){
        System.out.println("updated");
        System.out.println("this is update id : "+id);
        System.out.println(articleService.getOneRecord(id));

        modelMap.addAttribute("article", articleService.getOneRecord(id));
        modelMap.addAttribute("status",1);
//        modelMap.addAttribute("article",articleService.getOneRecord(id));
        curImage = articleService.getOneRecord(id).getPictureURL();
//        System.out.println(articleService.getOneRecord(id).getTitle());
        return "form";

    }
    @PostMapping("/update")
    public String update(@RequestParam int id, @ModelAttribute Article article,@RequestParam("pictureObject") MultipartFile file){
        String fileName;
        String generateUUID;
        String fileExtension;
        String newFileName;

        if(!file.isEmpty()) {
            fileName = file.getOriginalFilename();
            generateUUID = UUID.randomUUID().toString();
            fileExtension = fileName.substring(fileName.lastIndexOf('.'));
            newFileName = generateUUID + fileExtension;

            try {
                Files.copy(file.getInputStream(), Paths.get("src/main/resources/static/storage/" + newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            newFileName = curImage;
        }
        article.setPictureURL(newFileName);
        article.setPictureObject(null);
        articleService.update(id, article);
        return "redirect:/index";
    }

    @GetMapping("/delete")
    public String deleted(@RequestParam int id){
        articleService.deleted(id);
        return "redirect:/index";
    }

    @PostMapping("/postarticle")
    public String postArticle(@ModelAttribute Article article, @RequestParam("pictureObject") MultipartFile file){
        String fileName;
        String generateUUID;
        String fileExtension;
        String newFileName;

        if(!file.isEmpty()) {
            fileName = file.getOriginalFilename();
            generateUUID = UUID.randomUUID().toString();
            fileExtension = fileName.substring(fileName.lastIndexOf('.'));
            newFileName = generateUUID + fileExtension;

            try {
                Files.copy(file.getInputStream(), Paths.get("src/main/resources/static/storage/" + newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            newFileName = "default-thumbnail.jpg";
        }
        int size = articleService.findAll().size();
        article.setId(size + 1);
        article.setPictureURL(newFileName);
        article.setPictureObject(null);
        articleService.add(article);

        System.out.println(article.toString());
        System.out.println("work aii");
        return "redirect:/index";
    }

}
