package com.sinosoft.repository;

import com.sinosoft.domain.Roleinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleinfoRepository extends JpaRepository<Roleinfo, Long> {

    /**
     * 查询所有的角色菜单
     *
     * @return list
     */
//    @Query("SELECT " +
//            "    r.id, m " +
//            "FROM " +
//            "    Roleinfo r, " +
//            "    Rolemenu rm, " +
//            "    Menuinfo m " +
//            "WHERE " +
//            "    r.id = rm.rolemenuId.roleId AND rm.rolemenuId.menuId = m.id")
//    List<Object[]> findAllRoleMenus();
}