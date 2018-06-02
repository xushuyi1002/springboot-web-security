package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Userrole implements Serializable {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    /**
     * 用户Id
     */
    @Column
    private Long userId;
    /**
     * 角色Id
     */
    @Column
    private Long roleId;
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

    public Userrole() {
        this.id = 0L;
        this.userId = 0L;
        this.roleId = 0L;
        this.createTime = null;
        this.modifyTime = null;
    }

}