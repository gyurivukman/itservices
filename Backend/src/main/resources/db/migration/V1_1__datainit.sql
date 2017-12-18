INSERT INTO permissions(version, name) VALUES
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
	
INSERT INTO roles(version, name) VALUES
	(0, 'GUEST'),
	(0, 'EMPLOYEE'),
	(0, 'OPERATOR'),
	(0, 'OPERATOR_MANAGER'),
	(0, 'ADMIN');
	
INSERT INTO service_types(version, service_type) VALUES
	(0, 'ACCESS_REQUEST'),
	(0, 'IT_REQUEST');
	
INSERT INTO users(version,email,password,username,role_id,forename,surname,employeeid) VALUES (0,"itservices_admin@sample-text.com","admin123","admin",5,"Dr.","Harambe","00000001");
INSERT INTO services(version,description,icon_file_name,name,average_responsetime,required_position,request_form,service_type_id) VALUES
	(0,"Request a key to one of our VPNs.","vpn","VPN key request",1800000,'Employee','[{"type":"inputfield","name":"username","placeholder":"Username"},{"type":"select","name":"server","placeholder":"VPN 1","options":["VPN 1","VPN 2"]}]', 1),
	(0,"Report a hardware or software related workstation fault.","computererror","Workstation repair",3600000,'Employee','[{"type":"inputfield","name":"pcname","placeholder":"PC Name"},{"type":"select","name":"errortype","placeholder":"Hardware related","options":["Hardware related","Software related"]},{"type":"textarea","name":"description","placeholder":"Description"}]', 2),
	(0,"Request access to one of our corporate database servers.","database","Database access",1800000,'Line-Manager','[{"type":"inputfield","name":"username","placeholder":"Desired username"},{"type":"inputfield","name":"password","placeholder":"Desired password"},{"type":"select","name":"server","placeholder":"db1.it.net","options":["db1.it.net 1","db2.it.net","db3.it.net"]}]', 1),
	(0,"Request a corporate OS image to be installed on the specified computer.","windows","Install corporate image",3600000,'Senior-Employee','[{"type":"inputfield","name":"pcname","placeholder":"PC Name"},{"type":"radiogroup","name":"os","radiobuttons":[{"label":"Windows 10","checked":true},{"label":"Windows 8.1","checked":false},{"label":"Windows 7","checked":false}]}]', 2);