package com.sinosoft.security;

import com.sinosoft.common.CommonUtil;
import com.sinosoft.domain.Menuinfo;
import com.sinosoft.domain.Userinfo;
import com.sinosoft.repository.UserinfoRepository;
import com.sinosoft.repository.UserroleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by xushuyi on 20180602.
 */
@Slf4j
@Service
public class CustomUserService implements UserDetailsService {

    /**
     * 用户信息事物层
     */
    @Autowired
    private UserinfoRepository userinfoRepository;

    /**
     * 用户角色事物层
     */
    @Autowired
    private UserroleRepository userroleRepository;


    /**
     * 根据用户登录信息判断用户是否存在
     *
     * @param userName 登录用户名
     * @return 用户详情
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 查询登录用户信息
        Userinfo userinfo = userinfoRepository.findByUserName(userName);
        if (CommonUtil.isEmpty(userinfo)) {
            throw new UsernameNotFoundException("username: " + userName + " do not exist!");
        }
        log.info("username：" + userinfo.getUserName() + "    password：" + userinfo.getPassWord());
        // 查询用户拥有的菜单权限
        List<Menuinfo> menuinfos = userroleRepository.findUserRoleMenus(userinfo.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Menuinfo menuinfo : menuinfos) {
            // 此处将访问页面权限信息添加到GrantedAuthority对象中，在后面进行全权限验证时会使用GrantedAuthority对象
            authorities.add(new SimpleGrantedAuthority(menuinfo.getMenuAddress()));
        }
        return new User(userinfo.getUserName(), userinfo.getPassWord(), authorities);
    }
}
