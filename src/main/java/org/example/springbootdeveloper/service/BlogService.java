package org.example.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.domain.Article;
import org.example.springbootdeveloper.dto.AddArticleRequest;
import org.example.springbootdeveloper.dto.UpdateArticleRequest;
import org.example.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){

        return blogRepository.save(request.toEntity());
    }
    public List<Article> finAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }


    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional //all or not :어중간 하게 실행 되는 것이 아니라 완전히 실행 되거나 아니면 완전히 실행 되지 않거나 하게 하는 annotation [dirty checking 기능] 따로 db에 sql을 날리지 않다도 값이 변경 되면 자동적으로 업데이트 된다.
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(),request.getContent());

        return article;
    }




}
