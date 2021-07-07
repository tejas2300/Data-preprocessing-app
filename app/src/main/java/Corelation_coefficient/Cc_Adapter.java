package Corelation_coefficient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dmdw1.InputAdapter;
import com.example.dmdw1.R;

import java.util.List;

public class Cc_Adapter extends RecyclerView.Adapter<Cc_Adapter.ViewHolder> {


    private List<Cc_Model> ccModelList;

    public Cc_Adapter(List<Cc_Model> ccModelList) {
        this.ccModelList = ccModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ans_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(ccModelList.get(position).getXatbt(), ccModelList.get(position).getYatbt(), ccModelList.get(position).getXyatbt());
    }

    @Override
    public int getItemCount() {
        return InputAdapter.inputModelArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView k1,i1,j1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            k1=itemView.findViewById(R.id.k1);
            i1=itemView.findViewById(R.id.i1);
            j1=itemView.findViewById(R.id.j1);

        }
        private void setData(String k1,String i1,String j1){
            this.k1.setText(k1);
            this.i1.setText(i1);
            this.j1.setText(j1);
        }
    }
}
