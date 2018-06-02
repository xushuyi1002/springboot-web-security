package com.sinosoft.security;

import com.sinosoft.common.CommonUtil;
import com.sinosoft.domain.Menuinfo;
import com.sinosoft.repository.MenuinfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by xushuyi on 2018/4/7.
 */
@Slf4j
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {


    /**
     * 菜单事物层
     */
    @Autowired
    private MenuinfoRepository menuinfoRepository;

    /**
     * 自定义权限容器
     */
    private Map<String, Collection<ConfigAttribute>> collectionMap = null;

    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，
     * 如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
     *
     * @param object 包含用户请求的request 信息
     * @return collection
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        log.info("开始进行判断用户请求的角色是否在权限表中...");
        if (CommonUtil.isEmpty(collectionMap)) {
            loadResourceDefine();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        // 获取请求的资源路径
        String reqUrl = request.getRequestURI();
        if (!CommonUtil.isEmpty(reqUrl)){
            // 开始判断请求的资源路径是否为系统的菜单路径
            for (Map.Entry<String, Collection<ConfigAttribute>> entry : collectionMap.entrySet()
                    ) {
                Collection<ConfigAttribute> configAttributes = entry.getValue();
                for (ConfigAttribute attribute : configAttributes
                        ) {
                    String menuAddress = attribute.getAttribute();
                    if (reqUrl.endsWith(menuAddress)){
                        return configAttributes;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 加载权限表所有权限
     */
    private void loadResourceDefine() {
        log.info("开始加载权限表所有权限...");
        collectionMap = new HashMap<>();
        Collection<ConfigAttribute> configAttributes = null;
        ConfigAttribute attribute = null;
        // 查询所有的菜单 加入的权限的决策判断容器中
        List<Menuinfo> menuinfoList = menuinfoRepository.findAll();
        if (!CommonUtil.isEmpty(menuinfoList) && menuinfoList.size() > 0) {
            configAttributes = new ArrayList<>();
            for (Menuinfo menuinfo : menuinfoList
                    ) {
                attribute = new SecurityConfig(menuinfo.getMenuAddress());
                // 此处只添加了菜单的访问路径，其实还可以添加更多权限的信息，例如将请求方法添加到ConfigAttribute的集合中去
                // 此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数
                configAttributes.add(attribute);
            }
            // 将角色的id作为collectionMap的key值，用ConfigAttribute的集合作为value
            collectionMap.put("AllMenuinfo", configAttributes);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
