/**
 * Author:  joe
 * Created: 23/09/2021
 */

CREATE TABLE "User" (
	user_id INT  NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	email VARCHAR(50),
	first_name VARCHAR(50),
        last_name VARCHAR(50),
	password VARCHAR(15),
	is_staff BOOLEAN,
	PRIMARY KEY (user_id)
);

CREATE TABLE "Venue" (
	venue_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	venue_name VARCHAR(50) NOT NULL,
	venue_address VARCHAR(1000),
	venue_lat DECIMAL(8,6),
	venue_lon DECIMAL(9,6),
	PRIMARY KEY (venue_id)
);

CREATE TABLE "Offender" (
	offender_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),	
	first_name VARCHAR(50),
	last_name VARCHAR(50),
        gender VARCHAR(50),
        email VARCHAR(50),
        phone VARCHAR(50),
	is_banned BOOLEAN,
	PRIMARY KEY (offender_id)
);

CREATE TABLE "Ticket" (
ticket_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	assigned_user INT,
	incident_id INT,
	created_time TIMESTAMP NOT NULL,
	closed_time TIMESTAMP,
	status VARCHAR(20),
	priority INT,
	PRIMARY KEY (ticket_id),
	FOREIGN KEY (assigned_user) REFERENCES "User"(user_id)
);

CREATE TABLE "Incident" (
	incident_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	venue_id INT NOT NULL,
	type VARCHAR(100),
	description VARCHAR(1000),
	date DATE,
	time TIME,
	reporter VARCHAR(50),
	offender_id INT,
	ticket_id INT,
	PRIMARY KEY (incident_id),
	FOREIGN KEY (venue_id) REFERENCES "Venue"(venue_id),
	FOREIGN KEY (offender_id) REFERENCES "Offender" (offender_id),
	FOREIGN KEY (ticket_id) REFERENCES "Ticket" (ticket_id)
);

CREATE TABLE "Message" (
	message_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	content VARCHAR(255),
	incident_id INT,
	offender_id INT,
	PRIMARY KEY (message_id),
	FOREIGN KEY (incident_id) REFERENCES "Incident" (incident_id),
	FOREIGN KEY (offender_id) REFERENCES "Offender" (offender_id)
);

