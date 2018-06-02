package com.sinosoft.repository;

import com.sinosoft.domain.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {

    /**
     * 根据登录用户名查询登录用户信息
     *
     * @param userName 登录用户名
     * @return 用户对象
     */
    Userinfo findByUserName(String userName);

}