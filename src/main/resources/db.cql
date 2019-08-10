CREATE TYPE type_user (
uuid text,
name text,
email text,
age int,
status text
);

CREATE TABLE user (
aggregateid text,
timestamp timestamp,
entity frozen<type_user>,
eventedpersona text,
id text,
traceid text,
type text,
updateby text,
PRIMARY KEY (aggregateid, timestamp)
) WITH CLUSTERING ORDER BY (timestamp DESC);

CREATE TYPE type_uploadDocument (
uuid text ,
documentNm text,
issuerId text,
location text,
mimeType text,
beneficiarIds List<text>
);

CREATE TABLE upload (
aggregateid text,
timestamp timestamp,
entity frozen<type_uploadDocument>,
eventedpersona text,
id text,
traceid text,
type text,
updateby text,
PRIMARY KEY (aggregateid, timestamp)
) WITH CLUSTERING ORDER BY (timestamp DESC);