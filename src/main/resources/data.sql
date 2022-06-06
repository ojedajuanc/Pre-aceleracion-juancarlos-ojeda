INSERT INTO `genres` (`id`,`name`,`picture`) VALUES (null,'Fantasía','https://...')
INSERT INTO `genres` (`id`,`name`,`picture`) VALUES (null,'Aventura','https://...')
INSERT INTO `genres` (`id`,`name`,`picture`) VALUES (null,'Drama','https://...')
INSERT INTO `genres` (`id`,`name`,`picture`) VALUES (null,'Comedia','https://...')
INSERT INTO `genres` (`id`,`name`,`picture`) VALUES (null,'Romántica','https://...')

INSERT INTO `media_type` (`id`,`name`) VALUES (null,'PELICULA')
INSERT INTO `media_type` (`id`,`name`) VALUES (null,'SERIE')

INSERT INTO `media` (`id`,`title`,`release_date`,`picture`,`rating`,`genre_id`,`media_type_name`,`active_status`) VALUES (null,'Aladdin','1992-01-01','https://...','5','1','PELICULA',true)
INSERT INTO `media` (`id`,`title`,`release_date`,`picture`,`rating`,`genre_id`,`media_type_name`,`active_status`) VALUES (null,'Tarzan','1999-01-01','https://...','4','3','PELICULA',true)
INSERT INTO `media` (`id`,`title`,`release_date`,`picture`,`rating`,`genre_id`,`media_type_name`,`active_status`) VALUES (null,'Mulan','1998-01-01','https://...','4.5','2','PELICULA',true)
INSERT INTO `media` (`id`,`title`,`release_date`,`picture`,`rating`,`genre_id`,`media_type_name`,`active_status`) VALUES (null,'The Lion King','1994-01-01','https://...','4.3','3','PELICULA',false)
			 
INSERT INTO `characters` (`id`,`name`,`age`,`weight`,`story`,`picture`,`active_status`) VALUES (null,'Aladdin','26','1','Aladdin es el valiente protagonista de la película Aladdin. Es también el héroe de Return of Jafar, Aladdin and the King of Thieves y Aladdin (the series).','https://...',true)
INSERT INTO `characters` (`id`,`name`,`age`,`weight`,`story`,`picture`,`active_status`) VALUES (null,'Jasmín','26','2','Jasmín es la co-protagonista de la película de animación de Disney de 1992, Aladdin, sus dos secuelas y serie de televisión animada.','https://...',true)
INSERT INTO `characters` (`id`,`name`,`age`,`weight`,`story`,`picture`,`active_status`) VALUES (null,'Genio','10000','3','Es un Genio, un espíritu cómico, muy poderoso, que actúa como un sirviente de quien tiene la propiedad de la Lámpara Mágica en la que reside.','https://...',true)
INSERT INTO `characters` (`id`,`name`,`age`,`weight`,`story`,`picture`,`active_status`) VALUES (null,'Tarzán','40','1','Comúnmente conocido como el "Rey de la Selva", Tarzán fue rescatado y criado por una colonia de monos después de que sus padres fueran asesinados por el sanguinario Sabor. A medida que pasaron los años, se convirtió en un hombre simio, protegiendo a todos los simios, y nunca conociendo el mundo exterior, aparte de la selva.','https://...',false)
INSERT INTO `characters` (`id`,`name`,`age`,`weight`,`story`,`picture`,`active_status`) VALUES (null,'Simba','18','1','Simba es el protagonista de la película The Lion King. Hijo de Mufasa y Sarabi,','https://...',true)

INSERT INTO `character_media` (`media_id`,`character_id`) VALUES ('1','1')
INSERT INTO `character_media` (`media_id`,`character_id`) VALUES ('1','2')
INSERT INTO `character_media` (`media_id`,`character_id`) VALUES ('1','3')
INSERT INTO `character_media` (`media_id`,`character_id`) VALUES ('2','4')