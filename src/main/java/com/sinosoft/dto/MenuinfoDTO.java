package com.sinosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuinfoDTO {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 菜单编码
     */
    private String menuCode;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单图片
     */
    private String menuIcon;
    /**
     * 菜单地址
     */
    private String menuAddress;
    /**
     * 父级菜单
     */
    private String superMenu;
    /**
     * 子菜单个数
     */
    private Integer childCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

}