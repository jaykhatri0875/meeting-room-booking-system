/*INSERT INTO MEETING ROOM*/
insert into meeting_room(uid,capacity,rating,perhour_cost) values('','','','');
/*INSERT INTO AMMENITIES*/
insert into amenities(uid,amenities) values('','');

/* INSERT INTO USERS*/
insert into users(uid,Membername,email,phone) values('','','','');
/*INSERT INTO USER ROLES*/
insert into user_roles(uid,role_member,credit) values('','','');

/*INSERT INTO BOOKING INFO*/
insert into booking_info(uid,room_no,dateOfBooking,start_time,end_time,booked_by) values('','','','','','');

/*INSERT INTO MEETING*/
insert	into meeting(uid,title,booking_info,typeOfMeeting) values ('','','','');
/*INSERT INTO LIST OF PEOPLE*/
insert into list_of_people(uid,userid) values('','');


/*SELECT QUERIES*/
select * from meeting_room;
select * from users;
select * from booking_info;
select * from meeting;

/*SELECT USING UID*/
select * from meeting_room where uid=?;
select * from users where uid=?;
select * from booking_info where uid=?;
select * from meetings where uid=?;

/*full info of tables*/
select meeting_room.*, amenities.amenities from meeting_room left join amenities on meeting_room.uid = amenities.uid;
select 	users.*,user_role.role_member,user_role.credit from users left join user_role on users.uid = user_role.uid;
select meeting.uid,meeting.title,booking_info.room_no,booking_info.dateOfBooking,booking_info.start_time,booking_info.end_time,booking_info.booked_by,list_of_people.user_uid,meeting.typeOfMeeting 
from meeting 
left join booking_info on meeting.booking_info = booking_info.uid 
left join list_of_people on meeting.uid = list_of_people.uid;

/*fetch by id*/
select meeting_room.*, amenities.amenities from meeting_room left join amenities on meeting_room.uid = amenities.uid where meeting_room.uid=?;
select 	users.*,user_role.role_member,user_role.credit from users left join user_role on users.uid = user_role.uid where users.uid=?;
select meeting.uid,meeting.title,booking_info.room_no,booking_info.dateOfBooking,booking_info.start_time,booking_info.end_time,booking_info.booked_by,list_of_people.user_uid,meeting.typeOfMeeting 
from meeting 
left join booking_info on meeting.booking_info = booking_info.uid 
left join list_of_people on meeting.uid = list_of_people.uid
where meeting.uid=?;
