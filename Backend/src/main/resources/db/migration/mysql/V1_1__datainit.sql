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
INSERT INTO services(version,description,icon_file_name,name) VALUES
	(0,"Description 1","placeholder1.svg","Test service 1"),
	(0,"Description 2","placeholder2.svg","Test service 2"),
	(0,"Description 3","placeholder3.svg","Test service 3"),
	(0,"Description 4","placeholder4.svg","Test service 4");