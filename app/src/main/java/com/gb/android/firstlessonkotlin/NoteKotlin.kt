package com.gb.android.firstlessonkotlin

import android.os.Parcelable
import android.os.Parcel
import android.os.Parcelable.Creator
import java.util.*

/**
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

private String id;
private String title;
private String description;
private int picture;
private boolean done;
private Date date;

public void setDescription(String description) {
this.description = description;
}

public void setPicture(int picture) {
this.picture = picture;
}

public void setDone(boolean done) {
this.done = done;
}

public void setDate(Date date) {
this.date = date;
}

protected Note(Parcel in) {
title = in.readString();
description = in.readString();
picture = in.readInt();
done = in.readByte() != 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
dest.writeString(title);
dest.writeString(description);
dest.writeInt(picture);
dest.writeByte((byte) (done ? 1 : 0));
}

@Override
public int describeContents() {
return 0;
}

public static final Creator<Note> CREATOR = new Creator<Note>() {
@Override
public Note createFromParcel(Parcel in) {
return new Note(in);
}

@Override
public Note[] newArray(int size) {
return new Note[size];
}
};

public void setTitle(String title) {
this.title = title;
}

public Date getDate() {
return date;
}

public Note(String title, String description, int picture, boolean done, Date date){
this.title = title;
this.description=description;
this.picture=picture;
this.done = done;
this.date = date;
}

public String getTitle() {
return title;
}

public String getDescription() {
return description;
}

public int getPicture() {
return picture;
}

public boolean isDone() {
return done;
}

public void setChecked(boolean done) {
}
}
 */
// конвертация части кода из Java в Kotlin
class NoteKotlin : Parcelable {
    var id: String? = null
    var title: String?
    var description: String?
    var picture: Int
    var isDone: Boolean
    var date: Date? = null

    protected constructor(`in`: Parcel) {
        title = `in`.readString()
        description = `in`.readString()
        picture = `in`.readInt()
        isDone = `in`.readByte().toInt() != 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(description)
        dest.writeInt(picture)
        dest.writeByte((if (isDone) 1 else 0).toByte())
    }

    override fun describeContents(): Int {
        return 0
    }

    constructor(title: String?, description: String?, picture: Int, done: Boolean, date: Date?) {
        this.title = title
        this.description = description
        this.picture = picture
        isDone = done
        this.date = date
    }

    fun setChecked(done: Boolean) {}

    companion object {
        val CREATOR: Creator<NoteKotlin?> = object : Creator<NoteKotlin?> {
            override fun createFromParcel(`in`: Parcel): NoteKotlin? {
                return NoteKotlin(`in`)
            }

            override fun newArray(size: Int): Array<NoteKotlin?> {
                return arrayOfNulls(size)
            }
        }
    }

    object CREATOR : Creator<NoteKotlin> {
        override fun createFromParcel(parcel: Parcel): NoteKotlin {
            return NoteKotlin(parcel)
        }

        override fun newArray(size: Int): Array<NoteKotlin?> {
            return arrayOfNulls(size)
        }
    }
}