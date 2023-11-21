package org.example.springbootdeveloper.dto;

import lombok.Getter;
import org.example.springbootdeveloper.domain.Article;

/*
    DB에서 들고온 원본 데이터들을 직접 사용하지 않고 Dto클래스에서 재정의 하여 사용한다.
    그러므로 프로젝트 레이어들 간의 의존도를 줄여 독립적으로 레이어들이 작동하도록 한다.
 */
@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
