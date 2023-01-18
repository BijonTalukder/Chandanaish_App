package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    LinearLayout layout1;
    GridView gridView;
//    private androidx.drawerlayout.widget.DrawerLayout DrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.navmenu);
        layout1=findViewById(R.id.mainlayout);
         drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
         gridView= findViewById(R.id.idGVcourses);
         toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
         drawerLayout.addDrawerListener(toggle);
         toggle.syncState();
         MyAdapter myAdapter= new MyAdapter();
         gridView.setAdapter(myAdapter);
        ImageSlider imageSlider;


        imageSlider =findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();


        imageList.add(new SlideModel(R.drawable.ic_launcher_background, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_launcher_background,null));
        imageList.add(new SlideModel(R.drawable.ic_launcher_background,null));

        imageSlider.setImageList(imageList);
         nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 switch (item.getItemId())
                 {
                     case R.id.menu_home:
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                         layout1.setVisibility(View.VISIBLE);
//                         Log.d("state",getApplicationContext());

//                         drawerLayout.closeDrawers();

                         break;
                     case R.id.setting:
                         drawerLayout.closeDrawer(GravityCompat.START);
                         break;
                 }



                 return true;
             }
         });

    }
    private class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view1= layoutInflater.inflate(R.layout.item,viewGroup,false);
            return view1;
        }
    }

}