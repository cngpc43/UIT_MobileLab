package com.example.lab2_ex6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private ArrayList<Employee> employees;

    public EmployeeAdapter(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.tvName.setText(employee.name);
        holder.icManager.setVisibility(employee.isManager ? View.VISIBLE : View.GONE);

            if (!employee.isManager) {
                holder.tvPosition.setText("Staff");
            }
        if (position%2==0)
        {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvName;
        ImageView icManager;
        TextView tvPosition;
        LinearLayout llParent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            icManager = itemView.findViewById(R.id.icManager);
            tvPosition = itemView.findViewById(R.id.tv_position);
            llParent = itemView.findViewById(R.id.llParent);
        }
    }
}