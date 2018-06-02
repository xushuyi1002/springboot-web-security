package com.sinosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleinfoDTO {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 角色组编码
     */
    private String roleCode;
    /**
     * 角色组名称
     */
    private String roleName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

}