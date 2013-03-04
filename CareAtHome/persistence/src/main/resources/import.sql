insert into Actor(UUID, LOGIN, PASSWORD, JOB, SECTOR, REFERANT) values (100, cad, cad, 'CADRE', '1', 200);
insert into Actor(UUID, LOGIN, PASSWORD, JOB, SECTOR, REFERANT) values (110, pat1, pat1, 'PATIENT', '1', 300);
insert into Actor(UUID, LOGIN, PASSWORD, JOB, SECTOR, REFERANT) values (110, pat2, pat2, 'PATIENT', '1', 301);
insert into Actor(UUID, LOGIN, PASSWORD, JOB, SECTOR, REFERANT) values (110, pat3, pat3, 'PATIENT', '1', 302);
insert into Actor(UUID, LOGIN, PASSWORD, JOB, SECTOR, REFERANT) values (120, per, per, 'PERSONNEL', '1', 400);
insert into Actor(UUID, LOGIN, PASSWORD, JOB, SECTOR, REFERANT) values (130, res, res, 'RESPONSABLE', '1', 500);


insert into Medecin(UUID, FIRSTNAME, LASTNAME, BIRTHDAY, SSID, PHONE, ADRESS) values (600, med, med, '02/02/1965', '1', "0606060606", '54 Boulevard Med, 88888 Kikoo');
insert into Laboratory(UUID, NAME, PHONE, ADRESS) values (700, 'lab', "0303030303", '12 rue Medoc, 77777 Mdr');
insert into Pharmacie(UUID, NAME, PHONE, ADRESS) values (800, 'pha', "0404040404", '36 rue Pharma, 88888 Xpdr');



insert into Cadre(UUID, FIRSTNAME, LASTNAME, BIRTHDAY, SSID, PHONE, REFERANT) values (200, cad, cad, '10/12/1970', '1', "0606060606", 0);

insert into Patient(UUID, FIRSTNAME, LASTNAME, BIRTHDAY, SSID, ADDRESS, PHONE, PRIORITY, UUID_MEDECIN, UUID_LABORATORY, UUID_PHARMACIE) values (300, pat1, pat1, '17/02/1975', '2', '2 rue des Oufs, 60333 Lol', "0606060606", "2PM", 600, 700, 800);
insert into Patient(UUID, FIRSTNAME, LASTNAME, BIRTHDAY, SSID, ADDRESS, PHONE, PRIORITY, UUID_MEDECIN, UUID_LABORATORY, UUID_PHARMACIE) values (301, pat2, pat2, '19/05/1990', '3', '22 rue des Flans, 60444 Fu', "0606060606", "1PM", 600, 700, 800);
insert into Patient(UUID, FIRSTNAME, LASTNAME, BIRTHDAY, SSID, ADDRESS, PHONE, PRIORITY, UUID_MEDECIN, UUID_LABORATORY, UUID_PHARMACIE) values (302, pat3, pat3, '01/01/1995', '4', '131 rue des Nems, 6055 Fu', "0606060606", "1AM", 600, 700, 800);


insert into Personnel(UUID, FIRSTNAME, LASTNAME, BIRTHDAY, SSID, PHONE, REFERANT) values (400, per, per, '02/01/1982', '1', "0606060606", 0);
insert into Responsable(UUID, FIRSTNAME, LASTNAME, BIRTHDAY, SSID, PHONE, REFERANT) values (500, res, res, '26/10/1961', '1', "0606060606", 0);


insert into RDV(UUID, UUID_PERSONNEL, UUID_PATIENT, PRIORITY, DATE) values (900, 400, 300, '2PM', '05/03/2013');


