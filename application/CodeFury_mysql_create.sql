CREATE TABLE `meeting_room` (
	`uid` varchar(20) NOT NULL,
	`capacity` INT NOT NULL,
	`rating` INT NOT NULL,
	`perhour_cost` INT NOT NULL,
	PRIMARY KEY (`uid`)
);

CREATE TABLE `amenities` (
	`uid` varchar(20) NOT NULL,
	`amenities` varchar(20) NOT NULL
);

CREATE TABLE `users` (
	`uid` varchar(20) NOT NULL,
	`Membername` varchar(20) NOT NULL,
	`email` varchar(20) NOT NULL,
	`phone` varchar(20) NOT NULL,
	PRIMARY KEY (`uid`)
);

CREATE TABLE `user_role` (
	`uid` varchar(20) NOT NULL,
	`role_member` varchar(20) NOT NULL,
	`credit` INT NOT NULL
);

CREATE TABLE `booking_info` (
	`uid` varchar(20) NOT NULL,
	`room_no` varchar(20) NOT NULL,
	`dateOfBooking` DATE NOT NULL,
	`start_time` DATETIME NOT NULL,
	`end_time` DATETIME NOT NULL,
	`booked_by` varchar(20) NOT NULL,
	PRIMARY KEY (`uid`)
);

CREATE TABLE `meeting` (
	`uid` varchar(20) NOT NULL,
	`title` varchar(20) NOT NULL,
	`booking_info` varchar(20) NOT NULL,
	`typeOfMeeting` varchar(20) NOT NULL,
	PRIMARY KEY (`uid`)
);

CREATE TABLE `list_of_people` (
	`uid` varchar(20) NOT NULL,
	`user_uid` varchar(20) NOT NULL
);

ALTER TABLE `amenities` ADD CONSTRAINT `amenities_fk0` FOREIGN KEY (`uid`) REFERENCES `meeting_room`(`uid`);

ALTER TABLE `user_role` ADD CONSTRAINT `user_role_fk0` FOREIGN KEY (`uid`) REFERENCES `users`(`uid`);

ALTER TABLE `booking_info` ADD CONSTRAINT `booking_info_fk0` FOREIGN KEY (`room_no`) REFERENCES `meeting_room`(`uid`);

ALTER TABLE `booking_info` ADD CONSTRAINT `booking_info_fk1` FOREIGN KEY (`booked_by`) REFERENCES `users`(`uid`);

ALTER TABLE `meeting` ADD CONSTRAINT `meeting_fk0` FOREIGN KEY (`booking_info`) REFERENCES `booking_info`(`uid`);

ALTER TABLE `list_of_people` ADD CONSTRAINT `list_of_people_fk0` FOREIGN KEY (`uid`) REFERENCES `meeting`(`uid`);

ALTER TABLE `list_of_people` ADD CONSTRAINT `list_of_people_fk1` FOREIGN KEY (`user_uid`) REFERENCES `users`(`uid`);