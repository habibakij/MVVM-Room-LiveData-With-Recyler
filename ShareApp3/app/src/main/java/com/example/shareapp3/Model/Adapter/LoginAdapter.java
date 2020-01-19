package com.example.shareapp3.Model.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shareapp3.Model.LoginEntity;
import com.example.shareapp3.R;
import com.example.shareapp3.ViewModel.LoginViewModel;

import java.util.List;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.LoginViewHolder> {
    private Context mContext;
    List<LoginEntity> loginEntities;

    public LoginAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LoginViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.all_item, parent, false);
        return new LoginViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoginViewHolder holder, int position) {
        if (loginEntities!= null){
            LoginEntity loginEntity= loginEntities.get(position);
            holder.textView.setText(loginEntity.getUserEmail());
            Log.d("what happend",holder.textView.getText().toString());
        } else {
            holder.textView.setText("you hava no data");
        }
    }

    @Override
    public int getItemCount() {
        if (loginEntities!=null) {
            return loginEntities.size();
        }else {
            return 0;
        }
    }

    public void setUserData(List<LoginEntity> loginEntity){
        loginEntities= loginEntity;
        notifyDataSetChanged();
    }

    public class LoginViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public LoginViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.showEmail);
        }
    }
}
