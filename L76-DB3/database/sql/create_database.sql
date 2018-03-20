CREATE TABLE player (
	id int NOT NULL,
	weight dec,
	height float8,
	name varchar(40) NOT NULL,
	surname char(40),
	reg_date timestamp NOT NULL,
	reg_date2 timestamp with time zone NOT NULL
);

INSERT INTO player (id, name, reg_date, reg_date)
VALUES (1, 'Yojimbo', '1961-06-16', '1961-06-16');

/*INSERT INTO player
VALUES ... все значения);*/ 

UPDATE player SET reg_date='1961-06-16' 
WHERE name='Yojimbo';

UPDATE player SET name='new Yojimbo' 
WHERE name='Yojimbo';

DELETE player WHERE id=2;

INSERT INTO player (id, name, reg_date, reg_date2)
VALUES (2, 'Yojimbo', CURRENT_DATE, CURRENT_TIMESTAMP(2));

select count(*) from player where name like 'Yo%'

select * from player ORDER BY reg_date2
select 2+2
select random()
select random() from player
--SELECT a, b + c FROM table1;

[WITH ...] SELECT 
[DISTINCT [ON (expression [, ...] )] ] 
select_list FROM table_name 
[WHERE expression [, ...]] 
[GROUP BY ... 
[HAVING boolean_expression] ]

SELECT * FROM (
	SELECT * FROM ( 
		SELECT * FROM ... WHERE ...) 
	WHERE ... )
WHERE ...






