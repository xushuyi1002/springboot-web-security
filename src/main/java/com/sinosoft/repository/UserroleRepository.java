package com.sinosoft.repository;

import com.sinosoft.domain.Menuinfo;
import com.sinosoft.domain.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserroleRepository extends JpaRepository<Userrole, Long> {

    /**
     * 查询用户拥有的菜单权限
     *
     * @param userId 用户ID
     * @return MENUINFOS
     */
    @Query("SELECT " +
            "    m " +
            "FROM " +
            "    Userrole u, " +
            "    Rolemenu r, " +
            "    Menuinfo m " +
            "WHERE " +
            "    u.roleId = r.roleId AND r.menuId = m.id " +
            "        AND u.userId =:userId")
    List<Menuinfo> findUserRoleMenus(@Param(value = "userId") Long userId);
}