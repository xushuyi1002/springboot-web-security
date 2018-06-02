package com.sinosoft.repository;

import com.sinosoft.domain.Menuinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuinfoRepository extends JpaRepository<Menuinfo,Long> {
      
}