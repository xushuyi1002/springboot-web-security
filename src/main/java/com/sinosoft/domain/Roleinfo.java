package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Roleinfo {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;
    /**
     * 角色组编码
     */
    @Column
    private String roleCode;
    /**
     * 角色组名称
     */
    @Column
    private String roleName;
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

    public Roleinfo() {
        this.id = 0L;
        this.roleCode = "";
        this.roleName = "";
        this.createTime = null;
        this.modifyTime = null;
    }
}