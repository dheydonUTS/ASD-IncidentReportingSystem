
INSERT INTO "User" (
    email,
    first_name,
    last_name,
    password,
    is_staff
)
VALUES
    ('abc@abc.com',
    'Jeff',
    'Brown',
    'password123',
    TRUE),
('test@abc.com',
    'Lauren',
    'Brown',
    'password123',
    FALSE),
('james@abc.com',
    'Steve',
    'Brown',
    'password123',
    FALSE);

INSERT INTO "Venue"(
    venue_name,
    venue_address,
    venue_lat,
    venue_lon)
VALUES
('Warringah Mall',
'Cnr Old Pittwater Road and Condamine Street,
Brookvale NSW 2100',
-33.754350,
151.266890
),
('Bondi Junction',
'500 Oxford St, Bondi Junction NSW 2022',
-33.8923427,
151.2508617),
('Parramatta Westfield',
'159-175 Church St, Parramatta NSW 2150',
-33.817805,
151.0020877);

INSERT INTO "Offender"(
first_name,
last_name,
email,
phone,
is_banned)
VALUES(
'Josh',
'Green',
'off@ender.com',
0412345678,
TRUE),
(
'Emily',
'Green',
'not@ender.com',
0412245678,
FALSE),
(
'Zoe',
'Green',
'test@ender.com',
0412098765,
TRUE);

/* NOTE: MISSING INCIDENT ID, CLOSED TIME FIELDS */
INSERT INTO "Ticket"(
assigned_user,
created_time,
status,
priority)
VALUES
(1,CURRENT_TIMESTAMP,'resolved',1),
(2,CURRENT_TIMESTAMP,'in progress',5),
(2,CURRENT_TIMESTAMP, 'created', 3);

INSERT INTO "Incident"(
venue_id,
type,
description,
date,
time,
reporter,
offender_id,
ticket_id)
VALUES
(1,'Fall', 'Elderly lady shoved in back', CURRENT_DATE, CURRENT_TIME, 'Jeff',1,1),
(2,'Shoplift', 'Stole a fridge', CURRENT_DATE, CURRENT_TIME, 'Naomi',2,2),
(3,'Robbery', 'Stole money', CURRENT_DATE, CURRENT_TIME, 'Ben',2,3);

INSERT INTO "Message"(
content,
incident_id,
offender_id
)
VALUES
('Dont do that',1,2),
('Stop stealing',2,2),
('Thats not nice',3,2);

