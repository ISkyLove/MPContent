package lc.mpcontent.bean;

/**
 * Created by lin on 16-5-22.
 */
public class WebBean {

    private int id;
    private String title;
    private String url;
    private String logo;
    private String ico;
    private String description;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder mBuilder = new StringBuilder();
        mBuilder.append("webbean :");
        mBuilder.append(" id=");
        mBuilder.append(id);
        mBuilder.append(" title=");
        mBuilder.append(title);
        mBuilder.append(" url=");
        mBuilder.append(url);
        mBuilder.append(" logo=");
        mBuilder.append(logo);
        mBuilder.append(" ico=");
        mBuilder.append(ico);
        mBuilder.append(" dec=");
        mBuilder.append(description);

        return mBuilder.toString();
    }
}
