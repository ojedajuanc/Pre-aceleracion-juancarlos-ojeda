package com.alkemy.ojedajuanc.disney.persistence.repository.specification;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alkemy.ojedajuanc.disney.persistence.entity.Media;
import com.alkemy.ojedajuanc.disney.pojos.MediaFilter;

@Component
public class MediaSpecification {

	public Specification<Media> getByFilters(MediaFilter filters) {
		return (root, query, builder) -> {
			Collection<Predicate> predicates = new LinkedList<>();

			if (StringUtils.hasLength(filters.getTitle())) {
				
				predicates.add(
						builder.like(
								builder.lower( root.<String> get("title") ),
								"%" + filters.getTitle().toLowerCase() + "%"
								)
				);
			}
			
			if (filters.getGenreId() != null) {
				predicates.add(
						root.get("genreId").in(filters.getGenreId()));
			}
			
			query.distinct(true);
			
			// TODO: Add predicate to return Media only if typeName == "MOVIE"
			
			// Only returns list of active Media
			predicates.add(builder.isTrue(root.get("active")));
			
			String orderByField = "releaseDate";
			query.orderBy(
					(filters.getOrder().equalsIgnoreCase("DESC")) ?
							builder.desc(root.get(orderByField))  :
							builder.asc(root.get(orderByField))
					);
			
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}

}
