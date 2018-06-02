package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Sysrole {  
      
    /**  
     */ 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;  
    /**  
     */ 
    @Column
    private String name;  
    
    public Sysrole() {
		this.id = 0L;
		this.name = "";
    }
 
}