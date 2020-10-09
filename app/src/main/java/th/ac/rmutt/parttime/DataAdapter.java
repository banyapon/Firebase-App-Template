package th.ac.rmutt.parttime;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<DataModel> datalist;
    public DataAdapter(List<DataModel> result) {
        this.datalist = result;
    }
    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false));
    }
    @Override
    public void onBindViewHolder(final DataAdapter.DataViewHolder holder, final int position) {
        final DataModel dataModel = datalist.get(position);
        holder.textTitle.setText(dataModel.title);
        holder.textContent.setText(dataModel.content);
        Log.d("PartTime",dataModel.thumbnail);
        //Todo Manage ImageView
        Picasso.with(holder.itemView.getContext()).load(dataModel.thumbnail)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filePath = dataModel.key;
                Intent readActivity = new Intent(v.getContext(),DetailActivity.class);
                readActivity.putExtra("content",dataModel.content);
                readActivity.putExtra("image",dataModel.thumbnail);
                readActivity.putExtra("title", datalist.get(position));
                v.getContext().startActivity(readActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle,textContent;
        ImageView imageView;
        public DataViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.txt_title);
            textContent = itemView.findViewById(R.id.txt_salary);
            imageView = itemView.findViewById(R.id.thumbnail);
        }
    }
}
