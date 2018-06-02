package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Menuinfo {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    /**
     * 菜单编码
     */
    @Column
    private String menuCode;
    /**
     * 菜单名称
     */
    @Column
    private String menuName;
    /**
     * 菜单图片
     */
    @Column
    private String menuIcon;
    /**
     * 菜单地址
     */
    @Column
    private String menuAddress;
    /**
     * 父级菜单
     */
    @Column
    private String superMenu;
    /**
     * 子菜单个数
     */
    @Column
    private Integer childCount;
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

    public Menuinfo() {
        this.id = 0L;
        this.menuCode= "";
        this.menuName = "";
        this.menuIcon = "";
        this.menuAddress = "";
        this.superMenu = "";
        this.childCount = 0;
        this.createTime = null;
        this.modifyTime = null;
    }
}