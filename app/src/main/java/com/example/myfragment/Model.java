package com.example.myfragment;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Model implements Parcelable, Serializable {
    private String url;
    private String title;
    private String content;

    public Model(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public Model(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.content);
    }

    protected Model(Parcel in) {
        this.url = in.readString();
        this.title = in.readString();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}

