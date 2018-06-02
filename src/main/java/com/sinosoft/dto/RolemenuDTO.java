package com.sinosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolemenuDTO {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 菜单Id
     */
    private Long menuId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

}