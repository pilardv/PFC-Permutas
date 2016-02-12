package es.us.pfc.permuta.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Roles implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	protected Roles(){}
	
	public Roles(String rol, String descripcion, List<Usuario> usuario){
		this.rol = rol;
		this.descripcion = descripcion;
		this.usuario = usuario;
	}
	
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;	
	
	@NotBlank
	private String rol;
	
	private String descripcion;
	
	@Valid
	@ManyToMany(mappedBy = "rol", cascade = CascadeType.ALL)
	private List<Usuario> usuario;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	// Relacion con la tabla UsuariosRoles
			
	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}


}
