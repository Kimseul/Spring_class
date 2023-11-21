package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.ArticleListViewResponse;
import org.example.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.finAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles",articles);//블로그 글 리스트 저장

        return "articleList"; //articleList.html라는 뷰 조회
    }
}
