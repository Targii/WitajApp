package com.example.adam.witajapp;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by adam on 08.07.15.
 */
public class MyAdapter extends HeaderFooterRecyclerViewAdapter<MyAdapter.HeaderViewHolder, MyAdapter.ContentViewHolder, RecyclerView.ViewHolder> {
    private String[] mDataset;
    private View.OnClickListener onClickListener;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public ImageView mImageView;
        public HeaderViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.my_image_view);

        }




    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mTextImage;
        public LinearLayout mLinearLayout;

        public ContentViewHolder(View v) {
            super(v);
            mLinearLayout = (LinearLayout) v.findViewById(R.id.my_linear_layout);
            mTextView = (TextView) v.findViewById(R.id.my_text_view);
            mTextImage = (ImageView) v.findViewById(R.id.my_text_image);




        }

    }




    // Provide a suitable constructor (depends on the kind of dataset)

    public MyAdapter(String[] myDataset, View.OnClickListener myOnClickListener) {
        onClickListener = myOnClickListener;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)

    public HeaderViewHolder onCreateHeaderItemViewHolder(ViewGroup parent,
                                                   int viewType) {

        // create a new view
        System.out.println("Header viewType: " + viewType);

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.menu_header, parent, false);
            HeaderViewHolder vh = new HeaderViewHolder(v);

            return vh;

    }


    @Override
    protected ContentViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
        System.out.println("conten viewType: " + contentViewType);
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view, parent, false);
        ContentViewHolder vh = new ContentViewHolder(v);
        return vh;
    }

    @Override
    protected void onBindHeaderItemViewHolder(HeaderViewHolder headerViewHolder, int position) {
     headerViewHolder.mImageView.setImageResource(R.drawable.ic_arrow);


    }

    @Override
    protected void onBindContentItemViewHolder(final ContentViewHolder contentViewHolder, final int position){

        contentViewHolder.mTextView.setText(mDataset[position]);
        contentViewHolder.mTextImage.setImageResource(R.drawable.ic_arrow);
        contentViewHolder.mTextView.setTag(position);
        contentViewHolder.mLinearLayout.setTag(position);
        //contentViewHolder.mTextView.setOnClickListener(onClickListener);
        contentViewHolder.mLinearLayout.setOnClickListener(onClickListener);

    }

/*
    public MyAdapter.ViewHolder onCreateFooterItemViewHolderViewGroup ( ViewGroup parent,
    int viewType)    {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
    return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)

    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);

    }
*/
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getHeaderItemCount() {
        return 1;
    }

    @Override
    public int getFooterItemCount() {
        return 0;
    }

    @Override
    protected int getContentItemCount() {
        return mDataset.length;
    }




}