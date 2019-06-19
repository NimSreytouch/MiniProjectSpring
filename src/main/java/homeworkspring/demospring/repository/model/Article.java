package homeworkspring.demospring.repository.model;

import org.springframework.web.multipart.MultipartFile;

public class Article {
    private Integer id ;
    private String title;
    private String author;
    private Category category;
    private String description;
    private String pictureURL;
    private MultipartFile pictureObject;

    public Article() {
    }
    public Article(int id) {
        this.id = id;
    }

    public Article(int id, String title, String author, String description, String pictureURL) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.pictureURL = pictureURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public MultipartFile getPictureObject() {
        return pictureObject;
    }

    public void setPictureObject(MultipartFile pictureObject) {
        this.pictureObject = pictureObject;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                ", pictureObject=" + pictureObject +
                '}';
    }
}
