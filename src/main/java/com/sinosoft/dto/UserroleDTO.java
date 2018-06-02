package com.sinosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserroleDTO {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

}