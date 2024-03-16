import javax.swing.JOptionPane;

public class Popup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showInternalMessageDialog(null, "Hello World", "My Message Box", JOptionPane.YES_NO_CANCEL_OPTION);
		String hi = JOptionPane.showInputDialog(null, "Enter your name");
		System.out.println(hi);
		System.out.println(Math.sqrt(121));
	}

}
