package com.oldsteel.repository;

import com.oldsteel.entity.PostArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostArticleRepository extends JpaRepository<PostArticle, Long> {

    List<PostArticle> findPostArticleOrderByCreationDate(String title);

    Optional<PostArticle> findPostArticleByTitle(String title);
}
