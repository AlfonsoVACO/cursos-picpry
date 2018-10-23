package com.codehard.miscursos.sesion;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class AppRoleDAO extends JdbcDaoSupport {
 
    @Autowired
    public AppRoleDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    public List<String> getRoleNames(Long userId, String table) {
    	String id = "";
    	switch(table) {
	    	case "administrador": id = "idadmin"; break;
	    	case "profesor": id = "idprofesor"; break;
	    	case "alumno": id = "idalumno"; break;
	    	default: id = "idalumno"; break;
    	}
        String sql = "select r.descripcion from roles r inner join "+table+" a on (a.idrol = r.idrol ) where a." + id + " = ? ";        
        Object[] params = new Object[] { userId }; 
        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
 
        return roles;
    }
     
}
