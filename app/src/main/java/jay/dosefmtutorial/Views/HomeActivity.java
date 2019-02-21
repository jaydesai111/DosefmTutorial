package jay.dosefmtutorial.Views;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import jay.dosefmtutorial.Adapter.ChatAdapter;
import jay.dosefmtutorial.ViewsCallBack.HomeActivityViewInterface;
import jay.dosefmtutorial.Model.ChatBoatResponse;
import jay.dosefmtutorial.Presenter.HomeActivityPresenter;
import jay.dosefmtutorial.R;

public class HomeActivity extends AppCompatActivity implements HomeActivityViewInterface {
    String TAG = "HomeActivity";
    HomeActivityPresenter homeActivityPresenter;
    ChatAdapter chatAdapter;
    @BindView(R.id.message_recycler)
    RecyclerView message_recycler;

    @BindView(R.id.send_message_text)
    EditText send_message_text;

    @BindView(R.id.send_message_button)
    FloatingActionButton send_message_button;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setUpPresenter();
        setupViews();
    }

    private void setUpPresenter()
    {
     homeActivityPresenter = new HomeActivityPresenter(this);
    }

    private void setupViews(){
       setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        message_recycler.setLayoutManager(layoutManager);

        chatAdapter = new ChatAdapter(HomeActivity.this);
        message_recycler.setAdapter(chatAdapter);
        send_message_button.setOnClickListener(this::getChatResponse);
    }

    private void getChatResponse(View view)
    {
        if(send_message_text.getText().toString().trim().isEmpty())
        {
            return;
        }
        homeActivityPresenter.getResponse(send_message_text.getText().toString());
        ChatBoatResponse chatBoatResponse = new ChatBoatResponse();
        chatBoatResponse.setMe(true);
        chatBoatResponse.setMessage(send_message_text.getText().toString());
        chatAdapter.addMessage(chatBoatResponse);
        message_recycler.smoothScrollToPosition(chatAdapter.getItemCount());
        send_message_text.setText("");
        }


    @Override
    public void updateRecyclerview(ChatBoatResponse chatBoatResponse) {
        chatBoatResponse.setMe(false);
        chatAdapter.addMessage(chatBoatResponse);
        message_recycler.smoothScrollToPosition(chatAdapter.getItemCount());
    }


}
