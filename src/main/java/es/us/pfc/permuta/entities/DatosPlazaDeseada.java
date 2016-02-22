package es.us.pfc.permuta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "datos_plaza_deseada")
public class DatosPlazaDeseada {
	
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String direccionPlazaDeseada;
	
	private Integer radio;
	
	public DatosPlazaDeseada(){}
	
	public DatosPlazaDeseada(String direccionPlazaDeseada, Provincia provincia){
		this.direccionPlazaDeseada = direccionPlazaDeseada;
		this.provincia = provincia;
	}
	
	@Valid
	@ManyToOne(optional = false)	
	private Provincia provincia;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDireccionPlazaDeseada() {
		return direccionPlazaDeseada;
	}
	public void setDireccionPlazaDeseada(String direccionPlazaDeseada) {
		this.direccionPlazaDeseada = direccionPlazaDeseada;
	}

	// Relacion con la tabla Provincia
	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Integer getRadio() {
		return radio;
	}

	public void setRadio(Integer radio) {
		this.radio = radio;
	}
}
