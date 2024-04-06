set foreign_key_checks = 0;

delete from user;

set foreign_key_checks = 1;

insert into user (id, nome, email, password, data_cadastro) values (1, 'username', 'alefagundes@gmail.com', '$2a$10$GiseHkdvwOFr7A9KRWbeiOmg/PYPhWVjdm42puLfOzR/gIAQrsAGy', CURRENT_TIMESTAMP);