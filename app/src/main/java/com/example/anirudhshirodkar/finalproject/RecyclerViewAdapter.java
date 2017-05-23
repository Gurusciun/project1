package com.example.anirudhshirodkar.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {



    private ArrayList<DataModel> mModals;
    private FragmentManager mFm;

    Context ctx;


    public RecyclerViewAdapter(Context context, ArrayList<DataModel> Modals){
        mModals = Modals;
        ctx=context;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_display, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        DataModel dataModel =mModals.get(position);

        holder.mPhoneView.setText(mModals.get(position).getName());
        holder.mContactsNameView.setText(mModals.get(position).getVersion());
        holder.imageView.setImageResource(mModals.get(position).getImage());



    }

    @Override
    public int getItemCount() {
        return mModals.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {

        TextView mContactsNameView;
        TextView mPhoneView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mContactsNameView = (TextView) itemView.findViewById(R.id.nameView);
            mPhoneView = (TextView) itemView.findViewById(R.id.phoneNumberView);
            imageView=(ImageView)itemView.findViewById(R.id.image1);

            itemView.setOnClickListener(this);

            String contact=  mContactsNameView.getText().toString();
            String phone=  mPhoneView.getText().toString();


        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) {

                DataModel dataModel =mModals.get(position);

                Context context = v.getContext();

                imageView.buildDrawingCache();
                Bitmap image= imageView.getDrawingCache();

                Intent intent = new Intent(context, SecondActivity.class);


                Bundle bundle=new Bundle();
                bundle.putParcelable("imagebitmap", image);

                bundle.putString("text1",mModals.get(position).getName());
                bundle.putString("text2",mModals.get(position).getVersion());
                bundle.putInt("text3",mModals.get(position).getImage());


                intent.putExtras(bundle);

                context.startActivity(intent);

                // We can access the data within the views

            }
        }
    }
    @Override
    public int getItemViewType(int position) {




        return position;





    }


}
