package br.ufmg.coltec.lolzinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChampionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_list);

        SummonerService service = new RetrofitConfig().getSummonerService();
        Call<List<Champion>> ChampListCall = service.getChampionList();

        ChampListCall.enqueue(new Callback<List<Champion>>() {
            @Override
            public void onResponse(Call<List<Champion>> call, Response<List<Champion>> response) {
                Log.e("dsa","asd");
                List<Champion> champions = response.body();
                //ListView champList = findViewById(R.id.Champions);
                //champList.setAdapter(new ChampionsAdapter(ChampionList.this, champions));

            }

            @Override
            public void onFailure(Call<List<Champion>> call, Throwable t) {
                Log.e("kdw", "dkawodo", t);

            }
        });
    }
}
