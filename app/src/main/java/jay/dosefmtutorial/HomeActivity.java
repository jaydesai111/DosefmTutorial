package jay.dosefmtutorial;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import jay.dosefmtutorial.Api.NetworkClient;
import jay.dosefmtutorial.Api.NetworkInterface;
import jay.dosefmtutorial.Model.ChatBoat;
import jay.dosefmtutorial.Model.ChatBoatResponse;
import jay.dosefmtutorial.Presenter.HomeActivityPresenter;

public class HomeActivity extends AppCompatActivity implements HomeActivityViewInterface{
    String TAG = "HomeActivity";
    HomeActivityPresenter homeActivityPresenter;
    @BindView(R.id.message_recycler)
    RecyclerView message_recycler;

    @BindView(R.id.send_message_text)
    EditText send_message_text;

    @BindView(R.id.send_message_button)
    FloatingActionButton send_message_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


    }

    private void setUpPresenter()
    {
     homeActivityPresenter = new HomeActivityPresenter(this);
    }

    private void setupViews(){
        message_recycler.setLayoutManager(new LinearLayoutManager(this));
        send_message_button.setOnClickListener(this::getChatResponse);
    }

    private void getChatResponse(View view) {
        homeActivityPresenter.getResponse();
        }


    @Override
    public void updateRecyclerview(ChatBoatResponse chatBoatResponse) {

    }
}
