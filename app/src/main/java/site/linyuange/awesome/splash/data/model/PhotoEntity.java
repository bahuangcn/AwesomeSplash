package site.linyuange.awesome.splash.data.model;


public class PhotoEntity {
    /*
    {
        "id": "uwQlgl4NbSg",
        "created_at": "2013-11-19T03:54:03-05:00",
        "updated_at": "2017-11-01T02:27:36-04:00",
        "width": 2088,
        "height": 1392,
        "color": "#888B88",
        "likes": 1568,
        "liked_by_user": false,
        "description": "A woman in a dress standing on a rock on the coast with waves crashing against the nearby rocks",
        "user": {
            ......
        },
        "current_user_collections": [],
        "urls": {
            ......
        },
        "categories": [],
        "links": {
            ......
        }
    }
    */

    private String id;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String color;

    private int likes;
    private int width;
    private int height;

    private PhotoUrlEntity urls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public PhotoUrlEntity getUrls() {
        return urls;
    }

    public void setUrls(PhotoUrlEntity urls) {
        this.urls = urls;
    }
}
