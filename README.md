This is my maven project where I'm practicing the concepts of JDBC using PostgreSQL. I'll be adding my progessions based on the date of creation.

+ 14th July 2026 - Created database `student` along with table `student` within it. It consists of columns `sid` (Primary key), `name`, `email` and `phone`.
Created files to add, fetch, update and delete records.  

+ 16th July 2026 - Replaced column names with column indices to fetch data using `ResultSet` getters.

+ 17th July 2026 - Created another package `statements` having three types of statement programs.   
Made a procedure `proc_save(s_id, s_name, s_email, s_phone)` in PostgreSQL (pgAdmin 4).

+ 18th July 2026 - Created another package `queries` having three types of query programs.  
Made changes to how the connection is closed and handled during exception by adding the steps from connection onwards to another try with resource block.