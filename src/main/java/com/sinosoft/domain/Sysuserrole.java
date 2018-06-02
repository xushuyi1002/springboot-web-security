package com.sinosoft.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Sysuserrole {  
      
    /**  
     */ 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private Long id;  
    /**  
     */ 
    @Column
    private Long userid;  
    /**  
     */ 
    @Column
    private Long roleid;  
    
    public Sysuserrole() {
		this.id = 0L;
		this.userid = 0L;
		this.roleid = 0L;
    }
 
}