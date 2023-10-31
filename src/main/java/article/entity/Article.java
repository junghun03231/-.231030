package article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Article {
    private int Id;
    private String title;
    private String body;
    private String userId;
}
