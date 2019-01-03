package com.xfqb.test.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 描述
 * 
 * @author ning yan
 * 
 * @Date 2019年1月2日 下午5:21:37
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;

	/**
	 * name
	 */
	private String name;
}
