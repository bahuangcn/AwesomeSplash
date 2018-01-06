package site.linyuange.awesome.splash.data.model;


import com.google.gson.annotations.SerializedName;

public class UserEntity {
    /*
    "user": {
        "id": "DGTVeYBRUuI",
        "updated_at": "2017-12-02T11:50:12-05:00",
        "username": "dankapeter",
        "name": "Danka & Peter",
        "first_name": "Danka",
        "last_name": "& Peter",
        "twitter_username": null,
        "portfolio_url": "http://frombusytoeasy.blogspot.sk/",
        "bio": null,
        "location": "Slovakia",
        "total_likes": 1,
        "total_photos": 22,
        "total_collections": 0,
        "profile_image": {
            ......
        },
        "links": {
            ......
        }
    }
    */

    private String id;
    private String name;
    private UserLink links;
    @SerializedName("profile_image")
    private UserProfileImage profileImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserLink getLinks() {
        return links;
    }

    public void setLinks(UserLink links) {
        this.links = links;
    }

    public UserProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(UserProfileImage profileImage) {
        this.profileImage = profileImage;
    }
}
