package com.codehard.miscursos.sesion;

import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.jdbc.core.RowMapper;
 
public class AppUserMapper implements RowMapper<AppUser> {
 
    public static final String BASE_SQL = "select COALESCE( (SELECT idadmin  from administrador where correo = ? ), COALESCE( (SELECT idprofesor  from profesor where correo = ? ), COALESCE( (SELECT idalumno  from alumno where correo = ? ), (null) ) ) ) as id, COALESCE( (SELECT correo  from administrador where correo=?), COALESCE( (SELECT correo  from profesor where correo=?), COALESCE( (SELECT correo  from alumno where correo=?), (null) ) ) ) as email, COALESCE( (SELECT password  from administrador where correo=?), COALESCE( (SELECT password  from profesor where correo=?), COALESCE( (SELECT password  from alumno where correo=?), (null) ) ) ) as password, COALESCE( (SELECT 'administrador'  from administrador where correo = ? ), COALESCE( (SELECT 'profesor'  from profesor where correo = ? ), COALESCE( (SELECT 'alumno'  from alumno where correo = ? ), (null) ) ) ) as tabla from roles GROUP BY email";
 
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long userId = rs.getLong("id");
        String userName = rs.getString("email");
        String encrytedPassword = rs.getString("password");
        String tabla = rs.getString("tabla");
 
        return new AppUser(userId, userName, encrytedPassword, tabla);
    }
 
}