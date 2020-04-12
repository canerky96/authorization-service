INSERT INTO oauth_client_details
            (client_id,
             client_secret,
             web_server_redirect_uri,
             scope,
             access_token_validity,
             refresh_token_validity,
             resource_ids,
             authorized_grant_types,
             additional_information)
VALUES      ( 'web',
'{bcrypt}$2a$10$1aXOut4IfOSGCeRyV13vjejDDZYrYdt0ZO3zF8eQNS6gtpnJtewFi',
NULL,
'READ,WRITE',
'3600',
'10000',
'inventory,payment',
'authorization_code,password,refresh_token,implicit',
'{}' );

INSERT INTO permission(id, create_date, update_date, code, name) VALUES ('e6336fe0-2642-47b2-887a-7fa26263f60d', NOW(), NULL, 'create_user', 'Create User');
INSERT INTO permission(id, create_date, update_date, code, name) VALUES ('b54f94e2-fa10-43b9-b961-924b26782032', NOW(), NULL, 'create_permission', 'Create Permission');
INSERT INTO permission(id, create_date, update_date, code, name) VALUES ('bf2e96d6-8d66-4722-b581-829c4c55df7f', NOW(), NULL, 'create_role', 'Create Role');

INSERT INTO role(id, create_date, update_date, code, name) VALUES ('9922b2de-5991-4a2f-9ff3-4c9cb7db3f3e', NOW(), NULL, 'admin', 'Admin');

INSERT INTO auth_user(
	id, create_date, update_date, password, username, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled)
VALUES (
	'6beb3d3c-9da2-4863-a627-2fb540c1d324',
	NOW(),
	NULL,
	'{bcrypt}$2a$10$uUCbS3ndMAAjSL5dCxKN6OA8M8F/RUH2Le94Yg63HOVAcLy3wiYya',
	'admin',
	true,
	true,
	true,
	true);

INSERT INTO permission_role (role_id, permission_id) VALUES ('9922b2de-5991-4a2f-9ff3-4c9cb7db3f3e', 'e6336fe0-2642-47b2-887a-7fa26263f60d');
INSERT INTO permission_role (role_id, permission_id) VALUES ('9922b2de-5991-4a2f-9ff3-4c9cb7db3f3e', 'b54f94e2-fa10-43b9-b961-924b26782032');
INSERT INTO permission_role (role_id, permission_id) VALUES ('9922b2de-5991-4a2f-9ff3-4c9cb7db3f3e', 'bf2e96d6-8d66-4722-b581-829c4c55df7f');

INSERT INTO role_user(user_id, role_id) VALUES ('6beb3d3c-9da2-4863-a627-2fb540c1d324', '9922b2de-5991-4a2f-9ff3-4c9cb7db3f3e');


