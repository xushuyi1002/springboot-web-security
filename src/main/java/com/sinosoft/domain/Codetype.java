package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Codetype {  
      
    /**
     * 主键ID
     */ 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;  
    /**
     * 字典类型
     */ 
    @Column
    private String codeType;  
    /**
     * 字典类型描述
     */ 
    @Column
    private String codeTypeDesc;  
    /**
     * 业务领域
     */ 
    @Column
    private String businessArea;  
    /**
     * 启用状态（0 未启用 1 启用）
     */ 
    @Column
    private String flag;  
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
    
    public Codetype() {
		this.id = 0L;
		this.codeType = "";
		this.codeTypeDesc = "";
		this.businessArea = "";
		this.flag = "";
		this.createTime = null;
		this.modifyTime = null;
    }
 
}