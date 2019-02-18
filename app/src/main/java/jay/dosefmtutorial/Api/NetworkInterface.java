package jay.dosefmtutorial.Api;


import io.reactivex.Observable;
import jay.dosefmtutorial.Model.ChatBoat;
import jay.dosefmtutorial.Model.ChatBoatResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anujgupta on 26/12/17.
 */

public interface NetworkInterface {

    @GET("api/ chat/")
    Observable<ChatBoat> getChatResponse(@Query("apiKey") String apiKey, @Query("message") String message, @Query("chatBotID") String chatBotID, @Query("externalID") String externalID);


}
