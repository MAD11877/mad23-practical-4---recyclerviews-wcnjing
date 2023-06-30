package sg.edu.np.mad.practicalmad;

import android.media.Image;

public class User {
    private Image userImage;
    private String name;
    private String description;

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }



}