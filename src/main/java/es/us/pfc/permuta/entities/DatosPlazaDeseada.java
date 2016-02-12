package es.us.pfc.permuta.entities;

import java.awt.Point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "datos_plaza_deseada")
public class DatosPlazaDeseada {
	
	private static final long serialVersionUID = 1L;
	
	protected DatosPlazaDeseada(){}
	
	public DatosPlazaDeseada(Point localizacionPlazaDeseada, Provincia provincia){
		this.localizacionPlazaDeseada = localizacionPlazaDeseada;
		this.provincia = provincia;
	}

	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Point localizacionPlazaDeseada;
	
	private Integer radio;
	
	@Valid
	@OneToOne(optional = false)	
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
	
	public Point getLocalizacionPlazaDeseada() {
		return localizacionPlazaDeseada;
	}
	public void setLocalizacionPlazaDeseada(Point localizacionPlazaDeseada) {
		this.localizacionPlazaDeseada = localizacionPlazaDeseada;
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
