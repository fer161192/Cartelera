package paquete_cartelera;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre_usuario;
	private String contraseña;
	private	List<Mensaje> mensajes_enviados;
	private List<Mensaje> mensajes_recibidos;
	private boolean es_personal_del_hotel;
	
	public Usuario(String nombre_ingresado,String contraseña_ingresada,boolean es_personal) {
		this.nombre_usuario = nombre_ingresado;
		this.contraseña = contraseña_ingresada;
		this.mensajes_enviados = new ArrayList<Mensaje>();
		this.mensajes_recibidos = new ArrayList<Mensaje>();
		this.es_personal_del_hotel = es_personal;
	}
	
	public String getNombre_usuario() {
		return this.nombre_usuario;
	}
	
	public String getContraseña() {
		return this.contraseña;
	}
	
	public void agregarMensajeEnviado(Mensaje mensaje_enviado_ingresado) {
		this.mensajes_enviados.add(mensaje_enviado_ingresado);
	}
	
	public void agregarMensajeRecibido(Mensaje mensaje_recibido_ingresado) {
		this.mensajes_recibidos.add(mensaje_recibido_ingresado);
	}
	
	public List<Mensaje> getMensajes_recibidos(){
		return this.mensajes_recibidos;
	}
	
	public List<Mensaje> getMensajes_enviados(){
		return this.mensajes_enviados;
	}
	
	public boolean getEs_personal_del_hotel() {
		return this.es_personal_del_hotel;
	}
}
