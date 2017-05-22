package com.example.electricitybill;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "contactsManager";
	private static final String TABLE_CONTACTS = "contacts";

	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PH_NO = "phone_number";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	// Creating tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String Create_Contacts_Table = "Create Tabe" + TABLE_CONTACTS + "("
				+ KEY_ID + "INTEGER PRIMARY KEY," + KEY_NAME + "TEXT,"
				+ KEY_PH_NO + "TEXT" + ")";
		db.execSQL(Create_Contacts_Table);
		// TODO Auto-generated method stub

	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("Drop Table If Exist" + TABLE_CONTACTS);
		onCreate(db);
	}

	// Adding Contact in Database

	void addContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName()); // Contact Name
		values.put(KEY_PH_NO, contact.getPhone_Number()); // Contact Phone
															// Number // Number
		db.insert(TABLE_CONTACTS, null, values);
		db.close();

	}

	// Getting Single contact
	Contact getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
				KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		return contact;
	}

	// Getting All Contact
	public List<Contact> getAllContact() {
		List<Contact> contactList = new ArrayList<Contact>();
		// select all query
		String selectquery = "SELECT * FROM" + TABLE_CONTACTS;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectquery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Contact contact = new Contact();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setPhone_Number(cursor.getString(2));
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}
		// Return contact List
		return contactList;
	}

	// Updating single Contact

	public int updateContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPhone_Number());
		// updating row
		return db.update(TABLE_CONTACTS, values, KEY_ID + "=?",
				new String[] { String.valueOf(contact.getID()) });
	}

	// Deleting single Contact
	public void deleteContact(Contact contact) {
		SQLiteDatabase db =this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, KEY_ID+"=?", new String[]{String.valueOf(contact.getID())});
		db.close();
	}
	//Getting Contacts count
	public int getContactcounts(){
		String contactquery="SELECT * FROM"+TABLE_CONTACTS;
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.rawQuery(contactquery, null);
		cursor.close();
		return cursor.getCount();
		
		
	}
}
