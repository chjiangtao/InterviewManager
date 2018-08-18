package com.example.interviewmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.interviewmanager.R;
import com.example.interviewmanager.entity.InterviewMessage;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<InterviewMessage> messages;
    private OnItemClickListener onItemClickListener;
    public RecyclerViewAdapter(List<InterviewMessage> messages) {
        this.messages = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        InterviewMessage message=messages.get(position);
       holder.companyName.setText(message.getCompanyName());
       holder.date.setText(message.getDate());
       holder.salary.setText(message.getSalary());
       holder.office.setText(message.getOffice());
       holder.address.setText(message.getAddress());
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int pos=holder.getLayoutPosition();
               onItemClickListener.onItemClick(holder.itemView,pos);
           }
       });
    }


    @Override
    public int getItemCount() {
        return messages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView companyName;
        TextView address;
        TextView office;
        TextView salary;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            companyName=itemView.findViewById(R.id.main_fragment_company_name);
            address=itemView.findViewById(R.id.main_fragment_address);
            office=itemView.findViewById(R.id.main_fragment_office);
            salary=itemView.findViewById(R.id.main_fragment_salary);
            date=itemView.findViewById(R.id.main_fragment_date);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
}
