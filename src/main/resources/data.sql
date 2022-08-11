drop table trade_store;

create table trade_store(
	trade_id text,
	version int,
	counter_party_id text,
	book_id text,
	maturity_date date,
	created_date date,
	expired boolean
);

INSERT INTO trade_store (trade_id,version,counter_party_id,book_id,maturity_date,created_date,expired) VALUES ('T1',1,'CP-1','B1',current_date + 2, current_date ,0);
INSERT INTO trade_store (trade_id,version,counter_party_id,book_id,maturity_date,created_date,expired)  VALUES ('T2',2,'CP-2','B1',current_date + 200, current_date ,0);
INSERT INTO trade_store (trade_id,version,counter_party_id,book_id,maturity_date,created_date,expired)  VALUES ('T2',1,'CP-1','B1',current_date + 200, current_date ,0);
INSERT INTO trade_store (trade_id,version,counter_party_id,book_id,maturity_date,created_date,expired)  VALUES ('T3',3,'CP-3','B2',current_date - 1000, current_date ,1);
INSERT INTO trade_store (trade_id,version,counter_party_id,book_id,maturity_date,created_date,expired)  VALUES ('T3',4,'CP-4','B2',current_date + 100, current_date ,0);