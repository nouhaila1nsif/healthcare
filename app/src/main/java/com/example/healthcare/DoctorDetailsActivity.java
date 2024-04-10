package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    String[][] doctor_details1 = {
            {"Doctor Name: Alice Smith", "Hospital Address: bbbb", "Exp:10yrs", "Mobile No:1234567", "800"},
            {"Doctor Name: Charlie Lee", "Hospital Address: dddd", "Exp: 15yrs", "Mobile No: 7890123", "1000"},
            {"Doctor Name: David Miller", "Hospital Address: eeee", "Exp: 7yrs", "Mobile No: 4567890", "650"},
            {"Doctor Name: Bob Brown", "456 Elm Street, Chicago, IL 60601", "Exp: 3yrs", "Mobile No: 987-654-3210", "400"},
            {"Doctor Name: Jennifer Miller", "789 Elm Street, Houston, TX 77002", "Exp: 4yrs", "Mobile No: 713-888-7777", "300"}
    };
    String[][] doctor_details2 = {
            {"Doctor Name: Alice Smith", "Hospital Address: bbbb", "Exp:10yrs", "Mobile No:1234567", "800"},
            {"Doctor Name: Charlie Lee", "Hospital Address: dddd", "Exp: 15yrs", "Mobile No: 7890123", "1000"},
            {"Doctor Name: David Miller", "Hospital Address: eeee", "Exp: 7yrs", "Mobile No: 4567890", "650"},
            {"Doctor Name: Bob Brown", "456 Elm Street, Chicago, IL 60601", "Exp: 3yrs", "Mobile No: 987-654-3210", "400"},
            {"Doctor Name: Jennifer Miller", "789 Elm Street, Houston, TX 77002", "Exp: 4yrs", "Mobile No: 713-888-7777", "300"}
    };
    String[][] doctor_details3 = {
            {"Doctor Name: Daniel Moore", "78 Park Avenue, Seattle, WA 98102", "Exp: 13yrs", "Mobile No: 206-333-4444", "800"},
            {"Doctor Name: Susan Baker", "1 Main Street, Denver, CO 80203", "Exp: 9yrs", "Mobile No: 303-222-3333", "550"},
            {"Doctor Name: William Anderson", "345 Park Road, Dallas, TX 75201", "Exp: 11yrs", "Mobile No: 972-111-0000", "650"},
            {"Doctor Name: Susan Baker", "1 Main Street, Denver, CO 80203", "Exp: 9yrs", "Mobile No: 303-222-3333", "550"},
            {"Doctor Name: William Anderson", "345 Park Road, Dallas, TX 75201", "Exp: 11yrs", "Mobile No: 972-111-0000", "650"}
    };
    String[][] doctor_details4 = {
            {"Doctor Name: Matthew Davis", "421 Oak Lane, San Antonio, TX 78204", "Exp: 18yrs", "Mobile No: 210-999-8888", "1200"},
            {"Doctor Name: Elizabeth Garcia", "987 Maple Street, San Diego, CA 92101", "Exp: 6yrs", "Mobile No: 858-000-9999", "400"},
            {"Doctor Name: Jennifer Miller", "789 Elm Street, Houston, TX 77002", "Exp: 4yrs", "Mobile No: 713-888-7777", "300"},
            {"Doctor Name: Susan Baker", "1 Main Street, Denver, CO 80203", "Exp: 9yrs", "Mobile No: 303-222-3333", "550"},
            {"Doctor Name: William Anderson", "345 Park Road, Dallas, TX 75201", "Exp: 11yrs", "Mobile No: 972-111-0000", "650"}
    };
    String[][] doctor_details5 = {
            {"Doctor Name: Christopher Johnson", "12 Park Road, Philadelphia, PA 19103", "Exp: 10yrs", "Mobile No: 215-777-6666", "600"},
            {"Doctor Name: Amanda Williams", "345 Maple Street, Phoenix, AZ 85004", "Exp: 7yrs", "Mobile No: 602-666-5555", "450"},
            {"Doctor Name: Michael Hernandez", "987 Oak Lane, Austin, TX 78704", "Exp: 5yrs", "Mobile No: 512-555-4444", "350"},
            {"Doctor Name: Susan Baker", "1 Main Street, Denver, CO 80203", "Exp: 9yrs", "Mobile No: 303-222-3333", "550"},
            {"Doctor Name: William Anderson", "345 Park Road, Dallas, TX 75201", "Exp: 11yrs", "Mobile No: 972-111-0000", "650"}
    };

    TextView tv;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDtitle);
        btn = findViewById(R.id.buttonLTGoToCart);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        String[][] doctor_details;
        if (title.equals("Family Physicians"))
            doctor_details = doctor_details1;
        else if (title.equals("Dietician"))
            doctor_details = doctor_details2;
        else if (title.equals("Dentist"))
            doctor_details = doctor_details3;
        else if (title.equals("Surgeon"))
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < doctor_details.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", doctor_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"}, new int[]{R.id.line_a,R.id.line_b,R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}
