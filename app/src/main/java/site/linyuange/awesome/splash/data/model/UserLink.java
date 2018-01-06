package site.linyuange.awesome.splash.data.model;


public class UserLink {
    /*
    "links": {
        "self": "api.unsplash.com/users/dankapeter",
        "html": "https://unsplash.com/@dankapeter",
        "photos": "api.unsplash.com/users/dankapeter/photos",
        "likes": "api.unsplash.com/users/dankapeter/likes",
        "portfolio": "api.unsplash.com/users/dankapeter/portfolio",
        "following": "api.unsplash.com/users/dankapeter/following",
        "followers": "api.unsplash.com/users/dankapeter/followers"
    }
    */

    private String self;
    private String html;
    private String photos;
    private String likes;
    private String portfolio;
    private String following;
    private String followers;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }
}
