package main.Models.Typicode.AOM.deserialized;

import lombok.Getter;
import lombok.Setter;

public class Comment {
    @Getter
    @Setter
    private int postId;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String body;

    @Override
    public String toString() {
        return "Comment{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
