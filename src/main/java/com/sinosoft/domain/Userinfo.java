package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Userinfo {

    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    /**
     * 用户编码
     */
    @Column
    private String userCode;
    /**
     * 用户名称
     */
    @Column
    private String userName;
    /**
     * 密码
     */
    @Column
    private String passWord;
    /**
     * 手机号
     */
    @Column
    private String phone;
    /**
     * 身份证号
     */
    @Column
    private String idCardNo;
    /**
     * 公司邮箱
     */
    @Column
    private String email;
    /**
     * 账户编码
     */
    @Column
    private String accountCode;
    /**
     * 部门编码
     */
    @Column
    private String deptCode;
    /**
     * 公司编码
     */
    @Column
    private String companyCode;
    /**
     * 银行机构
     */
    @Column
    private String bankCode;
    /**
     * 银行机构名称
     */
    @Column
    private String bankName;
    /**
     * 创建时间
     */
    @Column
    private Date createTime;
    /**
     * 修改时间
     */
    @Column
    private Date modifyTime;

    public Userinfo() {
        this.id = 0L;
        this.userCode = "";
        this.userName = "";
        this.passWord = "";
        this.phone = "";
        this.idCardNo = "";
        this.email = "";
        this.accountCode = "";
        this.deptCode = "";
        this.companyCode = "";
        this.bankCode = "";
        this.bankName = "";
        this.createTime = null;
        this.modifyTime = null;
    }

}