package com.oldsteel.repository;

import com.oldsteel.entity.OurClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OurClientRepository extends JpaRepository<OurClient, Long> {
}
