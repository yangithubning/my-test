package com.xfqb.test.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 描述
 * 
 * @author ning yan
 * 
 * @Date 2019年1月2日 下午11:38:30
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {

	private Integer id;
	private String name;

	private Date create_time;
	private Date update_time;
	private Integer status;

}
