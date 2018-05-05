insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (101,'Szesz Kft','1,23456781234567E+23','Kis Tamás','tamas@szesz.hu','30-123-4567',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (102,'Bor Kft','1,23456781234567E+23','Kovács Anita','Anita@bor.hu','30-123-4567',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (103,'Üditő Kft','1,23456789865321E+23','Prencs Csaba','Csaba@udito.hu','10-123-4567',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (104,'Hentes Kft','1,23456781234567E+23','Tamás Attila','','30-123-4567',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (105,'Zöldséges Kft','1234567812345670','Kovács Piros','rendeles@zgy.hu','',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (106,'Takarito Bt','','Kovács Janos','','30-123-4567',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (107,'Karbantartó Kft','1,2345678E+23','Szerelési Ferenc','','20-123-4567',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (108,'XY tulajdonos','','XY','','',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (109,'Rendezvény Kft','1,23456781234567E+23','Kis Judit','rendezveny@fds.hu','30-123-4567',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (110,'Németh Ferenc','','Németh Ferenc','nf@gmail.com','30-123-4566',FALSE);
insert into partners(partner_id,partner_name,partner_account,partner_contact_name,partner_contact_email,partner_contact_phone,partner_technical)
values  (111,'Napi forgalom','','','','',TRUE);

insert into cost_centers(cost_center_id,cost_center_name,cost_center_default)
values  (102,'iroda',FALSE);
insert into cost_centers(cost_center_id,cost_center_name,cost_center_default)
values  (103,'étterem',TRUE);
insert into cost_centers(cost_center_id,cost_center_name,cost_center_default)
values  (104,'bár',FALSE);
insert into cost_centers(cost_center_id,cost_center_name,cost_center_default)
values  (105,'konyha',FALSE);

insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (101,'áru',TRUE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (102,'bérköltség',TRUE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (103,'beruházás',FALSE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (104,'karbantartás',FALSE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (105,'eszköz',TRUE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (106,'irodaszer',FALSE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (107,'tulajdonosi kivét',FALSE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (108,'program',FALSE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (109,'szolgáltatás',FALSE);
insert into expense_types(exp_type_id,exp_type_name,exp_type_prod_related)
values  (110,'étkészlet',TRUE);

insert into income_types(inc_type_id,inc_type_name,inc_type_prod_related)
values  (101,'terembérlet',FALSE);
insert into income_types(inc_type_id,inc_type_name,inc_type_prod_related)
values  (102,'étel-ital',TRUE);
insert into income_types(inc_type_id,inc_type_name,inc_type_prod_related)
values  (103,'szolgáltatás',FALSE);
insert into income_types(inc_type_id,inc_type_name,inc_type_prod_related)
values  (104,'belépő',FALSE);
insert into income_types(inc_type_id,inc_type_name,inc_type_prod_related)
values  (105,'visszáru',TRUE);
insert into income_types(inc_type_id,inc_type_name,inc_type_prod_related)
values  (106,'tulajdonosi befizetés',FALSE);

insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values (101,'SZA07028/2016',1,105,1,111500,'gyümölcs','2018-05-05','2018-06-05','2018-06-05',null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (102,'SZA07027/2016',1,105,1,38665,'zöldség','2018-05-05','2018-06-05','2018-06-05',null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (104,'SZA07070/2016',1,105,1,15055,'zöldség','2018-05-07','2018-06-07',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (105,'SZA07071/2016',1,105,1,2540,'zöldség','2018-05-07','2018-06-07',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (106,'SZA07130/2016',1,105,1,26000,'zöldség','2018-05-08','2018-06-08',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (107,'SZA07131/2016',1,105,1,66500,'gyümölcs','2018-05-08','2018-06-08',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (108,'SZA07170/2016',1,105,1,96200,'gyümölcs','2018-05-09','2018-06-09',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (109,'SZA07176/2016',1,105,1,18525,'zöldség','2018-05-09','2018-06-09',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (110,'SZA07222/2016',1,105,1,60005,'gyümölcs','2018-05-10','2018-06-10',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (111,'SZA07206/2016',1,105,1,22500,'zöldség','2018-05-10','2018-06-10',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (112,'SZA07267/2016',1,105,1,27200,'gyümölcs','2018-05-11','2018-06-11',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (113,'SZA07266/2016',1,105,1,24000,'zöldség','2018-05-11','2018-06-11',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (114,'SZA07309/2016',1,105,1,41570,'zöldség','2018-05-12','2018-06-12',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (115,'SZA07317/2016',1,105,1,118900,'gyümölcs','2018-05-12','2018-06-12',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (116,'SZA07388/2016',1,105,1,2525,'zöldség','2018-05-14','2018-06-14',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (117,'SZA07364/2016',1,105,1,10500,'zöldség','2018-05-14','2018-06-14',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (118,'SZA07374/2016',1,105,1,50025,'gyümölcs','2018-05-14','2018-06-14',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (119,'SZA07219/2016',1,105,1,4155,'répa','2018-05-14','2018-06-14',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (120,'SZA07428/2016',1,105,1,48800,'gyümölcs','2018-05-15','2018-06-15',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (121,'SZA07427/2016',1,105,1,22700,'zöldség','2018-05-15','2018-06-15',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (122,'SZA07481/2016',1,105,1,66600,'gyümölcs','2018-05-16','2018-06-16',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (123,'SZA07480/2016',1,105,1,32600,'zöldség','2018-05-16','2018-06-16',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (124,'SZA07510/2016',1,105,1,21900,'zöldség','2018-05-17','2018-06-17',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (125,'SZA07518/2016',1,105,1,70500,'gyümölcs','2018-05-17','2018-06-17',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (126,'SZA07581/2016',1,105,1,85000,'gyümölcs','2018-05-18','2018-06-18',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (127,'SZA07580/2016',1,105,1,36500,'zöldség','2018-05-18','2018-06-18',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (128,'SZA07629/2016',1,105,1,70555,'zöldség','2018-05-19','2018-06-19',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (129,'SZA07632/2016',1,105,1,159180,'gyümölcs','2018-05-19','2018-06-19',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (130,'SZA07695/2016',1,105,1,63107,'gyümölcs','2018-05-21','2018-06-21',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (131,'SZA07693/2016',1,105,1,19415,'zöldség','2018-05-21','2018-06-21',null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (132,'200-08433/2016',1,103,0,38500,'szénsavas üditő','2018-05-07',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (133,'200-08632/2016',1,103,0,45000,'cola','2018-05-11',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (134,'200-08751/2016',1,103,0,22000,'szénsavas üditő','2018-05-15',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (135,'200-08909/2016',1,103,0,44000,'cola','2018-05-18',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (136,'200-09217/2016',1,103,0,21000,'szénsavas üditő','2018-05-29',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (137,'200-09474/2016',1,103,0,22000,'cola','2018-06-05',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (138,'1207/2016',1,106,0,38500,'tisztítószer','2018-05-09',null,null,null,null,102,105);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (139,'1208/2016',1,106,0,45000,'tisztítószer','2018-05-09',null,null,null,null,102,105);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (140,'1253/2016',1,106,0,22000,'tisztítószer','2018-05-14',null,null,null,null,102,105);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (141,'1319/2016',1,106,0,44000,'tisztítószer','2018-05-22',null,null,null,null,102,105);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (142,'1360/2016',1,106,0,21000,'tisztítószer','2018-05-28',null,null,null,null,102,105);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (143,'1390/2016',1,106,0,22000,'tisztítószer','2018-06-01',null,null,null,null,102,105);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (144,'KP15-02282',1,101,0,193000,'ital','2018-05-08',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (145,'KP15-02341',1,101,0,76200,'ital','2018-05-11',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (146,'KP15-02374',1,101,0,90700,'ital','2018-05-15',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (147,'KP15-02419',1,101,0,120000,'ital','2018-05-18',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (148,'KP15-02474',1,101,0,129500,'ital','2018-05-23',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (149,'KP15-02509',1,101,0,91500,'ital','2018-05-25',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (150,'KP15-02523',1,101,0,131000,'ital','2018-05-29',null,null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (151,'IH4EA0744727',1,106,0,250190,'takarítás 06','2018-05-06','2018-06-06','2018-06-02','2018-06-01','2018-06-01',102,109);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (152,'IH4EA0744733',1,106,0,301625,'takarítás 07','2018-05-30','2018-06-30','2018-06-06','2018-07-01','2018-07-01',102,109);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (153,'SZA02222/2016',1,104,0,224800,'hús','2018-05-15',null,null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (154,'SZA02346/2016',1,104,0,216500,'hús','2018-05-29',null,null,null,null,104,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (155,'802133534',1,107,0,1500000,'felújítás','2018-05-29',null,null,'2018-08-01','2018-06-30',102,103);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (156,'CE064725',0,108,0,1500000,'tul kivét','2018-05-14',null,null,null,null,102,107);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (157,'CE064811',0,108,0,1500000,'tul kivét','2018-06-01',null,null,null,null,102,107);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (158,'201530080',1,102,1,290152,'bor','2018-05-25','2018-06-03',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (159,'201527505',1,102,1,140331,'bor','2018-09-04','2018-05-12',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (160,'201530558',1,102,1,23406,'bor','2018-05-29','2018-10-07',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (161,'201530562',1,102,1,112807,'bor','2018-05-30','2018-10-08',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (162,'201526177',1,102,1,317666,'bor','2018-08-24','2018-09-02',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (163,'201526577',1,102,1,67177,'bor','2018-08-27','2018-09-04',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (164,'201526700',1,102,1,367322,'bor','2018-08-28','2018-05-05',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (165,'201526755',1,102,1,119354,'bor','2018-08-28','2018-05-05',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (166,'201526927',1,102,1,43239,'bor','2018-08-31','2018-05-08',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (167,'201527064',1,102,1,123367,'bor','2018-09-01','2018-05-09',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (168,'201530857',1,102,1,173171,'bor','2018-06-02','2018-10-10',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (169,'201527281',1,102,1,132398,'bor','2018-09-02','2018-05-10',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (170,'201527814',1,102,1,128581,'bor','2018-05-07','2018-05-15',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (171,'201527951',1,102,1,353349,'bor','2018-05-08','2018-05-16',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (172,'201528360',1,102,1,361928,'bor','2018-05-11','2018-05-19',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (173,'201528613',1,102,1,128340,'bor','2018-05-12','2018-05-20',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (174,'201528745',1,102,1,507145,'bor','2018-05-14','2018-05-23',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (175,'201531166',1,102,1,138569,'bor','2018-06-05','2018-10-13',null,null,null,103,101);
insert into expenses(expense_id,expense_doc_id,expense_doc_type,expense_issuer,expense_payment_method,expense_gross_amount,expense_description,expense_recieved_date,expense_expiry_date,expense_payed_date,expense_acc_per_start,expense_acc_per_end,expense_costcenter,expense_type)
values  (176,'201529325',1,102,1,775012,'bor','2018-05-18','2018-05-26',null,null,null,103,101);
