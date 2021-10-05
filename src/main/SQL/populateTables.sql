INSERT INTO "User" (email,first_name,last_name,password,is_staff)
VALUES
('abc@abc.com','Jeff','Brown','password123',TRUE),
('test@abc.com','Lauren','Brown','password123',FALSE),
('james@abc.com', 'Steve','Brown','password123',FALSE);

INSERT INTO "Venue"(venue_name,venue_address,venue_lat,venue_lon)
VALUES
('Warringah Mall','Cnr Old Pittwater Road and Condamine Street,Brookvale NSW 2100',-33.754350,151.266890),
('Bondi Junction','500 Oxford St, Bondi Junction NSW 2022',-33.8923427,151.2508617),
('Parramatta Westfield','159-175 Church St, Parramatta NSW 2150',-33.817805,151.0020877);

INSERT INTO "Offender"(first_name,last_name,gender,email,phone,is_banned)
VALUES
('Josh','Green','Male','off@ender.com','0412345678',TRUE),
('Emily','Green', 'Female','not@ender.com','0412245678',FALSE),
('Zoe','Green','Female','test@ender.com','0412098765',TRUE);

INSERT INTO "Incident"(venue_id,type,incident_date,incident_time,description,reporter_id,offender_id,assigned_user, ticket_created_time,status,priority)
VALUES
(1,'Fall','2021-08-16','10:15:30', 'Elderly lady shoved in back', 1,1,1,CURRENT_TIMESTAMP,'resolved',1),
(2,'Shoplift','2021-08-16','10:15:30', 'Stole a fridge',   2,2,2,CURRENT_TIMESTAMP,'in progress',5),
(3,'Robbery','2021-08-16','10:15:30', 'Stole money',   3,3,2,CURRENT_TIMESTAMP, 'created', 3);

INSERT INTO "Warning"(venue_id,description,offender_id)
VALUES
(1,'Stop stealing',1),
(2,'Stop smoking', 1),
(3,'Avoid leaving your tools lying around', 3);