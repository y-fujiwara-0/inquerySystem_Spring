    SELECT * FROM users
    WHERE 1 = 1
    /*%if username != null*/
        AND username LIKE CONCAT('%', /*username*/'username', '%')
        /*%end*/
        /*%if authority != null*/
        AND authority LIKE CONCAT('%', /*authority*/'0', '%')
       /*%end*/
