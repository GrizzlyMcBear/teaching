package com.example.progressdialog;

import android.util.Log;

/** This is the 1st way of writing concurrent code:
 * we create a new class which extends (inherits) from {@link Thread}.
 *
 * @implNote The 2nd way of writing concurrent code is to write a new class which implements the
 * {@link Runnable} interface (not shown here).<br/>
 * <b>The most important difference</b> between those ways is in the second one we create the runnable
 * object at the start, pass it to a new <a href="https://developer.android.com/reference/java/lang/Thread#Thread(java.lang.Runnable)">Thread c'tor</a>
 * and from that moment on - we use the newly created thread object. */
public class Progress extends Thread {

    // Fields with no special importance
    int age;
    String pName;
    
    // Tag to assist recognizing the logcat output
    public static final String PROGRESS_TAG = "progress_testing_tag";

    // C'tors
    public Progress() {
        this(0, "");
    }
    public Progress(int age) {
        this(age, "");
    }
    public Progress(int age, String pName) {
        super();
        setAge(age);
        setpName(pName);
    }

    // Setters and Getters
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0)
            this.age = age;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }

    /** This is the most important method in this class, by writing it we enable our code to run
     * concurrently on multiple threads and to seem as if it runs in a "parallel" manner. */
    @Override
    public void run() {
        for (int direction = 0; direction < 10; direction++) {
            Log.i(PROGRESS_TAG, String.format("Thread: %s, Progress: %s, pName: %s, Age: %d",
                    Thread.currentThread().toString(), Progress.currentThread().toString(),
                    this.getpName(), this.getAge()));
            this.age++;
            try {
                Progress.sleep(1000);// Order the thread to temporarily cease execution for 2 seconds
                //Progress.sleep(0, 0);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}