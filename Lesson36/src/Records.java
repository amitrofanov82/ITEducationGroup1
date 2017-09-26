import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Records extends Notebook{
    private long id;
    private String idString;
    private String message;
    private Date date;

    public Records(String message, int index){
        if(index<2){
            while(index<100) {
                index = (int) (1 + Math.random() * 998);
                if(getRecordById(index)!=null){
                    index=0;
                }
            }
            idString = "110" + index + "";
            this.id = Long.parseLong(idString);
        }else{
            while(index<100) {
                index = (int) (1 + Math.random() * 998);
                if(getRecordById(index)!=null){
                    index=0;
                }
            }
            idString = "120" + index + "";
            this.id = Long.parseLong(idString);
        }
        this.message = message;
        this.date = new Date();
    }

    public Records(Long id, String message, int index){
        if(index<2){
            while(index<100) {
                index = (int) (1 + Math.random() * 998);
            }
            idString = "110" + index + "";
            this.id = Long.parseLong(idString);
        }else{
            while(index<100) {
                index = (int) (1 + Math.random() * 998);
            }
            idString = "120" + index + "";
            this.id = Long.parseLong(idString);
        }
        this.message = message;
        this.date = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageToString() {
        if(message.length()>37){
            if(!(message.substring(34, message.length()).equals("    "))){
                return message.substring(0, 34) + " ...";
            }else {
                return message;
            }
        }else {
            for (int i=0; message.length()<=37; i++){
                message = message + " ";
            }
        }
        return message;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return format.format(date);
    }

    @Override
    public String toString(){
        return "|" + getId() + "| |" + getDate() + "| |" + getMessageToString() + " |";
    }


}
