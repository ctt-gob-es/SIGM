package es.ieci.tecdoc.isicres.admin.estructura.beans;

import java.util.Date;

public class Departamento {

	public static final int LDAP_DEPT_TYPE = 2;
	public static final int SICRES_DEPT_TYPE = 1;
	public static final int INVESDOC_DEPT_TYPE = 0;

   private int _userConnected;
   private int _id;
   private String _name;
   private int _parentId;
   private int _managerId;
   private int _type;
   private String _description;
   private int _creatorId;
   private Date _creationDate;
   private int _updaterId;
   private Date _updateDate;
   private PermisosGenericos _permsImpl;
   //private GenericPermsImpl _permsImpl;
   private Usuarios _users;
   //private Users _users;
   private UsuariosBasicos _adminUsers;
   //private BasicUsersImpl _adminUsers;
   
   
   public Departamento() {
	   
   }
   
	public UsuariosBasicos get_adminUsers() {
		return _adminUsers;
	}
	public void set_adminUsers(UsuariosBasicos users) {
		_adminUsers = users;
	}
	public Date get_creationDate() {
		return _creationDate;
	}
	public void set_creationDate(Date date) {
		_creationDate = date;
	}
	public int get_creatorId() {
		return _creatorId;
	}
	public void set_creatorId(int id) {
		_creatorId = id;
	}
	public String get_description() {
		return _description;
	}
	public void set_description(String _description) {
		this._description = _description;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int get_managerId() {
		return _managerId;
	}
	public void set_managerId(int id) {
		_managerId = id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public int get_parentId() {
		return _parentId;
	}
	public void set_parentId(int id) {
		_parentId = id;
	}
	public PermisosGenericos get_permsImpl() {
		return _permsImpl;
	}
	public void set_permsImpl(PermisosGenericos impl) {
		_permsImpl = impl;
	}
	public int get_type() {
		return _type;
	}
	public void set_type(int _type) {
		this._type = _type;
	}
	public Date get_updateDate() {
		return _updateDate;
	}
	public void set_updateDate(Date date) {
		_updateDate = date;
	}
	public int get_updaterId() {
		return _updaterId;
	}
	public void set_updaterId(int id) {
		_updaterId = id;
	}
	public int get_userConnected() {
		return _userConnected;
	}
	public void set_userConnected(int connected) {
		_userConnected = connected;
	}
	public Usuarios get_users() {
		return _users;
	}
	public void set_users(Usuarios _users) {
		this._users = _users;
	}
   
   
	
}
