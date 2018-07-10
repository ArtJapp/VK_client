package ru.startandroid.vk_client.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ru.startandroid.vk_client.Adapters.UserAdapter;
import ru.startandroid.vk_client.R;
import ru.startandroid.vk_client.presenter.FollowerListPresenter;
import ru.startandroid.vk_client.presenter.FriendListPresenter;

public class FollowerListView extends listView{
    FollowerListPresenter presenter;
    RecyclerView FollowerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follower_list_view);
        FollowerList = (RecyclerView) findViewById(R.id.FriendList);
        FollowerList.setLayoutManager(new LinearLayoutManager(this));
        presenter = new FollowerListPresenter(this);
        UserAdapter ua = presenter.getAdapter();
        FollowerList.setAdapter(ua);

    }



    @Override
    public void ShowProgress() {

    }

    @Override
    public void HideProgress() {

    }
}
