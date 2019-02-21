package jay.dosefmtutorial.Presenter;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import jay.dosefmtutorial.Api.NetworkClient;
import jay.dosefmtutorial.Api.NetworkInterface;
import jay.dosefmtutorial.ViewsCallBack.HomeActivityViewInterface;
import jay.dosefmtutorial.Model.ChatBoat;

public class HomeActivityPresenter implements HomeActivityPresenterInterface {
    String TAG = "HomeActivityPresenter";
    HomeActivityViewInterface homeActivityViewInterface;


    public HomeActivityPresenter(HomeActivityViewInterface homeActivityViewInterface)
    {
        this.homeActivityViewInterface = homeActivityViewInterface;
    }

    @Override
    public void getResponse(String message) {
        getObservable(message).subscribeWith(getObserver());
    }

    public Observable<ChatBoat> getObservable(String message){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getChatResponse("TR7KmJSoOHHxvsft",message,"6526","rishabh876")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ChatBoat> getObserver(){
        return new DisposableObserver<ChatBoat>() {

            @Override
            public void onNext(@NonNull ChatBoat movieResponse) {
                Log.i(TAG,"this is value OnNext"+movieResponse.getChatBoatResponse().getMessage());
                homeActivityViewInterface.updateRecyclerview(movieResponse.getChatBoatResponse());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG,"this is value Error"+e);
                //  e.printStackTrace();
                //  mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.i(TAG,"this is value Completed");
                //  mvi.hideProgressBar();
            }
        };
    }
}
