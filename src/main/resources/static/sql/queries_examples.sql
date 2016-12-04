INSERT INTO statistic (info)VALUES ('{"info":{"createdate":"2016-12-03"}}');
INSERT INTO statistic (info)VALUES ('{"info":{"createdate":"2016-12-02"}}');
INSERT INTO statistic (info)VALUES ('{"info":{"createdate":"2016-12-02","product":"adidaas"}}');
INSERT INTO statistic (info)VALUES ('{"info":{"createdate":"2016-12-02","product":"adidas","size":"39"}}');
INSERT INTO statistic (info)VALUES ('{"info":{"createdate":"2016-12-02","product":"adidas","size":"40"}}');
SELECT info->'info' FROM statistic;
SELECT info->'info'->>'createdate'AS createdate FROM statistic;
SELECT info->'info'->>'createdate'AS createdate FROM statistic ORDER BY createdate;
-- where example
SELECT info->'info'->> 'createdate'as createdate FROM statistic WHERE info->'info'->>'createdate'='2016-12-02'
SELECT info->'info'as info FROM statistic WHERE info->'info'->>'createdate'='2016-12-02';
SELECT info->'info'as info FROM statistic WHERE cast(info->'product'AS VARCHAR)='addidaas'
SELECT
  info->'info'->>'product' AS product,
  info->'info'->>'size' AS size
FROM statistic
WHERE cast(info->'info'->>'product'AS VARCHAR)='adidas';