package com.example.rxjavatest;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TestBean  implements Parcelable {
    @SerializedName("name") String xingming;
    @SerializedName("age")String age;

    protected TestBean(Parcel in) {
        xingming = in.readString();
        age = in.readString();
    }


    public static final Creator<TestBean> CREATOR = new Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel in) {
            return new TestBean(in);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(xingming);
        parcel.writeString(age);
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + xingming + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
