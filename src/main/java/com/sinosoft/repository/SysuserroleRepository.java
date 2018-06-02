package com.sinosoft.repository;

import com.sinosoft.domain.Sysuserrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysuserroleRepository extends JpaRepository<Sysuserrole,Long> {


}