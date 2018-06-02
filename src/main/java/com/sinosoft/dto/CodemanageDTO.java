package com.sinosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodemanageDTO {  
      
    /**
     * 主键id
     */ 
    private Long id;  
    /**
     * 字典类型
     */ 
    private String codeType;  
    /**
     * 字典编码
     */ 
    private String codeCode;  
    /**
     * 字典编码名称
     */ 
    private String codeName;  
    /**
     * 启用状态（0 未启用 1 启用）
     */ 
    private String flag;  
    /**
     * 创建时间
     */ 
    private Date createTime;
    /**
     * 修改时间
     */ 
    private Date modifyTime;  
 
}