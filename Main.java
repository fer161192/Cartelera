package paquete_cartelera;
import java.util.List;
import java.util.ArrayList;

public class Main {
	
	public static void mostrarAutenticado(boolean autenticado_ingreasado) {
		if (autenticado_ingreasado) {
			System.out.println("Usted es empleado del hostel, autenticado exitoso");
		}
		else {
			System.out.println("Error al autenticar el usuario. Usted no es empleado.");
		}
	}
	
	public static void mostrarMensajeDeCierreDeSistema(boolean mensaje_cierre_ingresado) {
		if (mensaje_cierre_ingresado) {
			System.out.println("El sistema se ha cerrado con exito");
		}
		else
			System.out.println("Usted no puede cerrar el sistema debido a que usted no es empleado/a");
	}

	public static void mostrarMensajeDeCierreDeSesion(boolean mensaje_cierre_ingresado) {
		if (mensaje_cierre_ingresado) {
			System.out.println("La sesión, ha sido cerrada con éxito.");
		}
	}
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		Usuario fernando = new Usuario("Fernando","Asesinosilen1611",true);
		Usuario luciano = new Usuario("Luciano","walda0310",true);
		Usuario walda = new Usuario("Walda","teresa2134",true);
		Usuario ramon = new Usuario("Ramon","jasper1301",true);
		Usuario micaela = new Usuario("Micaela","homero1306",false);
		
		sistema.registrarUsuario(fernando);
		sistema.registrarUsuario(luciano);
		sistema.registrarUsuario(walda);
		sistema.registrarUsuario(ramon);
		sistema.registrarUsuario(micaela);

		//Micaela abre el sistema con el fin de mandar mensajes
		boolean autenticado = sistema.autenticarUsuario(micaela);
		mostrarAutenticado(autenticado);
		
		//Micaela le envia un mensaje a Fernando
		sistema.enviarMensaje(new Mensaje("Hola fer, como estas?",micaela,fernando));
		
		//Micaela le manda un mensaje a Walda
		sistema.enviarMensaje(new Mensaje("Hola tere, como esta?",micaela,walda));
		
		//Micaela le envia otro mensaje a Fernando
		sistema.enviarMensaje(new Mensaje("Sabes si mi reserva ya esta lista?",micaela,fernando));
		
		//Micaela verifica sus mensajes enviados
		List<Mensaje> mensajes_enviados =  sistema.obtenerMensajesEnviados();
		System.out.println("La lista de mensajes enviadas por micaela son: ");
		for (int i = 0; i<mensajes_enviados.size();i++) {
			System.out.println(mensajes_enviados.get(i).getContenido_mensaje()+" fue enviado a "+
				mensajes_enviados.get(i).getDestinatario().getNombre_usuario()+
				" para la fecha de "+mensajes_enviados.get(i).getFechaEnvio());
		}
		
		//Micaela va intentar cerrar el sistema
		boolean mensaje_cierre_sistema = sistema.cerrarSistema();
		
		//Como Micaela NO ES una empleada, el sistema le tirará un mensaje avisandole que ella no puede cerrarlo
		mostrarMensajeDeCierreDeSistema(mensaje_cierre_sistema);
		
		//Micaela solo se limitará a cerrar su sesión
		boolean mensaje_cierre_sesion = sistema.cerrarSesion();
		mostrarMensajeDeCierreDeSesion(mensaje_cierre_sesion);

		//Fernando abre el sistema con el fin de mandar mensajes, ver los mensajes que envio y recibio
		sistema.autenticarUsuario(fernando);
		
		//Fernando le manda un mensaje a Walda
		sistema.enviarMensaje(new Mensaje("Hola ma!!!! Como estas?",fernando,walda));
		
		//Fernando verifica sus mensajes enviados
		mensajes_enviados = sistema.obtenerMensajesEnviados();
		System.out.println("La lista de mensajes enviados por Fernando son: ");
		for (int i = 0; i<mensajes_enviados.size();i++) {
			System.out.println(mensajes_enviados.get(i).getContenido_mensaje()+" fue enviado a "+
				mensajes_enviados.get(i).getDestinatario().getNombre_usuario()+
				" para la fecha de "+mensajes_enviados.get(i).getFechaEnvio());
		}
		
		//Fernando verifica sus mensajes recibidos
		List<Mensaje> mensajes_recibidos = sistema.obtenerMensajesRecibidos();
		System.out.println("La lista de mensajes recibidos de Fernando son: ");
		for (int i = 0; i<mensajes_recibidos.size();i++) {
			System.out.println("El mensaje recibido "+mensajes_recibidos.get(i).getContenido_mensaje()+" fue enviado por parte de "+
				mensajes_recibidos.get(i).getRemitente().getNombre_usuario()+
				" para la fecha de "+mensajes_recibidos.get(i).getFechaEnvio());
		}
		
		//Fernando cerrará el sistema porque es empleado y automaticamente, cierra su sesion
		mensaje_cierre_sistema = sistema.cerrarSistema();
		mostrarMensajeDeCierreDeSistema(mensaje_cierre_sistema);
	}

}
