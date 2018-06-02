package com.sinosoft.security;

import com.sinosoft.common.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by xushuyi on 2018/4/7.
 */
@Slf4j
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    /**
     * 判断是否拥有权限的决策方法 (最好根据权限路径拦截)
     *
     * @param authentication CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合
     * @param o              包含客户端发起的请求的requset信息，
     *                       可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest()
     * @param collection     为 MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，
     *                       此方法是为了判定用户请求的url 是否在权限表中，
     *                       如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(
            Authentication authentication,
            Object o,
            Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        log.info("开始进行判断用户是否拥有访问菜单权限权限的决策判断...");
        if (CommonUtil.isEmpty(authentication)
                || "anonymousUser".equals(authentication.getPrincipal())
                || collection.size() <= 0) {
            return;
        }
        ConfigAttribute attribute = null;
        Iterator<ConfigAttribute> iterator = collection.iterator();
        while (iterator.hasNext()){
            attribute = iterator.next();
            String menuAddress = attribute.getAttribute();
            for (GrantedAuthority ga: authentication.getAuthorities()
                 ) {
                if (menuAddress.trim().equals(ga.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
