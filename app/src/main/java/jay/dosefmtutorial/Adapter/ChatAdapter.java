package jay.dosefmtutorial.Adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import jay.dosefmtutorial.Model.ChatBoatResponse;
import jay.dosefmtutorial.R;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MessageViewHolder> {
    private static final int TYPE_ME = 1;
    private static final int TYPE_THEM = 2;
    private Context context;
    private List<ChatBoatResponse> messages;

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        ImageView personImage;
        TextView message;
        TextView messageDate;

        public MessageViewHolder(View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message_text);
        }
    }


  //  private Conversation conversation;

    public ChatAdapter(Context context) {
        super();
        this.context = context;
        this.messages = new ArrayList<>();
    }

    public void setMessages(List<ChatBoatResponse> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    public void addMessage(ChatBoatResponse message) {
        messages.add(message);
        // Call this instead of notifyItemInserted so we can update timestamps
        notifyDataSetChanged();
    }

    @Override public int getItemViewType(int position) {
        final ChatBoatResponse message = getItem(position);
        if(message.isMe())
        {
            return TYPE_ME;
        }
        else {
            return TYPE_THEM;
        }
    }

    @Override public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View conversationItemView;
        if (viewType == TYPE_ME) {
            conversationItemView = inflater.inflate(R.layout.item_message_me, parent, false);
        } else {
            conversationItemView = inflater.inflate(R.layout.item_message_them, parent, false);
        }
        return new MessageViewHolder(conversationItemView);
    }

    @Override public void onBindViewHolder(MessageViewHolder vh, int position) {
        final ChatBoatResponse message = getItem(position);

        vh.message.setText(message.getMessage());
        if (message.isMe()) {
            vh.message.setBackgroundColor(ContextCompat.getColor(context, R.color.primary_light));
        } else {
            vh.message.setBackgroundColor(ContextCompat.getColor(context, R.color.accent_light));
        }


    }

    public ChatBoatResponse getItem(int position) {
        return messages.get(position);
    }

    @Override public int getItemCount() {
        return messages.size();
    }


}
