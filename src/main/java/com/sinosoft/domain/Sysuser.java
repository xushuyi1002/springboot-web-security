package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Sysuser {  
      
    /**  
     */ 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;  
    /**  
     */ 
    @Column
    private String username;  
    /**  
     */ 
    @Column
    private String password;  
    
    public Sysuser() {
		this.id = 0L;
		this.username = "";
		this.password = "";
    }
 
}