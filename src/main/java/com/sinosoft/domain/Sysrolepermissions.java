package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Sysrolepermissions {  
      
    /**  
     */ 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;  
    /**  
     */ 
    @Column
    private Long roleId;  
    /**  
     */ 
    @Column
    private String permissionPath;  
    
    public Sysrolepermissions() {
		this.id = 0L;
		this.roleId = 0L;
		this.permissionPath = "";
    }
 
}