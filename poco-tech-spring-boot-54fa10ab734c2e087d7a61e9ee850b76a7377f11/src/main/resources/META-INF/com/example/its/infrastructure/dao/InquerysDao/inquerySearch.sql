SELECT /*%expand*/* FROM inquerys
            WHERE 1=1
            /*%if @isNotEmpty(keyword) */
             AND (mail_address LIKE CONCAT('%', /* @infix(keyword) */'keyword','%')
             OR name LIKE CONCAT('%', /* @infix(keyword) */'keyword', '%')
             OR content LIKE CONCAT('%', /* @infix(keyword) */'keyword', '%'))
            /*%end */
            /*%if dateFrom != null */
             AND registration_At >= /* dateFrom */'dateFrom'
            /*%end */
            /*%if dateTo != null */
             AND registration_At <= /* dateTo */'dateTo'
            /*%end */
             ORDER BY inquery_id DESC
