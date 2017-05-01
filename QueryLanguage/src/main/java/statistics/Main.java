package statistics;

import statistics.matcher.QueryBuilder;
import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        
        QueryBuilder query = new QueryBuilder();
        Matcher m4 = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m4)) {
            System.out.println(player);
        }
        System.out.println("\n-------------------------------");

        Matcher m5 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m6 = query.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m7 = query.oneOf(m5, m6).build();
        
        for (Player player : stats.matches(m7)) {
            System.out.println(player);
        }
    }
}
