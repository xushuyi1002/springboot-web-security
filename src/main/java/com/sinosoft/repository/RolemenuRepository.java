package com.sinosoft.repository;

import com.sinosoft.domain.Rolemenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolemenuRepository extends JpaRepository<Rolemenu,Long> {
      
}