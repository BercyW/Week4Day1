package security.bercy.com.week4day1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bercy on 12/19/17.
 */

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder> {
    List<User> userList;

    public userAdapter(List<User> userList) {
        this.userList = userList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_recycler);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textView.setText(user.getName()+"---"+user.getLocation()+"---"+user.getCompany());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
