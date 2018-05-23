package beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Message;
import entity.User;
import service.MessageService;
import service.UserService;

@ManagedBean
@SessionScoped
public class MessageBean {
	private List<Message> mensajes;
	
	private MessageService messageService = new MessageService();
	private Message mensajeAEnviar;
	private User usuario;
	public List<Message> getMensajes() {
		mensajes = messageService.list();
		return mensajes;
	}
	public void setMensajes(List<Message> mensajes) {
		this.mensajes = mensajes;
	}
	public User darUsuario(int id){
		return new UserService().getUser(id);
	}
	public Message getMensajeAEnviar() {
		return mensajeAEnviar;
	}
	public void setMensajeAEnviar(Message mensajeAEnviar) {
		usuario = new UserService().getUser(mensajeAEnviar.getIdUser1());
		this.mensajeAEnviar = mensajeAEnviar;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
}
