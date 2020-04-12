create table oauth_client_details
(
    client_id               VARCHAR(256) PRIMARY KEY,
    resource_ids            VARCHAR(256),
    client_secret           VARCHAR(256),
    scope                   VARCHAR(256),
    authorized_grant_types  VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities             VARCHAR(256),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(4096),
    autoapprove             VARCHAR(256)
);

create table oauth_client_token
(
    token_id          VARCHAR(256),
    token             bytea,
    authentication_id VARCHAR(256),
    user_name         VARCHAR(256),
    client_id         VARCHAR(256)
);

create table oauth_access_token
(
    token_id          VARCHAR(256),
    token             bytea,
    authentication_id VARCHAR(256),
    user_name         VARCHAR(256),
    client_id         VARCHAR(256),
    authentication    bytea,
    refresh_token     VARCHAR(256)
);

create table oauth_refresh_token
(
    token_id       VARCHAR(256),
    token          bytea,
    authentication bytea
);

create table oauth_code
(
    code           VARCHAR(256),
    authentication bytea
);

create table oauth_approvals
(
    userId         VARCHAR(256),
    clientId       VARCHAR(256),
    scope          VARCHAR(256),
    status         VARCHAR(10),
    expiresAt      TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

CREATE TABLE auth_user
(
    id                         CHARACTER VARYING NOT NULL,
    create_date                TIMESTAMP WITH TIME ZONE,
    update_date                TIMESTAMP WITH TIME ZONE,
    password                   CHARACTER VARYING NOT NULL,
    username                   CHARACTER VARYING NOT NULL,
    is_account_non_expired     boolean           NOT NULL,
    is_account_non_locked      boolean           NOT NULL,
    is_credentials_non_expired boolean           NOT NULL,
    is_enabled                 boolean           NOT NULL
);
ALTER TABLE auth_user
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);

CREATE TABLE role
(
    id          CHARACTER VARYING NOT NULL,
    create_date TIMESTAMP WITH TIME ZONE,
    update_date TIMESTAMP WITH TIME ZONE,
    code        CHARACTER VARYING NOT NULL,
    name        CHARACTER VARYING NOT NULL
);
ALTER TABLE role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);

CREATE TABLE permission
(
    id          CHARACTER VARYING NOT NULL,
    create_date TIMESTAMP WITH TIME ZONE,
    update_date TIMESTAMP WITH TIME ZONE,
    code        CHARACTER VARYING NOT NULL,
    name        CHARACTER VARYING NOT NULL
);
ALTER TABLE permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


CREATE TABLE permission_role
(
    role_id       CHARACTER VARYING NOT NULL REFERENCES role (id) ON UPDATE CASCADE ON DELETE CASCADE,
    permission_id CHARACTER VARYING NOT NULL REFERENCES permission (id) ON UPDATE CASCADE,
    CONSTRAINT permission_role_pkey PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE role_user
(
    user_id CHARACTER VARYING NOT NULL REFERENCES auth_user (id) ON UPDATE CASCADE ON DELETE CASCADE,
    role_id CHARACTER VARYING NOT NULL REFERENCES role (id) ON UPDATE CASCADE,
    CONSTRAINT role_user_pkey PRIMARY KEY (user_id, role_id)
);

