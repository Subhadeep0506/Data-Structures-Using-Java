package others.greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {
  public static void main(String[] args) {
    ArrayList<Activity> activityList = new ArrayList<>();
    activityList.add(new Activity("A1", 0, 6));
    activityList.add(new Activity("A2", 3, 4));
    activityList.add(new Activity("A3", 1, 2));
    activityList.add(new Activity("A4", 5, 8));
    activityList.add(new Activity("A5", 5, 7));
    activityList.add(new Activity("A6", 8, 9));

    ActivitySelectionHelper.activitySelection(activityList);
  }
}

class Activity {
  private String name;
  private int startTime;
  private int finishTime;

  public Activity(String name, int startTime, int finishTime) {
    this.name = name;
    this.startTime = startTime;
    this.finishTime = finishTime;
  }

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getFinishTime() {
    return finishTime;
  }

  public void setFinishTime(int finishTime) {
    this.finishTime = finishTime;
  }

  // helper functions
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Activity: " + name + ", Start Time: " + startTime + ", Finish Time: " + finishTime;
  }
}

// class responsible for solving activity selection problem
class ActivitySelectionHelper {
  public static void activitySelection(ArrayList<Activity> activityList) {
    Comparator<Activity> finishTimeComparator = new Comparator<Activity>(){
      @Override
      public int compare(Activity o1, Activity o2) {
        return o1.getFinishTime() - o2.getFinishTime();
      }
    };

    Collections.sort(activityList, finishTimeComparator);

    Activity prevActivity = activityList.get(0);
    System.out.println("\nRecommended Schedule:\n" + activityList.get(0));
    for (int i = 1; i < activityList.size(); i++) {
      Activity currActivity = activityList.get(i);
      if (currActivity.getStartTime() >= prevActivity.getFinishTime()) {
        System.out.println(currActivity);
        prevActivity = currActivity;
      }
    }
  }
}
