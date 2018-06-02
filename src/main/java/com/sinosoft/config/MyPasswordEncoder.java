package com.sinosoft.config;

import com.sinosoft.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by xushuyi on 2018/4/6.
 * 密码加密
 */
@Slf4j
public class MyPasswordEncoder implements PasswordEncoder {

    /**
     * 对密码进行加密
     *
     * @param charSequence 加密前密码
     * @return str
     */
    @Override
    public String encode(CharSequence charSequence) {
        return new Md5Util().getMD5ofStr(charSequence.toString());
    }

    /**
     * 验证用户登录密码与真实（创建用户保存密码）密码是否一致
     *
     * @param charSequence    用户登录输入的密码
     * @param encodedPassword 真实密码（创建用户密码、必须是加密后的）
     * @return Boolean
     */
    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        log.info("【用户输入密码】charSequence：" + charSequence +
                "【执行Md5加密】charSequence Encode：" + new Md5Util().getMD5ofStr(charSequence.toString()));
        log.info("【真实密码】encodedPassword：" + encodedPassword);
        if (encodedPassword.equals(
                new Md5Util().getMD5ofStr(charSequence.toString()))
                ) {
            return true;
        }
        log.info("用户登录密码输入错误，登录失败...");
        return false;
    }
}
