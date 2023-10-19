alter table consultas add column motivo_cancelamento varchar(100);
update consultas set motivo_cancelamento = null;
