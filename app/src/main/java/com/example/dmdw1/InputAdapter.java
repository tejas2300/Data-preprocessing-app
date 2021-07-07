package com.example.dmdw1;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InputAdapter extends RecyclerView.Adapter<InputAdapter.Myviewholder> {
    private LayoutInflater inflater;
    public static ArrayList<InputModel>inputModelArrayList;

    public InputAdapter(Context ctx, ArrayList<InputModel>inputModelArrayList) {
        inflater=LayoutInflater.from(ctx);
        InputAdapter.inputModelArrayList =inputModelArrayList;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.input_item,parent,false);
        Myviewholder holder =new Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        holder.editText1.setText(inputModelArrayList.get(position).getXvalue());
        holder.editText2.setText(inputModelArrayList.get(position).getYvalue());
        holder.t1.setText(inputModelArrayList.get(position).getXyvalue());

    }

    @Override
    public int getItemCount() {
        return inputModelArrayList.size();
    }


    class Myviewholder extends RecyclerView.ViewHolder{
        EditText editText1,editText2;
        TextView t1;
    public Myviewholder(@NonNull View itemView) {
        super(itemView);
        editText1=(EditText)itemView.findViewById(R.id.x1);
        editText2=(EditText)itemView.findViewById(R.id.y1);
        t1=itemView.findViewById(R.id.textViewsr1);


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputModelArrayList.get(getAdapterPosition()).setXvalue(editText1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputModelArrayList.get(getAdapterPosition()).setYvalue(editText2.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}


}
