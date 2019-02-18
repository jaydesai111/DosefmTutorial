package jay.dosefmtutorial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatBoat {
    @SerializedName("message")
    @Expose
    ChatBoatResponse chatBoatResponse;

    public ChatBoat()
    {

    }

    public ChatBoatResponse getChatBoatResponse() {
        return chatBoatResponse;
    }

    public void setChatBoatResponse(ChatBoatResponse chatBoatResponse) {
        this.chatBoatResponse = chatBoatResponse;
    }
}
