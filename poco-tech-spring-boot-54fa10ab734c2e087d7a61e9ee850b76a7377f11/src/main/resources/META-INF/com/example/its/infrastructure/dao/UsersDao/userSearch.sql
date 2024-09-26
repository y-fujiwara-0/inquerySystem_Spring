SELECT /*%expand*/* FROM users WHERE
/*%if @isNotEmpty(username) */
    AND username LIKE /* @infix(username) */'%username%' escape '$'
/*%end */
/*%if @isNotEmpty(authority) */
    AND authority = /* authority */'1'
/*%end */