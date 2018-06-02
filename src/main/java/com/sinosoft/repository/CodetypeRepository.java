package com.sinosoft.repository;

import com.sinosoft.domain.Codetype;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodetypeRepository extends PagingAndSortingRepository<Codetype,Long> {
      
}