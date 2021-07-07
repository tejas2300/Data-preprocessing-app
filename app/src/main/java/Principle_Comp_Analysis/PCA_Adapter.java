package Principle_Comp_Analysis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dmdw1.R;

import java.util.List;

public class PCA_Adapter extends RecyclerView.Adapter<PCA_Adapter.ViewHolder> {

    private List<PCA_Model> ans2ModelList;

    public PCA_Adapter(List<PCA_Model> ans2ModelList) {
        this.ans2ModelList = ans2ModelList;
    }

    @NonNull
    @Override
    public PCA_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ans2_item,parent,false);
        return new PCA_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PCA_Adapter.ViewHolder holder, int position) {
        holder.setData(ans2ModelList.get(position).getAt1(),ans2ModelList.get(position).getAt2(),ans2ModelList.get(position).getAt3(),ans2ModelList.get(position).getAt4(),ans2ModelList.get(position).getAt5());

    }

    @Override
    public int getItemCount() {
        return ans2ModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView x1,x2,x3,x4,x5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            x1=itemView.findViewById(R.id.x_x);
            x2=itemView.findViewById(R.id.sqx_x);
            x3=itemView.findViewById(R.id.y_y);
            x4=itemView.findViewById(R.id.sqy_y);
            x5=itemView.findViewById(R.id.sqx_y);

        }
        private void setData(String x1,String x2,String x3,String x4,String x5){
            this.x1.setText(x1);
            this.x2.setText(x2);
            this.x3.setText(x3);
            this.x4.setText(x4);
            this.x5.setText(x5);

        }
    }

}
