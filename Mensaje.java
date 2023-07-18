package paquete_cartelera;
import java.util.Date;

public class Mensaje {
	private String contenido_mensaje;
	private final Date fechaEnvio;
	private final Usuario remitente;
	private final Usuario destinatario;
	
	Mensaje(String contenido_recibido, Usuario remitente_ingresado, Usuario destinatario_ingresado){
		this.contenido_mensaje = contenido_recibido;
		this.fechaEnvio = new Date();
		this.remitente = remitente_ingresado;
		this.destinatario = destinatario_ingresado;
	}
	
	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}
	public String getContenido_mensaje() {
		return this.contenido_mensaje;
	}

	public Usuario getRemitente() {
		return remitente;
	}

	public Usuario getDestinatario() {
		return destinatario;
	}
	
}
