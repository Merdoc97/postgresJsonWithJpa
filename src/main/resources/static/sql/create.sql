CREATE TABLE statistic(
dtype character varying(31) NOT NULL,
  id SERIAL NOT NULL PRIMARY KEY ,
  info JSON NOT NULL
);
-- unique indexes for two json types
CREATE UNIQUE INDEX ui_productstatistic ON statistic((info->>'productName'));
CREATE UNIQUE INDEX ui_userstatistic ON statistic((info->>'userEmail'));