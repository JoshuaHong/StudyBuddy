package com.example.josh.studybuddy;

/**
 * Created by ChooA on 3/17/2018.
 */

public class studyEvent {

    private int mBeginTime;
    private int mEndTime;
    private String mLocation;
    private int mMaxPeople;
    private int mCurrentPeople;
    private String mDescription;
    public studyEvent(int begin, int end,String loc, int max, int curr, String desc) {
        mBeginTime = begin;
        mEndTime = end;
        mLocation = loc;
        mMaxPeople = max;
        mCurrentPeople = curr;
        mDescription = desc;

    }
    public int getBeginTime(){
        return mBeginTime;
    }
    public int getEndTime(){
        return mEndTime;
    }
    public int getMaxPeople(){
        return mMaxPeople;
    }
    public int getCurrentPeople(){
        return mCurrentPeople;
    }
    public String getLocation(){
        return mLocation;
    }
    public String getDescription(){
        return mDescription;

    }


}

