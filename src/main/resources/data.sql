INSERT into COMPETITION_TYPES (type)
values ('Mistrzostwa europy');

INSERT INTO COUNTRIES (country)
values ('Poland');

INSERT INTO Cities (city_id, name, country)
values (1, 'Krakow', 'Poland');

INSERT INTO COMPETITIONs_DETAILS (competition_details_id, competitors_registration_end_date,
                                  competitors_registration_start_date, link_to_organisational_announcement,
                                  referees_registration_end_date, referees_registration_start_date)
values (1, '2022-07-19', '2022-07-15', 'some_link', '2022-07-10', '2022-07-5');

INSERT into COMPETITIONS (competition_id, end_date, name, start_date, city_id, competition_details_id, type)
values (1, '2022-07-18', 'Mistrzostwa europy Warszawa', '2022-07-20', 1, 1, 'Mistrzostwa europy');



INSERT INTO REGIONS (region)
values ('Karpaty');

INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year, region)
values (1, 'Senior', '2000-01-01', '2002-12-31', 'Karpaty');
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year, region)
values (2, 'Młodzik', '2003-01-01', '2005-12-31', 'Karpaty');

INSERT into SEXES (sex)
values ('male');
INSERT into SEXES (sex)
values ('female');

INSERT into CATEGORIES (category_id, weight_category, age_category_id, sex)
values (1, '110', 1, 'male');
INSERT into CATEGORIES (category_id, weight_category, age_category_id, sex)
values (2, '90', 2, 'female');

INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, date, category_id, competition_id)
values (1, '2022-07-19', 1, 1);
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, date, category_id, competition_id)
values (2, '2022-07-19', 2, 1);

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (1, 'Marcin', 'Warchoł', '727731521', '1.jpg', '2000-09-02', 'male','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (2, 'Gabriela', 'Erazmus', '727731521', '2.jpg', '2004-05-03', 'female','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (3, 'Anna', 'Kowalska', '727731521', '2.jpg', '2004-07-03', 'female','Poland');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (5, 'Zofia', 'War', '727731521', '2.jpg', '2004-09-03', 'female','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (6, 'Karolina', 'Opal', '727731521', '2.jpg', '2004-01-03', 'female','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (7, 'Zuzanna', 'Loker', '727731521', '2.jpg', '2004-02-03', 'female','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (8, 'Katarzyna', 'Parun', '727731521', '2.jpg', '2004-03-03', 'female','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (9, 'Jolanta', 'Wena', '727731521', '2.jpg', '2004-04-03', 'female','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (10, 'Joanna', 'Waga', '727731521', '2.jpg', '2004-06-03', 'female','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (11, 'Aleksandra', 'Lora', '727731521', '2.jpg', '2004-04-08', 'female','Poland');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (12, 'Krzysztof', 'JarzynaZeSzczecina', '727731521', '2.jpg', '1972-04-03', 'male','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (13, 'Bruce', 'Lee', '727731521', '2.jpg', '1954-06-03', 'male','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (14, 'Leonardo', 'Di caprio', '727731521', '2.jpg', '1990-04-08', 'male','Poland');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (15, 'Zbigniew', 'Stranc', '727731521', '2.jpg', '1954-06-03', 'male','Poland');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date,
                              sex,country)
values (16, 'Jakub', 'Wlazlo', '727731521', '2.jpg', '1990-04-08', 'male','Poland');



INSERT into COMPETITORS (competitor_id, status, personal_details_id)
values (1, 1, 1);
INSERT into COMPETITORS (competitor_id, status, personal_details_id)
values (2, 1, 2);
INSERT into COMPETITORS (competitor_id, status, personal_details_id)
values (3, 2, 3);
INSERT into COMPETITORS (competitor_id, status, personal_details_id)
values (5, 1, 5);
INSERT into COMPETITORS (competitor_id, status, personal_details_id)
values (6, 1, 6);
INSERT into COMPETITORS (competitor_id, status, personal_details_id)
values (7, 2, 7);


INSERT INTO COACHES (coach_id, personal_details_id)
values (1, 12);
INSERT INTO COACHES (coach_id, personal_details_id)
values (2, 13);
INSERT INTO COACHES (coach_id, personal_details_id)
values (3, 14);

INSERT INTO DRAW_TYPES (draw_type_id, number_of_competitors, region)
values (1, 10, 'Karpaty');
INSERT INTO DRAW_TYPES (draw_type_id, number_of_competitors, region)
values (2, 15, 'Karpaty');
INSERT INTO DRAW_TYPES (draw_type_id, number_of_competitors, region)
values (3, 32, 'Karpaty');

INSERT INTO DRAWS (draw_id, category_at_competition_id, draw_type_id)
values (1, 1, 1);
INSERT INTO DRAWS (draw_id, category_at_competition_id, draw_type_id)
values (2, 2, 2);



INSERT INTO NATIONAL_TEAMS_ADMINS (national_team_admin_id, personal_details_id)
values (1, 15);
INSERT INTO NATIONAL_TEAMS_ADMINS (national_team_admin_id, personal_details_id)
values (2, 16);

INSERT INTO COMPETITORS_REGISTRATIONS_BY_NATIONAL_TEAMS_ADMINS(COMPETITOR_REGISTRATION_BY_NATIONAL_TEAM_ADMIN_ID,
                                                               is_accepted_by_esf_admin, category_at_competition,
                                                               competitor_id, national_team_admin_id)
values (1, true, 1, 1, 1);
INSERT INTO COMPETITORS_REGISTRATIONS_BY_NATIONAL_TEAMS_ADMINS(COMPETITOR_REGISTRATION_BY_NATIONAL_TEAM_ADMIN_ID,
                                                               is_accepted_by_esf_admin, category_at_competition,
                                                               competitor_id, national_team_admin_id)
values (2, true, 1, 2, 1);
INSERT INTO COMPETITORS_REGISTRATIONS_BY_NATIONAL_TEAMS_ADMINS(COMPETITOR_REGISTRATION_BY_NATIONAL_TEAM_ADMIN_ID,
                                                               is_accepted_by_esf_admin, category_at_competition,
                                                               competitor_id, national_team_admin_id)
values (3, true, 1, 3, 2);

-- adding roles to system

INSERT INTO USER_ROLES (ROLE_ID, ROLE_NAME)
VALUES (1, 'SUPER_ADMIN');
INSERT INTO USER_ROLES (ROLE_ID, ROLE_NAME)
VALUES (3, 'CLUB_COACH');
INSERT INTO USER_ROLES (ROLE_ID, ROLE_NAME)
VALUES (5, 'NATIONAL_COACH');
INSERT INTO USER_ROLES (ROLE_ID, ROLE_NAME)
VALUES (7, 'NATIONAL_ADMIN');
INSERT INTO USER_ROLES (ROLE_ID, ROLE_NAME)
VALUES (9, 'ESF_ADMIN');

-- adding personal details
INSERT INTO PERSONAL_DETAILS(personal_details_id, birth_date, email, link_to_profile_picture, name, phone_number, surname, sex)
values (100, '2000-10-10', null, null, 'Andrzej', null, 'Jedynak', 'male');


-- adding sample users

INSERT INTO LOGIN_DETAILS (USER_ID, PASSWORD, USERNAME, PERSONAL_DETAILS_ID)
VALUES (1, '$2a$10$jzyXBJ.QX8qbm.cu5dMiMu7TuTaoGTqRVCCD/2xdbSmlA0v9xLa42', 'Endriu1', 100);

-- adding roles to users

INSERT INTO LOGIN_DETAILS_ROLES(USER_USER_ID, ROLES_ROLE_ID)
VALUES (1, 1);
INSERT INTO LOGIN_DETAILS_ROLES(USER_USER_ID, ROLES_ROLE_ID)
VALUES (1, 5);
INSERT INTO LOGIN_DETAILS_ROLES(USER_USER_ID, ROLES_ROLE_ID)
VALUES (1, 7);
INSERT INTO LOGIN_DETAILS_ROLES(USER_USER_ID, ROLES_ROLE_ID)
VALUES (1, 9);
INSERT INTO LOGIN_DETAILS_ROLES(USER_USER_ID, ROLES_ROLE_ID)
VALUES (1, 3);

-- adding users to tables of roles
INSERT INTO coaches(coach_id, personal_details_id)
VALUES (5, 100);

-- Creating national teams
Insert INTO NATIONAL_TEAMS(NATIONAL_TEAM_ID, COUNTRY)
VALUES (5, 'Poland');

-- Creating national team membership for coach
INSERT INTO NATIONAL_TEAM_MEMBERSHIPS_OF_COACHES(NATIONAL_TEAM_MEMBERSHIP_OF_COACH_ID, MEMBERSHIP_END, MEMBERSHIP_START,
                                                 COACH_ID, NATIONAL_TEAM_ID)
values (1, null, '2000-05-10',5,5);



