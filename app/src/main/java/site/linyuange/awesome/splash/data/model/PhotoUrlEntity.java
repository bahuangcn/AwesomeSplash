package site.linyuange.awesome.splash.data.model;


public class PhotoUrlEntity {
    /*
    "urls": {
        "raw": "https://images.unsplash.com/reserve/unsplash_528b27288f41f_1.JPG",
        "full": "https://images.unsplash.com/reserve/unsplash_528b27288f41f_1.JPG?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=dfee87fd972ac8d65cf59a4ef0f2553e",
        "regular": "https://images.unsplash.com/reserve/unsplash_528b27288f41f_1.JPG?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=c1934b350c10be47983ac07ca7a55472",
        "small": "https://images.unsplash.com/reserve/unsplash_528b27288f41f_1.JPG?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=ca711c63e11a157bd3d70c9418e82ae3",
        "thumb": "https://images.unsplash.com/reserve/unsplash_528b27288f41f_1.JPG?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=edfc8fa701a4a057aea636c400804d0e"
    }
    */
    private String raw;
    private String full;
    private String regular;
    private String small;
    private String thumb;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
