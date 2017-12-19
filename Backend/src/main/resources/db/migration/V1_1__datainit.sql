INSERT INTO permissions (version, name) VALUES
	(0, 'REQUEST_SERVICE'),
	(0, 'VIEW_SERVICE'),
	(0, 'APPROVE_REQUEST'),
	(0, 'DECLINE_REQUEST'),
	(0, 'CLOSE_REQUEST'),
	(0, 'REOPEN_REQUEST'),
	(0, 'CHANGE_PRIORITY'),
	(0, 'ASSIGN_REQUEST'),
	(0, 'COMMENT_ON_REQUEST'),
	(0, 'INVOLVE_SOMEONE_ELSE'),
	(0, 'CREATE_SERVICE'),
	(0, 'EDIT_SERVICE'),
	(0, 'ARCHIVE_SERVCE'),
	(0, 'EDIT_PERMISSIONS'),
	(0, 'EDIT_USER_CREDENTIALS');
	
INSERT INTO roles (version, name) VALUES
	(0, 'GUEST'),
	(0, 'EMPLOYEE'),
	(0, 'OPERATOR'),
	(0, 'OPERATOR_MANAGER'),
	(0, 'ADMIN');
	
INSERT INTO users(version,email,password,username,role_id,forename,surname,employeeid) VALUES (0,"itservices_admin@sample-text.com","admin123","admin",5,"Dr.","Harambe","00000001");
INSERT INTO service_types(version,service_type) VALUES (0,"ACCESS_REQUEST"),(0,"TRAINING_REQUEST"),(0,"BUG_REPORT"),(0,"HARDWARE_REQUEST"),(0,"SOFTWARE_REQUEST"),(0,"MISC_REQUEST");
INSERT INTO services(version,description,icon_file_name,name,average_responsetime,required_position,service_type_id,request_form) VALUES
	(0,"Description 1","warning","Test service 1",3600000,'Employee',1,NULL),
	(0,"Description 2","logout","Test service 2",3600000,'Employee',4,NULL),
	(0,"Description 3","warning","Test service 3",3600000,'Line-Manager',2,'[{"type":"input","name":"inputtext","label":"inputlábel","placeholder":"Whatsthis"},{"type":"select","name":"szelekt","label":"szelektlábel","placeholder":"Szelektáljá valamit","options":["egy","ketto","harom"]},{"type":"checkbox","name":"csekkboksz","label":"csekkbokszlábel"},{"type":"radiogroup","name":"radios","label":"radioslabel","radiobuttons":[{"label":"label1","checked":"true"},{"label":"label2"}]},{"type":"textarea","name":"textarea","label":"texrarealábel","placeholder":"pláceholdér"}]'),
	(0,"Description 4","logout","Test service 4",3600000,'Senior-Employee',5,NULL);
