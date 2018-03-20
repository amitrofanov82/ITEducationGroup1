-- ============= FIRST WAY
CREATE SEQUENCE user_id_seq;
CREATE TABLE user (
    user_id smallint 
    	NOT NULL DEFAULT nextval('user_id_seq'),
    PRIMARY KEY (user_id)
);
ALTER SEQUENCE user_id_seq OWNED BY user.user_id;

-- ============= 2ND WAY
CREATE TABLE user2 (
    user_id SERIAL PRIMARY KEY;
);


-- ============= 3RD WAY
CREATE SEQUENCE user_id_seq;
ALTER TABLE user ALTER user_id 
   SET DEFAULT NEXTVAL('user_id_seq');
-----

--DCL: 
CREATE USER vasya;
GRANT vasya access to eCommerceDB;

--TCL:
--транзакции. Тема важная, но 
--для джуниорства вам не надо

-- https://onlinetestpad.com/t/d4949cd392504917ba9431d29a231cae
















