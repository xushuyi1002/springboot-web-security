package com.sinosoft.repository;

import com.sinosoft.domain.Codemanage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodemanageRepository extends PagingAndSortingRepository<Codemanage,Long> {
      
}