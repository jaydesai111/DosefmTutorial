package jay.dosefmtutorial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatBoatResponse {
    @SerializedName("chatBotName")
    @Expose
    String chatBotName;
    @SerializedName("chatBotID")
    @Expose
    String chatBotID;
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("emotion")
    @Expose
    String emotion;

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
}
