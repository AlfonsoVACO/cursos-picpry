package com.codehard.miscursos.sesion;

public class AppUser {
	private Long userId;
	private String userName;
	private String tabla;
	private String encrytedPassword;

	public AppUser() {

	}

	public AppUser(Long userId, String userName, String encrytedPassword, String tabla) {
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.tabla = tabla;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}	

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", userName=" + userName + ", tabla=" + tabla + ", encrytedPassword="
				+ encrytedPassword + "]";
	}
}
