package com.sinosoft.repository;

import com.sinosoft.domain.Sysrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysroleRepository extends JpaRepository<Sysrole, Long> {

    @Query("SELECT " +
            "    r " +
            "FROM " +
            "    Sysrole r, " +
            "    Sysuserrole u " +
            "WHERE " +
            "    r.id = u.roleid AND u.userid =:userid")
    List<Sysrole> findByUserid(@Param(value = "userid") Long id);
}