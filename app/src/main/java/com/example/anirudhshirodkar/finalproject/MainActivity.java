package com.example.anirudhshirodkar.finalproject;

import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;        // Instantiating tabLayout
    private ViewPager viewPager;        // Instantiating viewPager


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("TwoWeekTestProject");

        viewPager = (ViewPager) findViewById(R.id.viewpager); // allows the user to flip left and right through pages of data
        addFragmentsToViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

// This interface is the contract for receiving the results for permission requests.


        switch (requestCode)
        {


            case 20: {
                // The result arrays are empty if the request gets cancelled.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Permission granted so go ahead with the contacts related task.

                }

                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_DENIED)
                {

                    // Permission denied hence disable the functionality that depends on this permission
                }
                return;
            }

            // Check for the permissions this app requests for.
        }

    }



    private void addFragmentsToViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1(), "TAB1");
        adapter.addFragment(new Fragment2(), "TAB2");
        viewPager.setAdapter(adapter);
    }
}
