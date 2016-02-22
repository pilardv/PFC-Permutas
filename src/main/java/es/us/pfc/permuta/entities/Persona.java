package es.us.pfc.permuta.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellidos;
	
	@NotBlank
	private String direccion;
	
	@NotBlank
	private Integer codigoPostal;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^([+-]\\d+\\s+)?(\\([0-9]+\\)\\s+)?([\\d\\w\\s-]+)$")
	private Integer telefono;
	
	private Date fechaNacimiento;
	
	@NotBlank
	private String direccionPlazaActual;
	
	@Valid
	@ManyToOne(optional = false)	
	private Provincia provincia;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private Usuario usuario;
	
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	private List<DatosPlazaDeseada> plazaDeseada;
	
	public Persona(){}
	
	public Persona(String nombre, String apellidos, String direccion, Integer codigoPostal, String email, Integer telefono, Date fechaNacimiento, String direccionPlazaActual, Provincia provincia, Usuario usuario, List<DatosPlazaDeseada> plazaDeseada){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionPlazaActual = direccionPlazaActual;
		this.provincia = provincia;
		this.usuario = usuario;
		this.plazaDeseada = plazaDeseada;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionPlazaActual() {
		return direccionPlazaActual;
	}
	
	public void setDireccionPlazaActual(String direccionPlazaActual) {
		this.direccionPlazaActual = direccionPlazaActual;
	}
	
	// Relacion con la tabla usuario
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// Relacion con la tabla Provincia
	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
		
	// Relacion con la tabla DatosPlazaDeseada
	
	public List<DatosPlazaDeseada> getDatosPlazaDeseada(){
		return plazaDeseada;
	}
	
	public void setDatosPlazaDeseada(List<DatosPlazaDeseada> plazaDeseada){
		this.plazaDeseada = plazaDeseada;
	}
	
}
