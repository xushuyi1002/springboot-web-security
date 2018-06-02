package com.sinosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodetypeDTO {  
      
    /**
     * 主键
     */ 
    private Long id;  
    /**
     * 字典类型
     */ 
    private String codeType;  
    /**
     * 字典类型描述
     */ 
    private String codeTypeDesc;  
    /**
     * 业务领域
     */ 
    private String businessArea;  
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