package es.us.pfc.permuta.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;	
	
	@NotBlank
	@Size(min = 5, max = 32)
	@Column(unique = true)
	private String nombreUsuario;
	
	@NotBlank
	@Size(min = 5, max = 32)
	private String clave;
	
	@Valid
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Roles> rol;
	
	public Usuario(){}
	
	public Usuario(Usuario usuario){
		this.id = usuario.id;
		this.nombreUsuario = usuario.nombreUsuario;
		this.clave = usuario.clave;
		this.rol = usuario.rol;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
		
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//Relacion con la tabla UsuariosRoles
		
	public List<Roles> getUsuarioRol() {
		return rol;
	}

	public void setUsuarioRol(List<Roles> rol) {
		this.rol = rol;
	}
	
	

}
