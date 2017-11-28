package store;

public class Print {
    public void print (String text) {
	write (text);
    }

    public void print (int text) {
	write (text + "");
    }

    public void println (String text) {
	write (text + "\n");
    }
    
    public void println (int text) {
	write (text + "\n");
    }
    
    private void write (String text) {
	System.out.print(text);
    }
}