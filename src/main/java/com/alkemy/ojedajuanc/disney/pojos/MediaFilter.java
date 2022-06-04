package com.alkemy.ojedajuanc.disney.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MediaFilter {
	
	private String title;
	private Long genreId;
	private String order;
	
	public MediaFilter(String title, Long genreId, String order) {
		this.title = title;
		this.genreId = genreId;
		this.order = (order.equalsIgnoreCase("ASC")) ? "ASC" : "DESC";
	}
	
}
