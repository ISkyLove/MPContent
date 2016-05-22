package lc.mpcontent.bean;

/**
 * Created by lin on 16-5-22.
 */
public class BlogBean {

    private int id;
    private String title;
    private String author;
    private String url;
    private String tabs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTabs(String tabs) {
        this.tabs = tabs;
    }

    public String getTabs() {
        return tabs;
    }
}
