create
    definer = root@localhost procedure bill_by_date(IN from_date date, IN to_date date)
BEGIN
    select a.id                             as id,
       extract(month from a.created_at) as month,
       extract(year from a.created_at)  as year,
       count(*)                         as quantity
from bill a
where extract(year_month from a.created_at) >= extract(year_month from from_date)
  and extract(year_month from a.created_at) <= extract(year_month from to_date)
group by extract(month from a.created_at)
order by month;
END;

