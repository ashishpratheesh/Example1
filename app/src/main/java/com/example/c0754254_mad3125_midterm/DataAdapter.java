package com.example.c0754254_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private Context mCtx;
    private LayoutInflater inflater;
​
    private List<DataModel> dataList;
​
    public DataAdapter(Context mCtx, List<DataModel> dataList) {
        this.mCtx = mCtx;
        this.dataList = dataList;
    }
​
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.data_item, parent, false);
        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }
​
    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).title);
        holder.launchYear.setText(dataList.get(position).launchYear);
        Picasso.get().load(dataList.get(position).getImageUrl()).into(holder.imageView);
    }
​
    @Override
    public int getItemCount() {
        return dataList.size();
    }
​
        ​
    class DataViewHolder extends RecyclerView.ViewHolder {
​
        TextView title, launchYear;
        ImageView imageView;
​
        public DataViewHolder(View itemView) {
            super(itemView);
​
            title = itemView.findViewById(R.id.title);
            launchYear = itemView.findViewById(R.id.launchYear);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}