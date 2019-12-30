package com.example.ashik.studentbudgetmanagement;


import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.Toast;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import static android.os.Build.VERSION_CODES.M;
import static com.example.ashik.studentbudgetmanagement.R.id.nav_add;
import static com.example.ashik.studentbudgetmanagement.R.id.show_database;

public class MainActivity  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    DatabaseHandler db;
    EditText editData;
    Button saveButton;

    //Button viewExpenses;

    FragmentTransaction fragmentTransaction;

    Button showDatabase;

    //Button viewDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawar);

        db =new DatabaseHandler(this);

        //viewDatabase = (Button) findViewById(R.id.show_database);
        showDatabase =(Button) findViewById(R.id.show_database);


        //viewExpenses = (Button) findViewById(R.id.nav_view);

        editData = (EditText)findViewById(R.id.textfld);
        saveButton = (Button) findViewById(R.id.saveb);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout) ;
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle
                (this,drawerLayout,toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);



        Button b = (Button) findViewById(R.id.foodingb);
        Button b1 = (Button) findViewById(R.id.rechargeb);
        Button b2 = (Button) findViewById(R.id.shoppingb);
        Button b3 = (Button) findViewById(R.id.transportb);
        Button b4 = (Button) findViewById(R.id.othrexng);
        Button b5 = (Button) findViewById(R.id.moneyexb);

        //button1 = (Button)findViewById(R.id.calendarb);
        //button1.setOnClickListener();


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.popup_window, null);

                final EditText mAmount = (EditText) mView.findViewById(R.id.textfld);

                Button mSave = (Button) mView.findViewById(R.id.saveb);
                Button calenderButton = (Button) mView.findViewById(R.id.calendarb);

                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!mAmount.getText().toString().isEmpty()) {
                            boolean isInserted = db.insertData(mAmount.getText().toString(),"","","","","");

                            if(isInserted==true)
                                Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();

                            else
                                Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    R.string.Error_mssg,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }


                });

                calenderButton.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {
                        final AlertDialog.Builder calBuilder = new AlertDialog.Builder(MainActivity.this);
                        View calView = getLayoutInflater().inflate(R.layout.calendar_layout, null);
                        calBuilder.setView(calView);
                        final AlertDialog d=calBuilder.create();

                        DatePicker pick=(DatePicker)calView.findViewById(R.id.date);
                        Button btn=(Button)calView.findViewById(R.id.okButton);
                        Calendar cal=Calendar.getInstance();
                        pick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //date pick
                                d.dismiss();
                            }
                        });
                        calBuilder.show();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.popup_window, null);

                final EditText mAmount = (EditText) mView.findViewById(R.id.textfld);

                Button mSave = (Button) mView.findViewById(R.id.saveb);
                Button calenderButton = (Button) mView.findViewById(R.id.calendarb);

                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!mAmount.getText().toString().isEmpty()) {
                            boolean isInserted = db.insertData("",mAmount.getText().toString(),"","","","");

                            if(isInserted==true)
                                Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();

                            else
                                Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    R.string.Error_mssg,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }


                });

                calenderButton.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {
                        final AlertDialog.Builder calBuilder = new AlertDialog.Builder(MainActivity.this);
                        View calView = getLayoutInflater().inflate(R.layout.calendar_layout, null);
                        calBuilder.setView(calView);
                        final AlertDialog d=calBuilder.create();

                        DatePicker pick=(DatePicker)calView.findViewById(R.id.date);
                        Button btn=(Button)calView.findViewById(R.id.okButton);
                        Calendar cal=Calendar.getInstance();
                        pick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //date pick
                                d.dismiss();
                            }
                        });
                        calBuilder.show();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.popup_window, null);

                final EditText mAmount = (EditText) mView.findViewById(R.id.textfld);

                Button mSave = (Button) mView.findViewById(R.id.saveb);
                Button calenderButton = (Button) mView.findViewById(R.id.calendarb);

                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!mAmount.getText().toString().isEmpty()) {
                            boolean isInserted = db.insertData("","",mAmount.getText().toString(),"","","");

                            if(isInserted==true)
                                Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();

                            else
                                Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    R.string.Error_mssg,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }


                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.popup_window, null);

                final EditText mAmount = (EditText) mView.findViewById(R.id.textfld);

                Button mSave = (Button) mView.findViewById(R.id.saveb);
                Button calenderButton = (Button) mView.findViewById(R.id.calendarb);

                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!mAmount.getText().toString().isEmpty()) {
                            boolean isInserted = db.insertData("","","",mAmount.getText().toString(),"","");

                            if(isInserted==true)
                                Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();

                            else
                                Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    R.string.Error_mssg,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }


                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.popup_window, null);

                final EditText mAmount = (EditText) mView.findViewById(R.id.textfld);

                Button mSave = (Button) mView.findViewById(R.id.saveb);
                Button calenderButton = (Button) mView.findViewById(R.id.calendarb);

                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!mAmount.getText().toString().isEmpty()) {
                            boolean isInserted = db.insertData("","","","",mAmount.getText().toString(),"");

                            if(isInserted==true)
                                Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();

                            else
                                Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    R.string.Error_mssg,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }


                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder bBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.exchange_layout, null);

                Button bBorrow = (Button) mView.findViewById(R.id.btBorrow);
                Button bLend = (Button) mView.findViewById(R.id.btLend);

                bBorrow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                        View mView = getLayoutInflater().inflate(R.layout.popup_window, null);

                        final EditText mAmount = (EditText) mView.findViewById(R.id.textfld);

                        Button mSave = (Button) mView.findViewById(R.id.saveb);
                        Button calenderButton = (Button) mView.findViewById(R.id.calendarb);

                        mSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (!mAmount.getText().toString().isEmpty()) {
                                    boolean isInserted = db.insertData(mAmount.getText().toString(),"","","","","");

                                    if(isInserted==true)
                                        Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();

                                    else
                                        Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this,
                                            R.string.Error_mssg,
                                            Toast.LENGTH_SHORT).show();
                                }
                            }


                        });

                        mBuilder.setView(mView);
                        AlertDialog dialog = mBuilder.create();
                        dialog.show();

                    }
                });

                bLend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                        View mView = getLayoutInflater().inflate(R.layout.popup_window, null);

                        final EditText mAmount = (EditText) mView.findViewById(R.id.textfld);

                        Button mSave = (Button) mView.findViewById(R.id.saveb);

                        mSave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (!mAmount.getText().toString().isEmpty()) {
                                    Toast.makeText(MainActivity.this,
                                            R.string.Succes_mssg,
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this,
                                            R.string.Error_mssg,
                                            Toast.LENGTH_SHORT).show();
                                }
                            }


                        });
                        mBuilder.setView(mView);
                        AlertDialog dialog = mBuilder.create();
                        dialog.show();

                    }
                });

                bBuilder.setView(mView);
                AlertDialog dialog = bBuilder.create();
                dialog.show();
            }
        });

        /*showDatabase.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Cursor res = db.viewData();
                                                if(res.getCount() == 0){

                                                    showMessage("error","Nothing Found");
                                                    return;
                                                }

                                                StringBuffer buffer = new StringBuffer();
                                                while(res.moveToNext()){
                                                    buffer.append("SERIAL :"+ res.getString(0)+"\n");
                                                    buffer.append("FOODING :"+ res.getString(1)+"\n");
                                                    buffer.append("RECHARGE :"+ res.getString(2)+"\n");
                                                    buffer.append("SHOPPING :"+ res.getString(3)+"\n");
                                                    buffer.append("TRANSPORT :"+ res.getString(4)+"\n");
                                                    buffer.append("EXCHANGE :"+ res.getString(5)+"\n");
                                                    buffer.append("OTHER :"+ res.getString(6)+"\n\n");

                                                }

                                                showMessage("Data",buffer.toString());

                                            }
    });*/

    }


    /*private void ClickMe(){
        String fooding =
    }*/


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }




    //Navigation Drawer
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.nav_add:


                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new HomeFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("DataBase Layout");
                item.setChecked(true);


                break;

            case R.id.nav_reset:

               // Toast.makeText(getApplicationContext(),"Reset Budget",Toast.LENGTH_SHORT).show();

                break;

            case R.id.nav_view:
                //Toast.makeText(getApplicationContext(),"View Expenses",Toast.LENGTH_SHORT).show();
                Cursor res = db.viewData();
                if(res.getCount() == 0){

                    showMessage("error","Nothing Found");
                }else {

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("SERIAL :" + res.getString(0) + "\n");
                        buffer.append("FOODING :" + res.getString(1) + "\n");
                        buffer.append("RECHARGE :" + res.getString(2) + "\n");
                        buffer.append("SHOPPING :" + res.getString(3) + "\n");
                        buffer.append("TRANSPORT :" + res.getString(4) + "\n");
                        buffer.append("EXCHANGE :" + res.getString(5) + "\n");
                        buffer.append("OTHER :" + res.getString(6) + "\n\n");

                    }

                    showMessage("Data", buffer.toString());
                    break;
                }

            case R.id.nav_save:
                Toast.makeText(getApplicationContext(),"Save Data",Toast.LENGTH_SHORT).show();

                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }

}

