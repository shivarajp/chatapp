package com.flirtchat.chatapp.adapters;

/**
 * Created by Shivam on 4/23/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.flirtchat.chatapp.R;
import com.flirtchat.chatapp.models.MessagesModel;

import java.util.ArrayList;


/**
 * Created by Shivam on 4/22/2016.
 */
public class ChatAdapter extends BaseAdapter {

    private ArrayList<MessagesModel> messages;
    private Context context;
    private LayoutInflater layoutInflater;

    public ChatAdapter(Context context, ArrayList<MessagesModel> messages) {
        this.context = context;
        this.messages = messages;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.chat_row, null);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvMsg = (TextView) convertView.findViewById(R.id.tvMsg);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(messages.get(position).getName());
        viewHolder.tvMsg.setText(messages.get(position).getMessage());

        return convertView;
    }

    public class ViewHolder {

        TextView tvName, tvMsg;

        public ViewHolder() {

        }
    }
}
