select * from citizens;
insert into citizens(id,citizen_name,has_voted) values(1,'bob',false);
insert into citizens(id,citizen_name,has_voted) values(2,'xyz',false);

select * from candidate;
insert into candidate(id,candidate_name,number_of_votes) values(1,'obama',0);
insert into candidate(id,candidate_name,number_of_votes) values(2,'trump',0);