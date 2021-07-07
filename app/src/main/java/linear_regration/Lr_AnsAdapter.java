package linear_regration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dmdw1.R;

import java.util.List;

public class Lr_AnsAdapter extends RecyclerView.Adapter<Lr_AnsAdapter.MyViewholder> {

    private List<Lr_AnsModel> lrAnsModelList;

    public Lr_AnsAdapter(List<Lr_AnsModel> lrAnsModelList) {
        this.lrAnsModelList =lrAnsModelList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lr_item,parent,false);
        return new Lr_AnsAdapter.MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.setData(lrAnsModelList.get(position).getAt1(),lrAnsModelList.get(position).getAt2(),lrAnsModelList.get(position).getAt3(),lrAnsModelList.get(position).getAt4());
    }

    @Override
    public int getItemCount() {
        return lrAnsModelList.size();
    }


    class MyViewholder extends RecyclerView.ViewHolder{
        TextView x1,x2,x3,x4,x5;



        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            x1=itemView.findViewById(R.id.x_x);
            x2=itemView.findViewById(R.id.sqx_x);
            x3=itemView.findViewById(R.id.y_y);
            x4=itemView.findViewById(R.id.sqy_y);
            x5=itemView.findViewById(R.id.sqx_y);

        }

        private void setData(String x1,String x2,String x3,String x4){
            this.x1.setText(x1);
            this.x2.setText(x2);
            this.x3.setText(x3);
            this.x4.setText(x4);

        }
    }

}
