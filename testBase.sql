INSERT INTO `shitot_new`.`doctors` (`id`, `name`, `comments`, `email`, `lections`, `login`, `password`, `preferential`, `telAdditional`, `telNumber`, `certificate_id`) VALUES ('1', 'Vladimir Potapov', 'vrach', 'c@c.ru', NULL, 'vpotapov', '123', NULL, NULL, NULL, NULL);
INSERT INTO `shitot_new`.`doctors` (`id`, `name`, `comments`, `email`, `lections`, `login`, `password`, `preferential`, `telAdditional`, `telNumber`, `certificate_id`) VALUES ('2', 'Inna Potapov', 'vrach', 'c@c.ru', NULL, 'vpotapov', '123', NULL, NULL, NULL, NULL);
INSERT INTO `shitot_new`.`specialties` (`id`, `name`) VALUES ('3', 'patalogoanatom');
INSERT INTO `shitot_new`.`specialties` (`id`, `name`) VALUES ('4', 'venerolog');
INSERT INTO `shitot_new`.`doctors_specialties` (`doctors_id`, `specialties_id`) VALUES ('1', '3');
INSERT INTO `shitot_new`.`doctors_specialties` (`doctors_id`, `specialties_id`) VALUES ('1', '4');

