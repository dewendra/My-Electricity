package com.example.electricitybill;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {
//String houseadapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*Spinner spinner= (Spinner) findViewById(R.id.houseNameSpinner);
		spinner.setOnItemSelectedListener(this);*/
		addHouseNameSpinner();
		//addPersonNameSpinner();
		//addAddressNameSpinner();
		
		System.out.println("Line added for test");
		
	}

	private void addHouseNameSpinner() {
		Spinner spinner= (Spinner) findViewById(R.id.houseNameSpinner);
		spinner.setOnItemSelectedListener(this);
		
		
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("Delhi");
		list.add("Mumbai");
		list.add("Chennai");
		list.add("Kolkata");
		
		ArrayAdapter<String> houseadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
		houseadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(houseadapter);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
