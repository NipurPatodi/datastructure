with stage1 as {
select name , dense_rank() over (order by revenue) as rnk from region where
 sale_date >= DATE_SUB(NOW(),INTERVAL 28 day)
}
select name from stage1 where rnk =5