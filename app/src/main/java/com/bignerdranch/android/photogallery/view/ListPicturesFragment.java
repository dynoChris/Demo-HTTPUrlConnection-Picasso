package com.bignerdranch.android.photogallery.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.photogallery.R;
import com.bignerdranch.android.photogallery.model.PictureItem;
import com.bignerdranch.android.photogallery.network.FlickrFetchr;
import com.bignerdranch.android.photogallery.view.adapter.PictureAdapterRecycler;

import java.util.ArrayList;
import java.util.List;

public class ListPicturesFragment extends Fragment {

    private static final String TAG = "PhotoGalleryFragment123";

    private RecyclerView rv;
    private List<PictureItem> pictureItems = new ArrayList<>();

    public static ListPicturesFragment newInstance() {
        return new ListPicturesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchPicturesAsyncTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.picture_gallery_fragment, container, false);
        
        rv = (RecyclerView) v.findViewById(R.id.recycler_view);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 3));

        setupAdapter();

        return v;
    }

    private void setupAdapter() {
        if (isAdded()) {
            rv.setAdapter(new PictureAdapterRecycler(pictureItems));
        }
    }

    private class FetchPicturesAsyncTask extends AsyncTask<Void,Void,List<PictureItem>> {
        @Override
        protected List<PictureItem> doInBackground(Void... params) {
            return new FlickrFetchr().fetchItems();
        }

        @Override
        protected void onPostExecute(List<PictureItem> items) {
            pictureItems = items;
            setupAdapter();
        }
    }
}
