package security.bercy.com.week4day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_getUser;
    private TextView textView;
    List<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_getUser = findViewById(R.id.getUser);
        textView = findViewById(R.id.tv_showUser);
        btn_getUser.setOnClickListener(this);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        userAdapter adapter = new userAdapter(userList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        RemoteDataSource.getUser("BercyW").enqueue(new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                textView.setText(response.body().getName()+"\n"+response.body().getType()+"\n"+response.body().getLocation()+"\n"+response.body().getCompany());

                User user = new User();

                user.setName(response.body().getName());
                user.setType(response.body().getType());
                user.setLocation(response.body().getLocation());
                user.setCompany(response.body().getCompany());

                userList.add(user);

            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {

            }
        });
    }
}
