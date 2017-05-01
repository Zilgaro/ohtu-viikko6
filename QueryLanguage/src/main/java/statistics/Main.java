package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasFewerThan(25, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        Matcher m2 = new Or( new HasFewerThan(25, "goals"),
                             new HasFewerThan(15, "assists"),
                             new PlaysIn("PHI")
        );
        
        Matcher m3 = new Not(new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("\n-------------------------------");
        
        for (Player player : stats.matches(m2)) {
            System.out.println( player );
        }
        System.out.println("\n-------------------------------");
        for (Player player : stats.matches(m3)) {
            System.out.println( player );
        }
    }
}
