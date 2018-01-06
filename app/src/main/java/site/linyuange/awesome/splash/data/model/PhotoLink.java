package site.linyuange.awesome.splash.data.model;


public class PhotoLink {
    /*
    "links": {
        "self": "api.unsplash.com/photos/uwQlgl4NbSg",
        "html": "https://unsplash.com/photos/uwQlgl4NbSg",
        "download": "https://unsplash.com/photos/uwQlgl4NbSg/download",
        "download_location": "api.unsplash.com/photos/uwQlgl4NbSg/download"
    }
    */

    private String self;
    private String html;
    private String download;
    private String downloadLocation;

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

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }
}
