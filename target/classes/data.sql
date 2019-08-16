merge into priority (id, name) values
(1,'medium'),
(2,'low'),
(3,'high');

merge into status (id, name) values
(1,'to-do'),
(2,'done');

merge into groups (id, name) values
(1,'office'),
(2,'home'),
(3,'hobbies');

merge into item (id, name, status_id, group_id, priority_id) values
(1,'food',1,2,3);

merge into tag (id, item_id, name) values
(1,1,'food'),
(2,1,'health');
