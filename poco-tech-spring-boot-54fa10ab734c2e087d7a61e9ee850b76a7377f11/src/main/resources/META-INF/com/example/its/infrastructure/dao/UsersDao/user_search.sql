<select id="selectUsers" resultType="User">
    SELECT * FROM users
    WHERE 1=1
    <if test="username != null and !username.isEmpty()">
        AND username LIKE CONCAT('%', /* username */'username', '%')
    </if>
    <if test="authority != null">
        AND authority = /* authority */'1'
    </if>
</select>
