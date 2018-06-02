package com.sinosoft.repository;

import com.sinosoft.domain.Sysuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysuserRepository extends JpaRepository<Sysuser, Long> {

    Sysuser findByUsername(String username);

    @Query("SELECT " +
            "    u.roleid " +
            "FROM " +
            "    Sysuser r, " +
            "    Sysuserrole u " +
            "WHERE " +
            "    r.id = u.userid AND r.username =:username")
    String findByUsername1(@Param(value = "username") String username);
}