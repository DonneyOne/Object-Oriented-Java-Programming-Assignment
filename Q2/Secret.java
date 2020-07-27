import java.io.Serializable; // Dont think there is much explanation needed here. The class implements Serializable.
public class Secret implements Serializable{
	private String message;
	public Secret(String inMessage){
		message = inMessage;
	}
	public String toString() {
		return message;
	}
}