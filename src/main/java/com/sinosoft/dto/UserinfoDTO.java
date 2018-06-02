package com.sinosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserinfoDTO {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 身份证号
     */
    private String idCardNo;
    /**
     * 公司邮箱
     */
    private String email;
    /**
     * 账户编码
     */
    private String accountCode;
    /**
     * 部门编码
     */
    private String deptCode;
    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 银行机构
     */
    private String bankCode;
    /**
     * 银行机构名称
     */
    private String bankName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

}