package jay.dosefmtutorial.Model;

import android.provider.ContactsContract;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ChatBoatResponse {
    @SerializedName("chatBotName")
    @Expose
    private String chatBotName;
    @SerializedName("chatBotID")
    @Expose
    private String chatBotID;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("emotion")
    @Expose
    private String emotion;
    private transient boolean isMe;
    private Date time;


    public ChatBoatResponse()
    {

    }

    public ChatBoatResponse(String chatBotName, String chatBotID,  String message,String emotion)
    {
        this.chatBotName = chatBotName;
        this.chatBotID = chatBotID;
        this.message = message;
        this.emotion = emotion;
    }

    public String getChatBotName() {
        return chatBotName;
    }

    public void setChatBotName(String chatBotName) {
        this.chatBotName = chatBotName;
    }

    public String getChatBotID() {
        return chatBotID;
    }

    public void setChatBotID(String chatBotID) {
        this.chatBotID = chatBotID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
