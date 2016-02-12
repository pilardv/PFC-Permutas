package es.us.pfc.permuta.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "provincia")
public class Provincia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Provincia(){}
	
	public Provincia(String nombre){
		this.nombre = nombre;
	}
	
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String nombre;
	
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
	
}
