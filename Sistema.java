package paquete_cartelera;
import java.util.List;
import java.util.ArrayList;

public class Sistema {

	private ArrayList<Usuario> lista_usuarios;
	private Usuario usuario_actual;
	public Sistema(){
		this.lista_usuarios = new ArrayList<>();
		this.usuario_actual = null;
	}
	
	public void registrarUsuario(Usuario usuario_ingresado) {
		//Registras tanto a huepedes como a personal del hostel
		this.lista_usuarios.add(usuario_ingresado);
	}
	
	public boolean autenticarUsuario (Usuario usuario_ingresado) {
		
		boolean autenticado = false; 
		for (int i = 0; i<this.lista_usuarios.size(); i++) {
			if ((this.lista_usuarios.get(i).getNombre_usuario().equals(usuario_ingresado.getNombre_usuario())) && (this.lista_usuarios.get(i).getContraseña().equals(usuario_ingresado.getContraseña()))) {
				this.usuario_actual = usuario_ingresado;
				autenticado = true;
				break;
			}
		}
		return autenticado;
	}
	
	public void enviarMensaje(Mensaje mensaje_ingresado) {
		Usuario remitente = mensaje_ingresado.getRemitente();
		Usuario destinatario = mensaje_ingresado.getDestinatario();
		//Asumo que siempre lo va encontrar
		if ((this.encontrarUsuario(remitente)) && (this.encontrarUsuario(destinatario))) {
			remitente.agregarMensajeEnviado(mensaje_ingresado);
			destinatario.agregarMensajeRecibido(mensaje_ingresado);
		}
	}
	
	public List<Mensaje> obtenerMensajesEnviados(){
		
		return(this.usuario_actual.getMensajes_enviados());
	}
	
	public List<Mensaje> obtenerMensajesRecibidos(){
		return(this.usuario_actual.getMensajes_recibidos());
	}
	
	public boolean cerrarSistema() {
		
		boolean sistema_cerrado;
		if (this.usuario_actual.getEs_personal_del_hotel()) {
			this.usuario_actual = null;
			this.lista_usuarios.clear();
			sistema_cerrado = true;
		}
		else
			sistema_cerrado = false;
		
		return(sistema_cerrado);
	}
	
	public boolean cerrarSesion() {
		this.usuario_actual = null;
		return true;
	}
	
	private boolean encontrarUsuario(Usuario usuario_ingresado) {
		
		boolean encontrado = false;
		for (int i = 0; i<this.lista_usuarios.size(); i++) {
			if (this.lista_usuarios.get(i).equals(usuario_ingresado)) {
				encontrado = true;
				break;
			}
		}
		return(encontrado);
	}
}
