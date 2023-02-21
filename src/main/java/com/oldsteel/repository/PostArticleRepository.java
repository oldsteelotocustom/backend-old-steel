package com.oldsteel.repository;

import com.oldsteel.entity.PostArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PostArticleRepository extends JpaRepository<PostArticle, Long> {

    List<PostArticle> findPostArticleOrderByCreationDate(Pageable pageable);
}
