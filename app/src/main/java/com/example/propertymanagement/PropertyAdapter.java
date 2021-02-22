package com.example.propertymanagement;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class PropertyAdapter extends FirebaseRecyclerAdapter<PropertyModel, PropertyAdapter.PropertyViewHolder> {

    Context context;
    public PropertyAdapter(@NonNull FirebaseRecyclerOptions<PropertyModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull PropertyViewHolder holder, int position, @NonNull PropertyModel model) {

        holder.tvPlot.setText(model.getPlot());
        holder.tvCust.setText(model.getCust());
        holder.tvPrice.setText(model.getPrice());
        holder.tvCell.setText(model.getCell());
        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DialogPlus dialog = DialogPlus.newDialog(context)
                        .setContentHolder(new ViewHolder(R.layout.property_update_dialog))
                        .setGravity(Gravity.CENTER)
                        .setMargin(50,0,50,0 )
                        .setExpanded(true)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();
                dialog.show();


            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" +model.getPlot(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.property_item, parent, false);

        return new PropertyViewHolder(view);
    }

    public class PropertyViewHolder extends RecyclerView.ViewHolder {

        TextView tvPlot, tvCust, tvPrice, tvCell;
        ImageView ivEdit, ivDelete;
        public PropertyViewHolder(@NonNull View itemView) {

            super(itemView);

            tvPlot = itemView.findViewById(R.id.tvPlot);
            tvCust = itemView.findViewById(R.id.tvCust);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvCell = itemView.findViewById(R.id.tvCell);
        }
    }
}
