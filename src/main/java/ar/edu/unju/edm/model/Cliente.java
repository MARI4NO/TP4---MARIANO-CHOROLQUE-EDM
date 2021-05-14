package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {

	
	private String tipoDeDocumento,nombreApellido,email,password;
	private int nroDocumento,edad,codigoAreaTelefono,nroTelefono;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private LocalDate fechaNacimiento,fechaUltimaCompra;
	
	
	public Cliente() {
		super();
	}

	public Cliente(String tipoDeDocumento, String nombreApellido, String email, String password, int nroDocumento,
			int edad, int codigoAreaTelefono, int nroTelefono, LocalDate fechaNacimiento, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDeDocumento = tipoDeDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.nroDocumento = nroDocumento;
		this.edad = edad;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(String tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
		
	public void generarEdad(){
		if(fechaNacimiento.getYear() > LocalDate.now().getYear()){
			edad = 0;
			return;
		}
		if(LocalDate.now().getMonthValue() > fechaNacimiento.getMonthValue()){
			edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
		}
		else 
			if(LocalDate.now().getMonthValue() == fechaNacimiento.getMonthValue()){
				if(fechaNacimiento.getDayOfMonth() >= LocalDate.now().getDayOfMonth()){
					edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
				}
				else{
					edad = LocalDate.now().getYear() - fechaNacimiento.getYear() - 1;
				}
			}
			else{
				edad = LocalDate.now().getYear() - fechaNacimiento.getYear() - 1;
			}
		}
	
	public String getTiempoDesdeUltimaCompra() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaUltimaCompra, fechaActual);
		return " T Desde Ultima Compra  Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays() ;		
		 	
	}


}


/*public void generarEdad(){
if(LocalDate.now().getMonthValue() > fechaNacimiento.getMonthValue()){
	edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
}
else if(LocalDate.now().getMonthValue() == fechaNacimiento.getMonthValue()){
	if(fechaNacimiento.getDayOfMonth() >= LocalDate.now().getDayOfMonth()){
		edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
	}
	else{
		edad = LocalDate.now().getYear() - fechaNacimiento.getYear() - 1;
	}
}
else{
	edad =*/
