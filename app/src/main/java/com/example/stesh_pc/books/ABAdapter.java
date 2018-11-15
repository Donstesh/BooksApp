package com.example.stesh_pc.books;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class ABAdapter extends RecyclerView.Adapter<ABAdapter.ViewHolder> {
    List<Book> books;

    public ABAdapter(List<Book> books) {
        this.books = books;
    }


    @Override
    public ABAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.books_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ABAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(books.get(i).getTitle());
        viewHolder.description.setText(books.get(i).getDescription());
        viewHolder.author.setText(books.get(i).getAuthor());

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public TextView author;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_1);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);
        }
    }

    public void updateList(List<Book> newlist)
    {
        books = new ArrayList<>();
        books.addAll(newlist);

        notifyDataSetChanged();

    }
}
