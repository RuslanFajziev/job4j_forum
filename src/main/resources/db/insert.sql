insert into posts (name, description) values ('О чем этот форум?', 'Форум о  том то'),
                                             ('Правила форума', 'Никаких правил');

insert into authorities (authority) values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, authority_id)
            values ('admin', '$2a$10$tiPDC8XU6Pu7Ai4Uvo/97Ocs.5TbQr/EDkNMrcV8582poYOUU3qz6',
                    (select id from authorities where authority = 'ROLE_ADMIN'));