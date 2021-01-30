drop view if exists HIS_DeTaiNCKH;

create or replace view HIS_DeTaiNCKH as
select distinct(tp.id)                                                  as iddetai,
               cast(tp.name as varchar(10000) )                                                 as tendetai,
               cast(u.name as varchar(10000))                                                   as donvith,
               cast(f.name as varchar(10000))                                                   as linhvuc,
               cast(sub2.name as varchar(10000))                                                as nguoith_chinh,
               cast(sub1.name as varchar(255))                          as nguoith_cung,
               cast(to_char(tp.created_at, 'yyyyMMdd') as INTEGER)      as tgbatdauth,
               cast(to_char(tp.acceptance_date, 'yyyyMMdd') as INTEGER) as tgketthuc,
               cast(tp.status as varchar(255))                          as ketqua,
               cast(tp.updated_at as timestamp)                                         as updated

from topic tp
         left join unit u on tp.coordination_unit_clone_id = u.id
         left join faculty f on tp.faculty_id = f.id
         left join users_topics ut on tp.id = ut.topic_id
         left join user_account uac on ut.user_id = uac.id
         left join location l on ut.location_id = l.id
--         left join acceptance a on tp.id = a.topic_id
         left  join (select string_agg(uac.name, ';') as name, ut.topic_id
                    from users_topics ut
                             left join location l on ut.location_id = l.id
                             left join user_account uac on ut.user_id = uac.id
                    where l.name = 'Nghiên cứu viên' and l.deleted = 0 and uac.deleted = 0
                    group by ut.topic_id
) sub1 on tp.id = sub1.topic_id
         left  join  (select  distinct (uac.name), ut.topic_id as topic_id
                    from users_topics ut
                             left join location l on ut.location_id = l.id
                             left join user_account uac on ut.user_id = uac.id
                    where l.name = 'Quản lý nhóm' and l.deleted = 0 and uac.deleted = 0
) sub2 on tp.id = sub2.topic_id where uac.deleted = 0 and tp.deleted = 0;