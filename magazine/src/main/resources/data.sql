SET SEARCH_PATH TO public;

INSERT INTO role (role_id, name)
VALUES (1, 'ADMIN');
INSERT INTO role (role_id, name)
VALUES (2, 'USER');



INSERT INTO users (id_role, user_id, name, password)
VALUES (1, 1, 'admin',
        '1234');
INSERT INTO users (id_role, user_id, name, password)
VALUES (2, 2, 'user', '1234');


INSERT INTO authority (authority_id, name)
VALUES (1, 'READ_MAGAZINE');
INSERT INTO authority (authority_id, name)
VALUES (2, 'CREATE_MAGAZINE');
INSERT INTO authority (authority_id, name)
VALUES (3, 'UPDATE_MAGAZINE');
INSERT INTO authority (authority_id, name)
VALUES (4, 'DELETE_MAGAZINE');

INSERT INTO role_authority (id_authority, id_role)
VALUES (1, 1);
INSERT INTO role_authority (id_authority, id_role)
VALUES (2, 1);
INSERT INTO role_authority (id_authority, id_role)
VALUES (3, 1);
INSERT INTO role_authority (id_authority, id_role)
VALUES (4, 1);
INSERT INTO role_authority (id_authority, id_role)
VALUES (1, 2);